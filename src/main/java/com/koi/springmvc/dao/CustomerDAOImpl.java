package com.koi.springmvc.dao;

import com.koi.springmvc.constant.SortCustomerColumn;
import com.koi.springmvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers(int sortField) {
        // Get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        String sort = null;
        switch (sortField) {
            case SortCustomerColumn.LAST_NAME:
                sort = "last_name";
                break;
            case SortCustomerColumn.EMAIL:
                sort = "email";
                break;
            default:
                sort = "first_name";
        }

        Query<Customer> query = session.createQuery("from Customer order by " + sort, Customer.class);

        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Customer where id =:customerId").setParameter("customerId", id).executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        if (keyword != null && keyword.trim().length() > 0) {
            query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
            query.setParameter("name", "%" + keyword + "%");
        }

        return query.getResultList();
    }
}
