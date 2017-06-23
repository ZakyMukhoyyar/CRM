package com.agit.crm.main.crm;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.domain.crm.ForumRepository;
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
public class ForumServiceTest {
    
    @Autowired
    private ForumRepository forumRepository;
    
    @Autowired
    private ForumService forumService;
    
    @Test
    public void testEnd2EndForum() {
        Validate.notNull(forumRepository);
        /* Header*/
        print("Data Forum Processing");

        /* Incident Record*/
        ForumDTO m = forumService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        forumService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        ForumDTO b = forumService.findByID(m.getIdForum());
        System.out.println("Forum :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<ForumDTO> listForum = (List<ForumDTO>) forumService.findAll();
        for (ForumDTO bt : listForum) {
            System.out.println("Forum :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
    
}
