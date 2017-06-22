package com.agit.crm.main.crm;

import com.agit.crm.common.application.MahasiswaService;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.domain.crm.MahasiswaRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.activiti.engine.impl.scripting.JuelScriptEngine.print;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Bayu Hendra Setiawan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"})
public class MahasiswaServiceTest {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private MahasiswaService mahasiswaService;

    @Test
    public void testEnd2EndMahasiswa() {
        Validate.notNull(mahasiswaRepository);
        /* Header*/
        print("Data Mahasiswa Processing");

        /* Incident Record*/
        MahasiswaDTO m = mahasiswaService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        mahasiswaService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        MahasiswaDTO b = mahasiswaService.findByID(m.getIdMahasiswa());
        System.out.println("Mahasiswa :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<MahasiswaDTO> listMahasiswa = (List<MahasiswaDTO>) mahasiswaService.findAll();
        for (MahasiswaDTO bt : listMahasiswa) {
            System.out.println("Mahasiswa :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }

}
