package com.agit.crm.infrastructure.component.mdb;

import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class MdbReaderTest {
    
     private static final Log LOG = LogFactory.getLog(MdbReaderTest.class);
    
    public MdbReaderTest() {
    }

    @Test
    public void testSomeMethod() throws IOException, FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MdbReader<MyMDBRecord> jmr = new MdbReader<>(MyMDBRecord.class);
        List<MyMDBRecord> ls = jmr.getJavaObjectFromThisFile(FileIOCommons.ABS_FILE_LOC_MDB,"NewTable");
            for (MyMDBRecord s : ls) {
            LOG.info(s.toString());
        }
    }
    
}
