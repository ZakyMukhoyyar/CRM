package com.agit.crm.main.crm;



import com.agit.crm.common.application.KomentarEventService;
import com.agit.crm.common.dto.crm.KomentarEventDTO;
import com.agit.crm.domain.crm.KomentarEventRepository;
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
public class KomentarEventServiceTest {

    @Autowired
    private KomentarEventRepository komentarEventRepository;

    @Autowired
    private KomentarEventService komentarEventService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(komentarEventRepository);
        /* Header*/
        print("Data Event Processing");

        /* Incident Record*/
        KomentarEventDTO m = komentarEventService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        komentarEventService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        KomentarEventDTO b = komentarEventService.findByID(m.getKomentarID());
        System.out.println("Event :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<KomentarEventDTO> listEvent = (List<KomentarEventDTO>) komentarEventService.findAll();
        for (KomentarEventDTO bt : listEvent) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
