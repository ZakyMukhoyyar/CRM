package com.agit.crm.infrastructure.component.csv;

import com.agit.crm.infrastructure.component.IWriter;
import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class CsvWriterTest {

    private static final Log LOG = LogFactory.getLog(CsvWriterTest.class);

    public CsvWriterTest() {
    }

    @Test
    public void testSomeMethod() throws
            IOException,
            IntrospectionException,
            IllegalArgumentException,
            IllegalAccessException,
            InvocationTargetException {
        
        
        IWriter<Country> csr = new CsvWriter<>(Country.class);
        
        Country c = new Country();
        c.setCapital("1");
        c.setCountryName("Indonesia");

        Country c1 = new Country();
        c1.setCapital("2");
        c1.setCountryName("Indonesia1");

        Country c2 = new Country();
        c2.setCapital("3");
        c2.setCountryName("Indonesia2");

        Country c3 = new Country();
        c3.setCapital("4");
        c3.setCountryName("Indonesia3");
        
        
        csr.writeThisObjectToFile(FileIOCommons.ABS_FILE_LOC_CSV, Arrays.asList(c, c1, c2, c3));
    }

}
