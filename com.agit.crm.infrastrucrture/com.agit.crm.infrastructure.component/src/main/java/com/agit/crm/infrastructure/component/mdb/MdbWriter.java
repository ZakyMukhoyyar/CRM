package com.agit.crm.infrastructure.component.mdb;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import com.agit.crm.infrastructure.component.IMDBWriter;
import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.ReflectionUtils;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

/**
 *
 * @author bayutridewanto
 */
public class MdbWriter<T> implements IMDBWriter<T> {
    
    private Class<T> clazz;

    public MdbWriter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void writeThisObjectToFile(List<T> data, String fileName) throws IOException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        /*create MDB file*/
        Database db = DatabaseBuilder.create(Database.FileFormat.V2000, new File(fileName));

        /*create a table*/
        TableBuilder newTable = new TableBuilder("NewTable"); 
        
        Set<Field> fields = ReflectionUtils.getAllFields(clazz,withModifier(Modifier.PRIVATE),withAnnotation(ReadableColumn.class));
        
        for(Field f : fields){
            newTable.addColumn(new ColumnBuilder(f.getName()).setSQLType(Types.VARCHAR));
        }
        
        Table tbl = newTable.toTable(db);
        
        /*fill data*/
        for (T o : data) {
            //get getters
            Set<Method> getterMethods = ReflectionUtils
                    .getAllMethods(o.getClass(),
                            withModifier(Modifier.PUBLIC),
                            withPrefix("get"),
                            withAnnotation(ReadableValue.class));
            
            List<Method> list = new ArrayList(getterMethods);
            
            tbl.addRow(list.get(1).invoke(o).toString(), list.get(0).invoke(o).toString());
        }
    }

    private void crateMdbFile(String filePath) {
    }

}
