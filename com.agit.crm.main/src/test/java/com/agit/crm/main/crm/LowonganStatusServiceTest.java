package com.agit.crm.main.crm;

import com.agit.crm.common.application.LowonganStatusService;
import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.domain.crm.LowonganStatusRepository;
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
public class LowonganStatusServiceTest {
    
    @Autowired
    private LowonganStatusRepository lowonganStatusRepository;
    
    @Autowired
    private LowonganStatusService lowonganStatusService;
    
    @Test
    public void testEnd2EndLowonganStatus() {
        Validate.notNull(lowonganStatusRepository);
        /* Header*/
        print("Data LowonganStatus Processing");

        /* Incident Record*/
        LowonganStatusDTO m = lowonganStatusService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        lowonganStatusService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        LowonganStatusDTO b = lowonganStatusService.findByID(m.getIdLowonganStatus());
        System.out.println("LowonganStatus :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<LowonganStatusDTO> listLowonganStatus = (List<LowonganStatusDTO>) lowonganStatusService.findAll();
        for (LowonganStatusDTO bt : listLowonganStatus) {
            System.out.println("LowonganStatus :" + bt.toString());
        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
