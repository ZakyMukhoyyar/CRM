/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.crm;

import com.agit.crm.common.application.RiwayatApplyEventService;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.domain.crm.RiwayatApplyEventRepository;
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
public class RiwayatApplyEventTest {

    @Autowired
    private RiwayatApplyEventRepository eventAgitRepository;

    @Autowired
    private RiwayatApplyEventService eventAgitService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(eventAgitRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        RiwayatApplyEventDTO m = eventAgitService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        eventAgitService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        RiwayatApplyEventDTO b = eventAgitService.findByID(m.getIdRiwayatApplyEvent());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<RiwayatApplyEventDTO> listEventAgit = (List<RiwayatApplyEventDTO>) eventAgitService.findAll();
        for (RiwayatApplyEventDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
