package com.agit.crm.infrastructure.component.mdb;

import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class MdbWriterTest {
    
    public MdbWriterTest() {
    }

    @Test
    public void testSomeMethod() throws IOException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MdbWriter<MyMDBRecord> jmb = new MdbWriter<>(MyMDBRecord.class);
        jmb.writeThisObjectToFile(createMyMDBRecord(), FileIOCommons.ABS_FILE_LOC_MDB);
    }
    
    private static List<MyMDBRecord> createMyMDBRecord(){
        List<MyMDBRecord> tmp = new ArrayList();
        MyMDBRecord o = new MyMDBRecord();
        o.setName("user.system");
        o.setAddress("Semarang");
        
        for(int i=0;i<100;i++){
            tmp.add(o);
        }
        return tmp;
    }
    
}
