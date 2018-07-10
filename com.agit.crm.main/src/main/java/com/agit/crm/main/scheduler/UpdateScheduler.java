package com.agit.crm.main.scheduler;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.StoringFICardPOCService;
import com.agit.crm.common.application.StoringFICardService;
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
    StoringFICardService storingFICardService;

    @Autowired
    LowonganService lowonganService;

    @Autowired
    StoringFICardPOCService storingFICardPOCService;

    public void setLowonganService(LowonganService lowonganService) {
        this.lowonganService = lowonganService;
    }

    public void setEventAgitService(EventAgitService eventAgitService) {
        this.eventAgitService = eventAgitService;
    }

    public void setStoringFICardService(StoringFICardService storingFICardService) {
        this.storingFICardService = storingFICardService;
    }

    public void setStoringFICardPOCService(StoringFICardPOCService storingFICardPOCService) {
        this.storingFICardPOCService = storingFICardPOCService;
    }

    public void execute() {
        Date tanggal = new Date();
        System.out.println(" ========================= Update Data Server ========================= ");
        eventAgitService.eventScheduler();
//        storingFICardService.eventScheduler();
        lowonganService.eventScheduler();
        storingFICardPOCService.eventStoringPOCScheduler();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Data Server has been Updated at : " + tanggal + "|");
        System.out.println("-----------------------------------------------------------------");
    }
}
