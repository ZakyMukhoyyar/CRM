package com.agit.crm.main.crm;

import com.agit.crm.common.application.StoringFICardService;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTOBuilder;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardSecondary;
import com.agit.crm.domain.storing.fi.card.StoringFICardRepository;
import com.agit.crm.infrastructure.component.csv.CsvReader;
import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author 3AD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"
})
public class InsertDataStoringFromExcelTest {

    private static final String ABS_FILE_LOC = "D:\\AGIT\\Training-Material\\Project\\Project Storing FI Card Online\\POC\\point-check.csv";

    @Autowired
    StoringFICardRepository storingFICardRepository;

    @Autowired
    StoringFICardService storingFICardService;

    @Test
    public void InsertDataHistoryFromExcelTest() throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        Validate.notNull(storingFICardRepository);
        CsvReader<StoringFICardSecondary> jxr = new CsvReader<>(StoringFICardSecondary.class);
        List<StoringFICardSecondary> ls = jxr.getJavaObjectFromThisFile(ABS_FILE_LOC);

        for (StoringFICardSecondary s : ls) {
            StoringFICardDTO m = new StoringFICardDTOBuilder()
                    .setStoringFICardID(s.getStoringFICardID())
                    .setPointCheck1(s.getPointCheck1())
                    .setPointCheck2(s.getPointCheck2())
                    .setPointCheck3(s.getPointCheck3())
                    .setPointCheck4(s.getPointCheck4())
                    .setPointCheck5(s.getPointCheck5())
                    .setCreatedDate(new Date())
                    .createStoringFICardDTO();
            try {
                storingFICardService.SaveOrUpdate(m);
                System.out.println("Row " + s.getStoringFICardID() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getStoringFICardID() + " FAILED");
            }
        }
    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
