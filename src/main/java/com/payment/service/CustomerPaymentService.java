/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.service;

import com.payment.entity.CustomerPayment;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mustafa
 */
public interface CustomerPaymentService {
        List<CustomerPayment> getCustomerPayment();
        List<CustomerPayment> parse(MultipartFile file);
}
