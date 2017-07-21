package com.agit.crm.main.crm;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.domain.crm.LowonganRepository;
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
    "classpath:/crm-context-infrastructure.xml"})
public class LowonganServiceTest {
    @Autowired
    private LowonganRepository lowonganRepository;
    @Autowired
    private LowonganService lowonganService;
    
    @Test
    public void testEnd2EndLowongan() {
        Validate.notNull(lowonganRepository);
        /* Header*/
        print("Data Lowongan Processing");

        /* Incident Record*/
        LowonganDTO m = lowonganService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        lowonganService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        LowonganDTO b = lowonganService.findByID(m.getIdLowongan());
        System.out.println("Lowongan :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<LowonganDTO> listLowongan = (List<LowonganDTO>) lowonganService.findAll();
        for (LowonganDTO bt : listLowongan) {
            System.out.println("Lowongan :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
