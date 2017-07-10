package com.agit.crm.infrastructure.component.xls;

import com.agit.crm.infrastructure.component.IXLSReader;
import com.agit.crm.infrastructure.component.annotation.WritableValue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class XlsReader<T> implements IXLSReader<T> {

    private Workbook workbook = null;

    private final Class<T> clazz;

    public XlsReader(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> getJavaObjectFromThisFile(String filePath) throws FileNotFoundException, IOException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {

        List<T> tmp = new ArrayList<>();

        /*create file object*/
        try (FileInputStream fs = createFileStream(filePath)) {

            /*create workbook from current stream*/
            if (filePath.substring(filePath.length() - 1).equals("x")) {
                workbook = new XSSFWorkbook(fs);/*xlsx*/

            } else {
                workbook = new HSSFWorkbook(fs);/*xls*/

            }

            /*calculate number of sheets*/
            int numberOfSheets = workbook.getNumberOfSheets();

            /*iterate thru number of sheets*/
            for (int i = 0; i < numberOfSheets; i++) {
                /*manipulate excel object*/
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                int z = 0;

                //iterating over each row
                while (rowIterator.hasNext()) {
                    /*skip 1st row*/
                    if (z == 0) {
                        z++;
                        rowIterator.next();
                        continue;
                    }

                    /*crate instance of the payload - Class<T>*/
                    T object = clazz.newInstance();

                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();
                    int y = 0;

                    /*collect setter of the record*/
                    Set<Method> setterMethods = ReflectionUtils
                            .getAllMethods(clazz,
                                    withModifier(Modifier.PUBLIC),
                                    withPrefix("set"),
                                    withAnnotation(WritableValue.class));

                    /*make it available in framework*/
                    List<Method> list = new ArrayList<>(setterMethods);

                    /*sort by priority index --> column=1,2,3 etc*/
                    Collections.sort(list, new Comparator<Method>() {
                        @Override
                        public int compare(Method a, Method b) {
                            return (a.getAnnotation(WritableValue.class).index())
                                    - (b.getAnnotation(WritableValue.class).index());
                        }
                    });

                    /*make unmodifiable*/
                    list = Collections.unmodifiableList(list);

                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {
                        Cell cell = (Cell) cellIterator.next();
                        list.get(y).invoke(object, checkCellType(cell));
                        y++;
                    }
                    //end iterating a row, add all the elements of a row in list
                    tmp.add(object);
                }
            }
        }
        return tmp;
    }

    @Override
    public List<T> getJavaObjectfromThisStream(String relativeFilePath, Class<T> record) {
        return Collections.EMPTY_LIST;
    }

    /*convert resource stream of file into list of string*/
    private List<String> getArrayOfStringOfThisStream(String relativeFilePath) {
        List<String> inStr = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(relativeFilePath), "UTF-8"));
            /*read line by line*/
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inStr.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return inStr;
    }

    /*convert file stream of file into list of string*/
    private List<String> getArrayOfStringOfThisFile(String filePath) {
        List<String> inStr = new ArrayList<>();
        try {
            File file = new File(filePath);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                /*read line by line*/
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    inStr.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return inStr;
    }

    /*create a file*/
    private FileInputStream createFileStream(String absolutePath) throws IOException {
        return new FileInputStream(new File(absolutePath));
    }

    private Object checkCellType(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
}
