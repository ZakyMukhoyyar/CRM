package com.agit.crm.infrastructure.component.ff;

import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import com.agit.crm.infrastructure.component.csv.ff.FFWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class FFWriterTest {
    
    private static final Log LOG = LogFactory.getLog(FFWriterTest.class);
    
    public FFWriterTest() {
    }

    @Test
    public void testSomeMethod() throws IOException {
        FFWriter<MyRecord> jfw = new FFWriter<>(MyRecord.class);
        jfw.writeThisObjectToFile(createMyRecord(), FileIOCommons.ABS_FILE_LOC_TXT);
    }

    private List<MyRecord> createMyRecord() {
        List<MyRecord> l = new ArrayList();
        Calendar someDay = Calendar.getInstance();
        someDay.set(2008, 4, 14, 0, 0, 0);
        someDay.set(Calendar.MILLISECOND, 0);
        MyRecord myRecord = new MyRecord();
        myRecord.setBooleanData(true);
        myRecord.setCharData('C');
        myRecord.setDateData(someDay.getTime());
        myRecord.setDoubleData(10.35);
        myRecord.setFloatData(20.56F);
        myRecord.setLongData(11L);
        myRecord.setDoubleData(Double.MAX_VALUE);
        myRecord.setStringData("some text ");
        myRecord.setBigDecimalData(new BigDecimal(-12.012));
        myRecord.setSimpleFloatData(20.56F);
        for(int i=1;i<100;i++){
            l.add(myRecord);
        }
        return l;
    }

}
