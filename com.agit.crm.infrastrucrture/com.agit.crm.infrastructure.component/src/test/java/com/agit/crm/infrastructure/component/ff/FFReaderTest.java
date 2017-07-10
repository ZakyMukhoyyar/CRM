package com.agit.crm.infrastructure.component.ff;

import com.agit.crm.infrastructure.component.csv.ff.FFReader;
import java.util.List;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class FFReaderTest {
    
    private static final Log LOG = LogFactory.getLog(FFReaderTest.class);
    
    public FFReaderTest() {
    }

    @Test
    public void testSomeMethod() {
        FFReader<MyRecord> jft = new FFReader<>(MyRecord.class);
        List<MyRecord> m = jft.getJavaObjectfromThisStream("sample_ff.txt");
        Assert.assertNotNull(jft);
        for(MyRecord o : m){
            LOG.info(o.getStringData().concat("--").concat(o.getDateData().toString()));
        }
    }
    
}
