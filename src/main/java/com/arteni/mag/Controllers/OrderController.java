package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Order;
import com.arteni.mag.dao.OrderDAO;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order createOrder(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "total") double total) {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.createOrder(user_id, total);
    }
}
