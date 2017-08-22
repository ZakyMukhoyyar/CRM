/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.crm;

import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.domain.crm.DomisiliRepository;
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
 * @author user
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"    
})
public class DomisiliServiceTest {
    @Autowired
    private DomisiliRepository domisiliRepository;
    
    @Autowired
    private DomisiliService domisiliService;
    
    @Test
    public void testEnd2EndForum() {
        Validate.notNull(domisiliRepository);
        /* Header*/
        print("Data Domisili Processing");

        /* Incident Record*/
        DomisiliDTO m = domisiliService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        domisiliService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        DomisiliDTO b = domisiliService.findByID(m.getIdDomisili());
        System.out.println("Domisili :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<DomisiliDTO> listDomisili = (List<DomisiliDTO>) domisiliService.findAll();
        for (DomisiliDTO bt : listDomisili) {
            System.out.println("Domisili :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
    
}
