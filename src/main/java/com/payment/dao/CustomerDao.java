package com.payment.dao;

import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.entity.CustomerPayment;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gulam Mustafa
 */
public interface CustomerDao {

    List<Customer> getCustomerDetails();

    Customer getCustomerByCusID(String CustomerId);

    List<CustomerBillingInformation> getCustomerBillingInformation();

    CustomerBillingInformation getCustomerBillingInformation(String CustomerId, Date customerBillingDate);

    CustomerBillingInformation updateCusBill(CustomerBillingInformation cusBillUpdate);

    List<CustomerPayment> getCustomerPayment();

    CustomerPayment create(CustomerPayment customerPayment);
    
    CustomerPayment updateCustomerPayment(CustomerPayment customerPayment);

}
