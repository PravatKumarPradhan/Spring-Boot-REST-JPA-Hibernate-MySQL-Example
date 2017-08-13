/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mustafa
 */
@Embeddable
public class CustomerBillingInformationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Customer_Id")
    private String customerId;
    @Basic(optional = false)
    @Column(name = "Customer_Billing_Date")
    @Temporal(TemporalType.DATE)
    private Date customerBillingDate;

    public CustomerBillingInformationPK() {
    }

    public CustomerBillingInformationPK(String customerId, Date customerBillingDate) {
        this.customerId = customerId;
        this.customerBillingDate = customerBillingDate;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (customerBillingDate != null ? customerBillingDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerBillingInformationPK)) {
            return false;
        }
        CustomerBillingInformationPK other = (CustomerBillingInformationPK) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.customerBillingDate == null && other.customerBillingDate != null) || (this.customerBillingDate != null && !this.customerBillingDate.equals(other.customerBillingDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jpa.CustomerBillingInformationPK[ customerId=" + customerId + ", customerBillingDate=" + customerBillingDate + " ]";
    }
    
}
