package com.agit.crm.infrastructure.component.csv;

import au.com.bytecode.opencsv.CSVWriter;
import com.agit.crm.infrastructure.component.IWriter;
import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import java.beans.IntrospectionException;
import java.io.FileWriter;
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
import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class PsvWriter<T> implements IWriter<T> {

    private final Class<T> clazz;
    
    public PsvWriter(Class<T> clazz) {
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
    
    private List<Method> sortThisMethod(Set<Method> aset) {
        List<Method> list = new ArrayList(aset);
        Collections.sort(list, new Comparator<Method>() {
            @Override
            public int compare(Method a, Method b) {
                return (a.getAnnotation(ReadableValue.class).index()) 
                            - (b.getAnnotation(ReadableValue.class).index());
            }

        });
        return list;
    }    

    @Override
    public void writeThisObjectToFile(String filePath, List<T> data)
            throws
            IOException,
            IntrospectionException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath),'|','\b')) {

            /*prepare for write header*/
            Set<Field> fields = ReflectionUtils.getAllFields(clazz, withModifier(Modifier.PRIVATE), withAnnotation(ReadableColumn.class));

            /*sort the attribute by index*/
            List<Field> sortedList = this.sortThisField(fields);
            
            /*prepare for write*/
            String[] recordData = new String[sortedList.size()];
            int y=0;
            for (Field f : sortedList){
                recordData[y]= f.getName();
                y++;        
            }
            
            /*write header*/
            writer.writeNext(recordData);

            /*prepare write data, looping over data collection*/
            for (T o : data) {
                
                /*get all getter*/
                Set<Method> getterMethods = ReflectionUtils
                                                .getAllMethods(o.getClass(), 
                                                        withModifier(Modifier.PUBLIC), 
                                                            withPrefix("get"), 
                                                                withAnnotation(ReadableValue.class));
                
                /*sorted by index*/
                List<Method> methodList = this.sortThisMethod(getterMethods);
                
                /*invoke sorted getter method*/
                int i = 0;
                String[] strArray = new String[getterMethods.size()];
                for (Method m : methodList) {
                    strArray[i] = m.invoke(o).toString();
                    i++;
                }
                
                /*write data*/
                writer.writeNext(strArray);
            }
        }
    }

}
