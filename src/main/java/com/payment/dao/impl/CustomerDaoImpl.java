package com.payment.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payment.dao.CustomerDao;
import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.entity.CustomerBillingInformationPK;
import com.payment.entity.CustomerPayment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Gulam Mustafa
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomerDetails() {
        Criteria criteria = sessionFactory.openSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public List<CustomerBillingInformation> getCustomerBillingInformation() {
        Criteria criteria = sessionFactory.openSession().createCriteria(CustomerBillingInformation.class);
        return criteria.list();
    }

    @Override
    public List<CustomerPayment> getCustomerPayment() {
        Criteria criteria = sessionFactory.openSession().createCriteria(CustomerPayment.class);
        return criteria.list();
    }

    @Override
    public Customer getCustomerByCusID(String customerId) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("customerId", customerId));
        Customer customer = (Customer) criteria.uniqueResult();
        return customer;

    }

    @Override
    public CustomerBillingInformation getCustomerBillingInformation(String customerId, Date customerBillingDate) {
        Session session = sessionFactory.openSession();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String myDate = new SimpleDateFormat("yyyy-MM-dd").format(customerBillingDate);
        // gets the book entity back
        CustomerBillingInformationPK pk = new CustomerBillingInformationPK();
        pk.setCustomerId(customerId);
        pk.setCustomerBillingDate(customerBillingDate);
        CustomerBillingInformation customerBillingInformation = (CustomerBillingInformation) session.get(CustomerBillingInformation.class, pk);
        session.flush();
        session.close();;
        return customerBillingInformation;

    }

    @Override
    public CustomerBillingInformation updateCusBill(CustomerBillingInformation cusBillUpdate) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(cusBillUpdate);
        session.getTransaction().commit();
        session.flush();
        session.close();;
        return cusBillUpdate;
    }

    @Override
    public CustomerPayment create(CustomerPayment customerPayment) {
        Session session = sessionFactory.openSession();

        session.save(customerPayment);

        session.flush();
        session.close();;

        return customerPayment;
    }

    @Override
    public CustomerPayment updateCustomerPayment(CustomerPayment customerPayment) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(customerPayment);
        session.getTransaction().commit();
        session.flush();
        session.close();;
        return customerPayment;
    }

}
