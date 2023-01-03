package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Customer;
import com.arteni.mag.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerDAO.findById(id);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<Customer> findByLastName(@PathVariable String lastName) {
        return customerDAO.findByLastName(lastName);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Customer customerFromReq) {
        customerFromReq.setId(id);
        customerDAO.updateCustomer(customerFromReq);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customerFromReq) {
        return customerDAO.createCustomer(customerFromReq);
    }
}
