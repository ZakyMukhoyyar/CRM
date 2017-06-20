package com.agit.crm.main.order;

//package com.bitozen.skk.main.order;
//
//import com.bitozen.skk.common.application.OrderService;
//import com.bitozen.skk.common.domain.order.OrderRepository;
//import com.bitozen.skk.common.interfaces.web.facade.dto.order.OrderDTO;
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
// * @author 10991001
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//    "classpath:/skk-context-application.xml",
//    "classpath:/skk-context-infrastructure.xml"})
//public class OrderServiceTest {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Test
//    public void OrderServiceTest() {
//        Validate.notNull(orderRepository);
//        print("Order Processing");
//        /* Order get Dummy */
//        OrderDTO order = orderService.getDummy();
//        System.out.println("Order :" + order.toString());
//
//        /* Save Order */
//        orderService.saveOrUpdate(order);
//        System.out.println("Order has been saved succesfully");
//
//        System.out.println("");
//        System.out.println("Find by ID");
//        OrderDTO t = orderService.findByID(order.getOrderID());
//        System.out.println("Order :" + t.toString());
//
//        System.out.println("");
//        System.out.println("Find ALL");
//        List<OrderDTO> listOrder = orderService.findAll();
//        for (OrderDTO tk : listOrder) {
//            System.out.println("Order :" + tk.toString());
//        }
//
//    }
//
//    private void print(String msg) {
//        System.out.println("------------------------------------------------------------------------");
//        System.out.println(msg);
//        System.out.println("------------------------------------------------------------------------");
//    }
//}
