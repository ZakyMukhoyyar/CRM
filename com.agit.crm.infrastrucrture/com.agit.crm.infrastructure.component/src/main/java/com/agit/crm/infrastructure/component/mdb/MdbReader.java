package com.agit.crm.infrastructure.component.mdb;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.Row;
import com.agit.crm.infrastructure.component.IMDBReader;
import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.WritableValue;
import java.io.File;
import java.io.FileNotFoundException;
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
 *
 * Write and read access file
 */
public class MdbReader<T> implements IMDBReader<T> {
    
    private Class<T> clazz;    

    List<T> tmp = new ArrayList();

    public MdbReader(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public List<T> getJavaObjectFromThisFile(String filePath,String tableName) throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Table table = DatabaseBuilder.open(new File(filePath)).getTable(tableName);

        /*collect setter of the record*/
        Set<Method> setterMethods = ReflectionUtils 
                .getAllMethods(clazz,
                        withModifier(Modifier.PUBLIC),
                        withPrefix("set"),
                        withAnnotation(WritableValue.class));

        /*make it available in framework*/
        List<Method> list = new ArrayList(setterMethods);

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

        /*get list of attribute*/
        Set<Field> fields = ReflectionUtils.getAllFields(clazz, withModifier(Modifier.PRIVATE), withAnnotation(ReadableColumn.class));

        List<Field> listField = new ArrayList(fields);

        for (Row row : table) {
            /*create record bean*/
            T recBean = clazz.newInstance();

            /*iterate over bean def*/
            int y = 0;
            for (Method m : list) {
                list.get(y).invoke(recBean, row.get(listField.get(y).getName()));
                y++;
            }
            tmp.add(recBean);
        }
        return tmp;
    }

    @Override
    public List<T> getJavaObjectfromThisStream(String relativeFilePath, Class<T> record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
