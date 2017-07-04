package com.agit.crm.main.crm;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.domain.crm.EventAgitRepository;
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
public class EventServiceTest {    
    
    @Autowired
    private EventAgitRepository eventAgitRepository;
    
    @Autowired
    private EventAgitService eventAgitService;
    
    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventAgitRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        EventAgitDTO m = eventAgitService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        eventAgitService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        EventAgitDTO b = eventAgitService.findByID(m.getIdEvent());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<EventAgitDTO> listEventAgit = (List<EventAgitDTO>) eventAgitService.findAll();
        for (EventAgitDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
