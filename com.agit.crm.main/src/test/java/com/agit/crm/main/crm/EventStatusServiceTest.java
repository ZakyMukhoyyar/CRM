package com.agit.crm.main.crm;

import com.agit.crm.common.application.EventStatusService;
import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.domain.crm.EventStatusRepository;
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
public class EventStatusServiceTest {
    
    @Autowired
    private EventStatusRepository eventStatusRepository;
    
    @Autowired
    private EventStatusService eventStatusService;
    
    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventStatusRepository);
        /* Header*/
        print("Data EventStatus Processing");

        /* Incident Record*/
        EventStatusDTO m = eventStatusService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        eventStatusService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        EventStatusDTO b = eventStatusService.findByID(m.getIdEventStatus());
        System.out.println("EventStatus :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<EventStatusDTO> listEventStatus = (List<EventStatusDTO>) eventStatusService.findAll();
        for (EventStatusDTO bt : listEventStatus) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}

