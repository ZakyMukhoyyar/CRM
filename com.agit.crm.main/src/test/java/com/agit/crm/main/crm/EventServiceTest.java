package com.agit.crm.main.crm;

import com.agit.crm.common.application.EventService;
import com.agit.crm.common.dto.crm.EventDTO;
import com.agit.crm.domain.crm.EventRepository;
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
    private EventRepository eventRepository;
    
    @Autowired
    private EventService eventService;
    
    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventRepository);
        /* Header*/
        print("Data Event Processing");

        /* Incident Record*/
        EventDTO m = eventService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        eventService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        EventDTO b = eventService.findByID(m.getIdEvent());
        System.out.println("Event :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<EventDTO> listEvent = (List<EventDTO>) eventService.findAll();
        for (EventDTO bt : listEvent) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
