package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Order;
import com.arteni.mag.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order orderFromReq) {
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
    public Order getOrderById(@RequestParam(value = "id") int id) throws SQLException {
        return orderDAO.getOrderById(id);
    }
}
