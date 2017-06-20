package com.agit.crm.main.viewmodel;

//package com.agit.crm.main.viewmodel;
//
//import com.agit.crm.common.application.OrderService;
//import com.agit.crm.common.interfaces.web.facade.dto.order.OrderDTO;
//import java.util.ArrayList;
//import java.util.List;
//import org.zkoss.bind.annotation.ExecutionArgParam;
//import org.zkoss.bind.annotation.Init;
//import org.zkoss.zk.ui.select.annotation.VariableResolver;
//import org.zkoss.zk.ui.select.annotation.WireVariable;
//
///**
// *
// * @author 10991001
// */
//@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
//public class MonitoringVM {
//
//    @WireVariable
//    OrderService orderService;
//
//    /* Object Related Order */
//    private List<OrderDTO> orderDTOs = new ArrayList<>();
//
//    @Init
//    public void init(
//            @ExecutionArgParam("orderDTO") OrderDTO order) {
//
//        /* Load Data */
//        initData();
//    }
//
//    private void initData() {
//        /* get data aplikasi */
//        orderDTOs = orderService.findAll();
//    }
//
//
//    /* getter and setter*/
//    public List<OrderDTO> getOrderDTOs() {
//        return orderDTOs;
//    }
//
//    public void setOrderDTOs(List<OrderDTO> orderDTOs) {
//        this.orderDTOs = orderDTOs;
//    }
//
//}
