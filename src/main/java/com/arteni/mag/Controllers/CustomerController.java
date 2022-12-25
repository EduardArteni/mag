package com.arteni.mag.Controllers;

import com.arteni.mag.Models.Customer;
import com.arteni.mag.dao.CustomerDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/customer", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam(value = "id") Long id) {

        return customerDAO.findById(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/customersByLastName", method = RequestMethod.GET)
    public List<Customer> findByLastName(@RequestParam(value = "lastName") String lastName) {
        return customerDAO.findByLastName(lastName);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/allCustomers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @RequestMapping(value = "/api/v1/customer", method = RequestMethod.PUT)
    public void update(@RequestParam(value = "id") Long id) {

        System.out.println("CustomerController.update");
        System.out.println("id = " + id);
        //TODO finish to receive a JSON from request and pass it to DAO
//        System.out.println("customerFromReq = " + customerFromReq);
//
//        Customer existingCustomer = customerDAO.findById(id);
//        BeanUtils.copyProperties(customerFromReq, existingCustomer, "id");
//
//        customerDAO.updateCustomer(existingCustomer);
    }
}
