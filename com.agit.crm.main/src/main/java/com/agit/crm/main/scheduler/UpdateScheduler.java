package com.agit.crm.main.scheduler;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.application.LowonganService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zaky
 */
public class UpdateScheduler {
    
    @Autowired
    EventAgitService eventAgitService;
    
    @Autowired
    LowonganService lowonganService;

    public void setLowonganService(LowonganService lowonganService) {
        this.lowonganService = lowonganService;
    }
    
    public void setEventAgitService(EventAgitService eventAgitService) {
        this.eventAgitService = eventAgitService;
    }
    
    public void execute() {
        Date tanggal = new Date();
        System.out.println(" ========================= Update Data Server ========================= ");
        eventAgitService.eventScheduler();
        lowonganService.eventScheduler();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Data Server has been Updated at : " + tanggal+"|");
        System.out.println("-----------------------------------------------------------------");
    }
        
    
}
