/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mustafa
 */
@Entity
@Table(name = "customer_billing_information")
public class CustomerBillingInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerBillingInformationPK customerBillingInformationPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Customer_Total_Bil_Amount")
    private BigDecimal customerTotalBilAmount;
    @Column(name = "Customer_Remaing_Balance")
    private BigDecimal customerRemaingBalance;
    public CustomerBillingInformation() {
    }

    public CustomerBillingInformation(CustomerBillingInformationPK customerBillingInformationPK) {
        this.customerBillingInformationPK = customerBillingInformationPK;
    }

    public CustomerBillingInformation(String customerId, Date customerBillingDate) {
        this.customerBillingInformationPK = new CustomerBillingInformationPK(customerId, customerBillingDate);
    }

    public CustomerBillingInformationPK getCustomerBillingInformationPK() {
        return customerBillingInformationPK;
    }

    public void setCustomerBillingInformationPK(CustomerBillingInformationPK customerBillingInformationPK) {
        this.customerBillingInformationPK = customerBillingInformationPK;
    }

    public BigDecimal getCustomerTotalBilAmount() {
        return customerTotalBilAmount;
    }

    public void setCustomerTotalBilAmount(BigDecimal customerTotalBilAmount) {
        this.customerTotalBilAmount = customerTotalBilAmount;
    }

    public BigDecimal getCustomerRemaingBalance() {
        return customerRemaingBalance;
    }

    public void setCustomerRemaingBalance(BigDecimal customerRemaingBalance) {
        this.customerRemaingBalance = customerRemaingBalance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerBillingInformationPK != null ? customerBillingInformationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerBillingInformation)) {
            return false;
        }
        CustomerBillingInformation other = (CustomerBillingInformation) object;
        if ((this.customerBillingInformationPK == null && other.customerBillingInformationPK != null) || (this.customerBillingInformationPK != null && !this.customerBillingInformationPK.equals(other.customerBillingInformationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jpa.CustomerBillingInformation[ customerBillingInformationPK=" + customerBillingInformationPK + " ]";
    }
    
}
