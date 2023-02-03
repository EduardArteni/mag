package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Order;
import com.arteni.mag.Models.OrderStatus;
import com.arteni.mag.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)

public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @PostMapping("order")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Order createOrder(@RequestBody Order orderFromReq) throws SQLException {
        return orderDAO.createOrder(orderFromReq);
    }

    @GetMapping("order/{id}")
    public Order getOrderById(@PathVariable int id) throws SQLException {
        return orderDAO.getOrderById(id);
    }

    @GetMapping("orders/{id}")
    public ArrayList<Order> getOrdersByUserId(@PathVariable int id) throws SQLException {
        return orderDAO.getOrdersByUserId(id);
    }

    @PutMapping("order/pay/{id}")
    public boolean payOrder(@PathVariable int id) throws SQLException {
        return orderDAO.payOrder(id);
    }

    @PutMapping("order/cancel/{id}")
    public boolean cancelOrder(@PathVariable int id) throws SQLException {
        return orderDAO.cancelOrder(id);
    }


    @GetMapping("order/status/{id}")
    public OrderStatus getOrderStatus(@PathVariable int id) throws SQLException {
        Order order = orderDAO.getOrderById(id);
        if (order != null)
            return order.getStatus();
        return OrderStatus.NONEXISTENT;
    }
}
