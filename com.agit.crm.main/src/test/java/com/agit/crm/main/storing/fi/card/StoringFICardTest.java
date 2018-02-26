package com.agit.crm.main.storing.fi.card;

import com.agit.crm.common.application.StoringFICardService;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.domain.storing.fi.card.StoringFICardRepository;
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
public class StoringFICardTest {

    @Autowired
    private StoringFICardRepository storingFICardRepository;

    @Autowired
    private StoringFICardService storingFICardService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(storingFICardRepository);
        /* Header*/
        print("Data Storing FI Card Processing");

        /* Incident Record*/
        StoringFICardDTO m = storingFICardService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        storingFICardService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        StoringFICardDTO b = storingFICardService.findByID(m.getStoringFICardID());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<StoringFICardDTO> listEventAgit = (List<StoringFICardDTO>) storingFICardService.findAll();
        for (StoringFICardDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
