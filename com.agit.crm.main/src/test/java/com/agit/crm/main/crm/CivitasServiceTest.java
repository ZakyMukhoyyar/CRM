package com.agit.crm.main.crm;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.domain.crm.CivitasRepository;
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
 * @author 3AD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"
})
public class CivitasServiceTest {

    @Autowired
    private CivitasRepository eventAgitRepository;

    @Autowired
    private CivitasService eventAgitService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventAgitRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        CivitasDTO m = eventAgitService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        eventAgitService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        CivitasDTO b = eventAgitService.findByID(m.getCivitasID());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<CivitasDTO> listEventAgit = (List<CivitasDTO>) eventAgitService.findAll();
        for (CivitasDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
