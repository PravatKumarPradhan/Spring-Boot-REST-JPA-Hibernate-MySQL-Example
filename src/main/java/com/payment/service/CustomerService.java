/**
 *
 */
package com.payment.service;

import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import java.util.List;
/**
 *
 * @author Gulam Mustafa
 */
public interface CustomerService {

    List<Customer> getCustomerDetails();

    List<CustomerBillingInformation> getCustomerBillingInformation();

}
