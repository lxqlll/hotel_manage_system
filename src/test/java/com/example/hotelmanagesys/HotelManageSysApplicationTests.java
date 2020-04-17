package com.example.hotelmanagesys;

import com.example.hotelmanagesys.modules.admin.order.controller.OrderProcessingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelManageSysApplicationTests {

    @Autowired
    OrderProcessingController orderProcessingController;
    @Test
    void contextLoads() {
        orderProcessingController.queryOrderProcessing(1,10);
    }

}
