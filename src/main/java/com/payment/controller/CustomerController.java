package com.payment.controller;

import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.entity.CustomerPayment;
import com.payment.service.CustomerPaymentService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payment.service.CustomerService;
/**
 *
 * @author Gulam Mustafa
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService userService;
     @Autowired
    private CustomerPaymentService customerPaymentService;
     
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> userDetails() {

        List<Customer> userDetails = userService.getCustomerDetails();
        return new ResponseEntity<List<Customer>>(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/billInfo", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerBillingInformation>> CustomerBillingInformationDetails() {

        List<CustomerBillingInformation> userDetails = userService.getCustomerBillingInformation();
        return new ResponseEntity<List<CustomerBillingInformation>>(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/bilpmtInfo", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerPayment>> customerPaymentDetails() {

        List<CustomerPayment> userDetails = customerPaymentService.getCustomerPayment();
        return new ResponseEntity<List<CustomerPayment>>(userDetails, HttpStatus.OK);
    }

}
