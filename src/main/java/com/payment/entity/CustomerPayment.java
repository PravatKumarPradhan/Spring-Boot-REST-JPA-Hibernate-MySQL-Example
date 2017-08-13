/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mustafa
 */
@Entity
@Table(name = "customer_payment")
public class CustomerPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Customer_ID")
    private String customerID;
    @Column(name = "Customer_Payment_Date")
    @Temporal(TemporalType.DATE)
    private Date customerPaymentDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Customer_Payment_Amount")
    private BigDecimal customerPaymentAmount;
    @Column(name = "Customer_Payment_processing_status")
    private Character customerPaymentprocessingstatus;


    public CustomerPayment() {
    }

    public CustomerPayment(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getCustomerPaymentDate() {
        return customerPaymentDate;
    }

    public void setCustomerPaymentDate(Date customerPaymentDate) {
        this.customerPaymentDate = customerPaymentDate;
    }

    public BigDecimal getCustomerPaymentAmount() {
        return customerPaymentAmount;
    }

    public void setCustomerPaymentAmount(BigDecimal customerPaymentAmount) {
        this.customerPaymentAmount = customerPaymentAmount;
    }

    public Character getCustomerPaymentprocessingstatus() {
        return customerPaymentprocessingstatus;
    }

    public void setCustomerPaymentprocessingstatus(Character customerPaymentprocessingstatus) {
        this.customerPaymentprocessingstatus = customerPaymentprocessingstatus;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerPayment)) {
            return false;
        }
        CustomerPayment other = (CustomerPayment) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jpa.CustomerPayment[ customerID=" + customerID + " ]";
    }
    
}
