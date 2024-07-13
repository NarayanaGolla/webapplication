package com.web.application.dao.impl;

import com.web.application.dao.RegisterDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("myRegisterDao")
public class RegisterDaoImpl extends DefaultDaoImpl implements RegisterDao {

    @Override
    public Serializable save(Object persistObject) {

        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(persistObject);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

        return null;
    }

}
