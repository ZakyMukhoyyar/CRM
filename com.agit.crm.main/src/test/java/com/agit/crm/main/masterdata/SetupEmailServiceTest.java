package com.agit.crm.main.masterdata;

import com.agit.crm.common.application.masterdata.SetupEmailService;
import com.agit.crm.common.dto.masterdata.SetupEmailDTO;
import com.agit.crm.masterdata.domain.SetupEmailRepository;
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
 * @author TriAA
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"
})
public class SetupEmailServiceTest {

    @Autowired
    private SetupEmailRepository eventAgitRepository;

    @Autowired
    private SetupEmailService eventAgitService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventAgitRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        SetupEmailDTO m = eventAgitService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        eventAgitService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        SetupEmailDTO b = eventAgitService.findByID(m.getIdEmail());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<SetupEmailDTO> listEventAgit = (List<SetupEmailDTO>) eventAgitService.findAll();
        for (SetupEmailDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
