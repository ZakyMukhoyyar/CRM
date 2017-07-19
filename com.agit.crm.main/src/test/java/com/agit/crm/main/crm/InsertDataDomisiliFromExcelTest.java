package com.agit.crm.main.crm;

import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.DomisiliDTOBuilder;
import com.agit.crm.common.dto.crm.DomisiliSecondary;
import com.agit.crm.domain.crm.DomisiliRepository;
import com.agit.crm.infrastructure.component.xls.XlsReader;
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
public class InsertDataDomisiliFromExcelTest {

    private static final String ABS_FILE_LOC = "D:\\Training-Material\\Project\\Project CRM\\Code\\CRM\\template-mapping\\insert-template-domisili.xlsx";

    @Autowired
    DomisiliRepository domisiliRepository;

    @Autowired
    DomisiliService domisiliService;

    @Test
    public void InsertDataHistoryFromExcelTest() throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        Validate.notNull(domisiliRepository);
        XlsReader<DomisiliSecondary> jxr = new XlsReader<>(DomisiliSecondary.class);
        List<DomisiliSecondary> ls = jxr.getJavaObjectFromThisFile(ABS_FILE_LOC);

        for (DomisiliSecondary s : ls) {
            DomisiliDTO m = new DomisiliDTOBuilder()
                    .setIdDomisili(s.getIdDomisili())
                    .setNamaProvinsi(s.getNamaProvinsi())
                    .setNamaKabupaten(s.getNamaKabupaten())
                    .setNamaKota(s.getNamaKota())
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createDomisiliDTO();
            try {
                domisiliService.SaveOrUpdate(m);
                System.out.println("Row " + s.getIdDomisili()+ " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getIdDomisili() + " FAILED");
            }
        }
    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}
