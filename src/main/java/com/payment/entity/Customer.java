/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mustafa
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Customer_Id")
    private String customerId;
    @Column(name = "Customer_name")
    private String customername;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Customer_Total_Balance")
    private BigDecimal customerTotalBalance;
    @Column(name = "Customer_mobile_No")
    private Integer customermobileNo;

    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public BigDecimal getCustomerTotalBalance() {
        return customerTotalBalance;
    }

    public void setCustomerTotalBalance(BigDecimal customerTotalBalance) {
        this.customerTotalBalance = customerTotalBalance;
    }

    public Integer getCustomermobileNo() {
        return customermobileNo;
    }

    public void setCustomermobileNo(Integer customermobileNo) {
        this.customermobileNo = customermobileNo;
    }

}
