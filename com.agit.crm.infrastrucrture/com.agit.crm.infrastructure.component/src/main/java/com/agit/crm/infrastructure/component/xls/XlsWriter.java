package com.agit.crm.infrastructure.component.xls;

import com.agit.crm.infrastructure.component.IXLSWriter;
import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import java.beans.IntrospectionException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class XlsWriter<T> implements IXLSWriter<T> {

    private final Class<T> clazz;

    private Workbook workbook = null;

    public XlsWriter(Class<T> clazz) {
        this.clazz = clazz;
//        workbook = new XSSFWorkbook();/*xlsx*/
        workbook = new HSSFWorkbook();/*xls*/        

    }

    private List<Field> sortedField(Class<T> clazz) {
        //get getters
        Set<Field> getterMethods = ReflectionUtils
                .getAllFields(clazz,
                        withModifier(Modifier.PRIVATE),
                        withAnnotation(ReadableColumn.class));

        /*put in the List*/
        List<Field> list = new ArrayList(getterMethods);

        /*compare and set priority*/
        Collections.sort(list, new Comparator<Field>() {
            @Override
            public int compare(Field a, Field b) {
                return (a.getAnnotation(ReadableColumn.class).index())
                        - (b.getAnnotation(ReadableColumn.class).index());
            }
        });

        /*make it unmodifiable*/
        list = Collections.unmodifiableList(list);

        return list;
    }

    @Override
    public void writeThisObjectToFile(List<T> data, String fileName, String sheetName) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        workbook = new HSSFWorkbook();

        Sheet studentsSheet = workbook.createSheet(sheetName);

        int rowIndex = 0;
        Row rowHeader = null;
        Cell cellHeader = null;

        /*write header*/
        int cellindex = 0;
        rowHeader = studentsSheet.createRow(rowIndex);

        for (Field f : this.sortedField(clazz)) {
            cellHeader = rowHeader.createCell(cellindex);
            cellHeader.setCellValue(f.getName());
            cellindex++;
        }

        /*increment it for data*/
        rowIndex++;
        
        for (T o : data) {
            Row row = studentsSheet.createRow(rowIndex++);
            int cellIndex = 0;

            //get getters
            Set<Method> getterMethods = ReflectionUtils
                    .getAllMethods(clazz,
                            withModifier(Modifier.PUBLIC),
                            withPrefix("get"),
                            withAnnotation(ReadableValue.class));

            /*put in the List*/
            List<Method> list = new ArrayList(getterMethods);

            /*compare and set priority*/
            Collections.sort(list, new Comparator<Method>() {
                @Override
                public int compare(Method a, Method b) {
                    return (a.getAnnotation(ReadableValue.class).index())
                            - (b.getAnnotation(ReadableValue.class).index());
                }
            });

            /*make it unmodifiable*/
            list = Collections.unmodifiableList(list);

            /*execute method of record object*/
            for (Method m : list) {
                row.createCell(cellIndex++).setCellValue(m.invoke(o).toString());
            }

        }

        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            System.out.println(fileName + " is successfully written");
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }

    @Override
    public byte[] writeThisObjectToStream(List<T> data, String sheetName) throws IOException, IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        byte[] tmp = null;
        
        workbook = new HSSFWorkbook();

        Sheet studentsSheet = workbook.createSheet(sheetName);

        int rowIndex = 0;
        Row rowHeader = null;
        Cell cellHeader = null;

        /*write header*/
        int cellindex = 0;
        rowHeader = studentsSheet.createRow(rowIndex);

        for (Field f : this.sortedField(clazz)) {
            cellHeader = rowHeader.createCell(cellindex);
            cellHeader.setCellValue(f.getName());
            cellindex++;
        }

        /*increment it for data*/
        rowIndex++;
        
        for (T o : data) {
            Row row = studentsSheet.createRow(rowIndex++);
            int cellIndex = 0;

            //get getters
            Set<Method> getterMethods = ReflectionUtils
                    .getAllMethods(clazz,
                            withModifier(Modifier.PUBLIC),
                            withPrefix("get"),
                            withAnnotation(ReadableValue.class));

            /*put in the List*/
            List<Method> list = new ArrayList(getterMethods);

            /*compare and set priority*/
            Collections.sort(list, new Comparator<Method>() {
                @Override
                public int compare(Method a, Method b) {
                    return (a.getAnnotation(ReadableValue.class).index())
                            - (b.getAnnotation(ReadableValue.class).index());
                }
            });

            /*make it unmodifiable*/
            list = Collections.unmodifiableList(list);

            /*execute method of record object*/
            for (Method m : list) {
                row.createCell(cellIndex++).setCellValue(m.invoke(o).toString());
            }

        }

        //write this workbook in excel file.
        try {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                workbook.write(bos);
                tmp =  bos.toByteArray();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return tmp;
    }

}
