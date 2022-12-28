package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Order;
import com.arteni.mag.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @PostMapping
    public Order createOrder(@RequestBody Order orderFromReq) throws SQLException {
        return orderDAO.createOrder(orderFromReq);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) throws SQLException {
        return orderDAO.getOrderById(id);
    }
}
