package com.agit.crm.main.crm;

import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.domain.crm.JurusanRepository;
import java.util.List;
import static org.activiti.engine.impl.scripting.JuelScriptEngine.print;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Zaky
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"    
})
public class JurusanServiceTest {
    @Autowired
    private JurusanRepository jurusanRepository;
    
    @Autowired
    private JurusanService jurusanService;
    
    @Test
    public void testEnd2EndJurusan() {
        Validate.notNull(jurusanRepository);
        /* Header*/
        print("Data Jurusan Processing");

        /* Incident Record*/
        JurusanDTO m = jurusanService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        jurusanService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        JurusanDTO b = jurusanService.findByID(m.getIdJurusan());
        System.out.println("Jurusan :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<JurusanDTO> listJurusan = (List<JurusanDTO>) jurusanService.findAll();
        for (JurusanDTO bt : listJurusan) {
            System.out.println("Jurusan :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}