package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Order;
import com.arteni.mag.dao.OrderDAO;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order orderFromReq) {
        OrderDAO orderDAO = new OrderDAO();
        Order newCreatedOrder = null;

        try {
            newCreatedOrder = orderDAO.createOrder(orderFromReq);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return newCreatedOrder;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/order", method = RequestMethod.GET)
    public Order getOrderById(@RequestParam(value = "id") int id) {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.getOrderById(id);
    }
}
