package com.agit.crm.main.crm;

import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.domain.crm.KetrampilanRepository;
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
public class KetrampilanServiceTest {
    
    @Autowired
    private KetrampilanRepository ketrampilanRepository;
    
    @Autowired
    private KetrampilanService ketrampilanService;
    
    @Test
    public void testEnd2EndKetrampilan() {
        Validate.notNull(ketrampilanRepository);
        /* Header*/
        print("Data Ketrampilan Processing");

        /* Incident Record*/
        KetrampilanDTO m = ketrampilanService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        ketrampilanService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        KetrampilanDTO b = ketrampilanService.findByID(m.getIdKetrampilan());
        System.out.println("Ketrampilan :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<KetrampilanDTO> listKetrampilan = (List<KetrampilanDTO>) ketrampilanService.findAll();
        for (KetrampilanDTO bt : listKetrampilan) {
            System.out.println("Ketrampilan :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
