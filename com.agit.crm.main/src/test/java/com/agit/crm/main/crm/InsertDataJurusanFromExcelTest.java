package com.agit.crm.main.crm;


import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.JurusanDTOBuilder;
import com.agit.crm.common.dto.crm.JurusanSecondary;
import com.agit.crm.domain.crm.JurusanRepository;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zaky
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"
})
public class InsertDataJurusanFromExcelTest {

    private static final String ABS_FILE_LOC = "D:\\Work\\AgitCRM\\CRM\\template-mapping\\insert-template-jurusan.xlsx";

    @Autowired
    JurusanRepository jurusanRepository;

    @Autowired
    JurusanService jurusanService;

    @Test
    public void InsertDataHistoryFromExcelTest() throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        Validate.notNull(jurusanRepository);
        XlsReader<JurusanSecondary> jxr = new XlsReader<>(JurusanSecondary.class);
        List<JurusanSecondary> ls = jxr.getJavaObjectFromThisFile(ABS_FILE_LOC);

        for (JurusanSecondary s : ls) {
            JurusanDTO m = new JurusanDTOBuilder()
                    .setIdJurusan(s.getIdJurusan())
                    .setNamaJurusan(s.getNamaJurusan())
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createJurusanDTO();
            try {
                jurusanService.SaveOrUpdate(m);
                System.out.println("Row " + s.getIdJurusan()+ " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getIdJurusan()+ " FAILED");
            }
        }
    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }

}
