/**
 *
 */
package com.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dao.CustomerDao;
import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.service.CustomerService;
/**
 *
 * @author Gulam Mustafa
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao userDao;

    @Override
    public List<Customer> getCustomerDetails() {
        return userDao.getCustomerDetails();

    }

    @Override
    public List<CustomerBillingInformation> getCustomerBillingInformation() {
        return userDao.getCustomerBillingInformation();
    }

   

}
