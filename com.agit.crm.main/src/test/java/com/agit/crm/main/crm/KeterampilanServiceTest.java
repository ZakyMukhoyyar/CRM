package com.agit.crm.main.crm;

import com.agit.crm.common.application.KeterampilanService;
import com.agit.crm.common.dto.crm.KeterampilanDTO;
import com.agit.crm.domain.crm.KeterampilanRepository;
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
public class KeterampilanServiceTest {
    
    @Autowired
    private KeterampilanRepository keterampilanRepository;
    
    @Autowired
    private KeterampilanService keterampilanService;
    
    @Test
    public void testEnd2EndKeterampilan() {
        Validate.notNull(keterampilanRepository);
        /* Header*/
        print("Data Keterampilan Processing");

        /* Incident Record*/
        KeterampilanDTO m = keterampilanService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        keterampilanService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        KeterampilanDTO b = keterampilanService.findByID(m.getIdKeterampilan());
        System.out.println("Keterampilan :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<KeterampilanDTO> listKeterampilan = (List<KeterampilanDTO>) keterampilanService.findAll();
        for (KeterampilanDTO bt : listKeterampilan) {
            System.out.println("Keterampilan :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
