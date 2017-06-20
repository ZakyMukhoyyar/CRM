package com.agit.crm.main.order;

//package com.bitozen.skk.main.order;
//
//import com.bitozen.skk.common.dto.masterdata.DataHistoryDTO;
//import com.bitozen.skk.masterdata.management.application.DataHistoryService;
//import com.bitozen.skk.masterdata.management.domain.dataHistory.DataHistoryRepository;
//import java.util.List;
//import org.apache.commons.lang.Validate;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// *
// * @author 3AD
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//    "classpath:/skk-context-application.xml",
//    "classpath:/skk-context-infrastructure.xml"})
//public class DataHistoryTest {
//
//    @Autowired
//    private DataHistoryRepository dataHistoryRepository;
//
//    @Autowired
//    private DataHistoryService dataHistoryService;
//
//    @Test
//    public void DataHistoryServiceTest() {
//        Validate.notNull(dataHistoryRepository);
//        print("Order Processing");
//
//        /* Order get Dummy */
//        DataHistoryDTO dataHistory = dataHistoryService.getDummy();
//        System.out.println("Order :" + dataHistory.toString());
//
//        dataHistoryService.saveOrUpdate(dataHistory);
//        System.out.println("Order has been saved succesfully");
//
//        System.out.println("");
//        System.out.println("Find by ID");
//        DataHistoryDTO d = dataHistoryService.findByID(dataHistory.getDataHistoryID());
//        System.out.println("Order :" + d.toString());
//
//        System.out.println("");
//        System.out.println("Find ALL");
//        List<DataHistoryDTO> listOrder = dataHistoryService.findAllDataHistory();
//        for (DataHistoryDTO tk : listOrder) {
//            System.out.println("Order :" + tk.toString());
//        }
//    }
//
//    private void print(String msg) {
//        System.out.println("------------------------------------------------------------------------");
//        System.out.println(msg);
//        System.out.println("------------------------------------------------------------------------");
//    }
//
//}
