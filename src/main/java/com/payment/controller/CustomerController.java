package com.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.entity.CustomerPayment;
import com.payment.service.CustomerPaymentService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payment.service.CustomerService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gulam Mustafa
 */
@RestController
@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Autowired
    private Gson gson;

    @Autowired
    private CustomerService userService;
    @Autowired
    private CustomerPaymentService customerPaymentService;

    LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public String userDetails() {
        try {
            List<Customer> customerList = new ArrayList<>();
            customerList = userService.getCustomerDetails();
            response.put("customers", customerList);
        } catch (Exception e) {
        }
        return gson.toJson(response);
    }

    @RequestMapping(value = "/bills", method = RequestMethod.GET, produces = "application/json")
    public String customerBillingInformationDetails() {
        List<CustomerBillingInformation> customerBill = new ArrayList<>();
        try {
            customerBill = userService.getCustomerBillingInformation();
            response.put("bills", customerBill);
        } catch (Exception e) {
        }
        return gson.toJson(response);
    }

    @RequestMapping(value = "/bill/payments", method = RequestMethod.GET, produces = "application/json")
    public String customerPaymentDetails() {
        List<CustomerPayment> customerPayment = new ArrayList<>();
        try {
            customerPayment = customerPaymentService.getCustomerPayment();

            response.put("payments", customerPayment);
        } catch (Exception e) {
        }
        return gson.toJson(response);

    }

}
