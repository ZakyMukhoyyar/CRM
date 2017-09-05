package com.agit.crm.main.crm;

import com.agit.crm.common.application.KomentarForumService;
import com.agit.crm.common.dto.crm.KomentarForumDTO;
import com.agit.crm.domain.crm.KomentarForumRepository;
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
public class KomentarForumServiceTest {

    @Autowired
    private KomentarForumRepository komentarForumRepository;

    @Autowired
    private KomentarForumService komentarForumService;

    @Test
    public void testEnd2EndForum() {
        Validate.notNull(komentarForumRepository);
        /* Header*/
        print("Data Forum Processing");

        /* Incident Record*/
        KomentarForumDTO m = komentarForumService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        komentarForumService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        KomentarForumDTO b = komentarForumService.findByID(m.getKomentarID());
        System.out.println("Forum :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<KomentarForumDTO> listForum = (List<KomentarForumDTO>) komentarForumService.findAll();
        for (KomentarForumDTO bt : listForum) {
            System.out.println("Forum :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
