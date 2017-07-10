package com.agit.crm.infrastructure.component.csv;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.agit.crm.infrastructure.component.IReader;
import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class PsvReader<T> implements IReader<T> {

    private final Class<T> clazz;

    public PsvReader(Class<T> clazz) {
        this.clazz = clazz;
    }

    private List<Field> sortThisField(Set<Field> aset) {
        List<Field> list = new ArrayList(aset);
        Collections.sort(list, new Comparator<Field>() {
            @Override
            public int compare(Field a, Field b) {
                return (a.getAnnotation(ReadableColumn.class).index())
                        - (b.getAnnotation(ReadableColumn.class).index());
            }

        });
        return list;
    }
    
    private String[] getColumnForThis(Class<T> clazz, Class<ReadableColumn> annotation){
        Set<Field> fields = ReflectionUtils.getAllFields(clazz, withModifier(Modifier.PRIVATE), withAnnotation(annotation));
        List<Field> sortedField = this.sortThisField(fields);
        String[] s = new String[sortedField.size()];
        int i=0;
        for(Field f : sortedField){
            s[i] = f.getName();
            i++;
        }
        return s;
    }

    @Override
    public List<T> getJavaObjectFromThisFile(String pathFile) throws FileNotFoundException {
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
        strat.setType(clazz);  
        String[] d = getColumnForThis(this.clazz,ReadableColumn.class);
        strat.setColumnMapping(d);
        CsvToBean csv = new CsvToBean();
        /*1 is the key escape the heading*/
        CSVReader csvr = new CSVReader(new FileReader(pathFile),'|', '"', 1);
        return csv.parse(strat, csvr);
    }

    @Override
    public List<T> getJavaObjectfromThisStream(InputStreamReader isr) {
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
        strat.setType(clazz);
        strat.setColumnMapping(getColumnForThis(this.clazz,ReadableColumn.class));
        CsvToBean csv = new CsvToBean();
        /*1 is the key escape the heading*/
        CSVReader csvr = new CSVReader(isr, CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
        return csv.parse(strat, csvr);
    }

}
