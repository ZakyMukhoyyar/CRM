package com.agit.crm.infrastructure.component.csv;

import com.agit.crm.infrastructure.component.IReader;
import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class CsvReaderTest {

    private static final Log LOG = LogFactory.getLog(CsvReaderTest.class);

    public CsvReaderTest() {
    }

    @Test
    public void testCsvFromFile() throws FileNotFoundException {
        IReader<Country> csr = new CsvReader<>(Country.class);
        Assert.assertNotNull(csr);
        List<Country> oo = csr.getJavaObjectFromThisFile(FileIOCommons.ABS_FILE_LOC_CSV);
        Assert.assertNotNull(oo);
        for (Country o : oo) {
            LOG.info("Name " + o.getCountryName() + " " + "Capital " + o.getCapital());
        }
    }

    @Test
    public void testCsvFromStream() {
        IReader<Country> csr = new CsvReader<>(Country.class);
        Assert.assertNotNull(csr);
        List<Country> oo = csr.getJavaObjectfromThisStream(new InputStreamReader(ClassLoader.getSystemResourceAsStream("write.csv")));
        Assert.assertNotNull(oo);
        for (Country o : oo) {
            LOG.info("Name " + o.getCountryName() + " " + "Capital " + o.getCapital());
        }
    }

}
