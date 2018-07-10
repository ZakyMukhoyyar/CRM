package com.agit.crm.main.customer.feedback;

import com.agit.crm.main.crm.*;
import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.application.QuestionService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.domain.crm.CivitasRepository;
import com.agit.crm.domain.customer.feedback.QuestionRepository;
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
public class CustomerFeedbackServiceTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(questionRepository);
        /* Header*/
        print("Data Processing");

        /* Incident Record*/
        QuestionDTO m = questionService.getDummyData();

        System.out.println("Question Result: " + m.toString());

        questionService.SaveOrUpdate(m);
        System.out.println("Question Result has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        QuestionDTO b = questionService.findByID(m.getQuestionID());
        System.out.println("Question Result :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<QuestionDTO> listDataQuestion = (List<QuestionDTO>) questionService.findAll();
        for (QuestionDTO bt : listDataQuestion) {
            System.out.println("Question Result :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
