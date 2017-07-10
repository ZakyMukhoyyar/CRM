package com.agit.crm.infrastructure.component.xls;

import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.beans.IntrospectionException;
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
public class XlsReaderTest {

    private static final Log LOG = LogFactory.getLog(XlsReaderTest.class);
    
    public XlsReaderTest() {
    }

    @Test
    public void testSomeMethod() throws
            IOException,
            FileNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IllegalArgumentException,
            InvocationTargetException,
            IntrospectionException {

        XlsReader<Student> jxr = new XlsReader<>(Student.class);
        List<Student> ls = jxr.getJavaObjectFromThisFile(FileIOCommons.ABS_FILE_LOC_XLS);

        for (Student s : ls) {
            LOG.info(s.toString());
        }
    }

}
