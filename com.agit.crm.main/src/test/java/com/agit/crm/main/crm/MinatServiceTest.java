package com.agit.crm.main.crm;

import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.domain.crm.MinatRepository;
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
public class MinatServiceTest {
    @Autowired
    private MinatRepository minatRepository;
    
    @Autowired
    private MinatService minatService;
    
    @Test
    public void testEnd2EndMinat() {
        Validate.notNull(minatRepository);
        /* Header*/
        print("Data Minat Processing");

        /* Incident Record*/
        MinatDTO m = minatService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        minatService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        MinatDTO b = minatService.findByID(m.getIdMinat());
        System.out.println("Minat :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<MinatDTO> listMinat = (List<MinatDTO>) minatService.findAll();
        for (MinatDTO bt : listMinat) {
            System.out.println("Minat :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
