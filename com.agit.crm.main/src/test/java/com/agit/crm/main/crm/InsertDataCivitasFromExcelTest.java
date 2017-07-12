package com.agit.crm.main.crm;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.CivitasDTOBuilder;
import com.agit.crm.common.dto.crm.CivitasSecondary;
import com.agit.crm.domain.crm.CivitasRepository;
import com.agit.crm.infrastructure.component.xls.XlsReader;
import com.agit.crm.shared.status.Status;
import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
public class InsertDataCivitasFromExcelTest {

    private static final String ABS_FILE_LOC = "E:\\PEKERJAAN\\Agit\\Project\\Project2\\CRM\\template-mapping\\insert-template-civitas.xlsx";

    @Autowired
    CivitasRepository dataHistoryRepository;

    @Autowired
    CivitasService dataHistoryService;

    @Test
    public void InsertDataHistoryFromExcelTest() throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        Validate.notNull(dataHistoryRepository);
        XlsReader<CivitasSecondary> jxr = new XlsReader<>(CivitasSecondary.class);
        List<CivitasSecondary> ls = jxr.getJavaObjectFromThisFile(ABS_FILE_LOC);

        for (CivitasSecondary s : ls) {
            Status status = null;

            if (s.getStatus() == "ACTIVE") {
                status = Status.ACTIVE;
            } else {
                status = Status.INACTIVE;
            }
            CivitasDTO m = new CivitasDTOBuilder()
                    .setCivitasID(s.getNo())
                    .setNamaCivitas(s.getNamaCivitas())
                    .setStatus(status)
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createCivitasDTO();
            try {
                dataHistoryService.SaveOrUpdate(m);
                System.out.println("Row " + s.getNo() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getNo() + " FAILED");
            }
        }
    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
