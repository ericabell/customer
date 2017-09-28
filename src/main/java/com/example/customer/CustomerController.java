package com.example.customer;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/customers")
    public String customers(Model model) {
        // get all the customer data
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers();

        // populate the model
        model.addAttribute("customers", customers);

        //return the template
        return "customers";
    }
}
