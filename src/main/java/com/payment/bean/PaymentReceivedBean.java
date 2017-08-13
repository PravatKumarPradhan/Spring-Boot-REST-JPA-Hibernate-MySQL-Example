/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Gulam Mustafa
 */
public class PaymentReceivedBean {

    private String customerId;
    private Date customerBillingDate;
    private BigDecimal payAmount;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getCustomerBillingDate() {
        return customerBillingDate;
    }

    public void setCustomerBillingDate(Date customerBillingDate) {
        this.customerBillingDate = customerBillingDate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
    
    

}
