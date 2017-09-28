package com.example.customer;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/add-customer")
    public String addCustomer(Model model) {
        return "add-customer";
    }

    @PostMapping("/add-customer")
    public String addCustomerPost(
            @RequestParam(value="firstname", required=true) String firstname,
            @RequestParam(value="lastname", required=true) String lastname,
            @RequestParam(value="email", required=true) String email,
            @RequestParam(value="phone", required=true) String phone
            ) {
        System.out.println("add-customer post");
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstname);
        newCustomer.setLastName(lastname);
        newCustomer.setPhone(phone);
        newCustomer.setEmail(email);

        customerService.addCustomer(newCustomer);

        return "redirect:/customers";
    }

    @GetMapping("/customer/{id}")
    public String getCustomer(Model model,
            @PathVariable("id") Integer id
    ) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute(customer);

        return "view-customer";
    }
}
