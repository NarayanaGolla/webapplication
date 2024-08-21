package com.web.application.dao.impl;

import com.web.application.dao.RegisterDao;
import com.web.application.dom.RegisterComparators;
import com.web.application.dom.User;
import com.web.application.exception.CustomException;
import com.web.application.dom.Register;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("myRegisterDao")
public class RegisterDaoImpl extends DefaultDaoImpl implements RegisterDao {


    @Override
    public Serializable save(Object persistObject) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(persistObject);
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

    @Override
    public Optional<Register>  loginUser(String password, String emailed) throws CustomException {
        return findByPasswordOrMail(password, emailed) ;
    }

    @Override
    public Optional<Register>  findByUsernameAndEmail(String username, String emailed) throws CustomException {

        String hql = "from Register where userName=:username and emailId=:emailId";
        Query<Register> q = null;

        Session session = getSession();

        try {

           // q = session.createQuery(hql);
              q = session.createQuery(hql, Register.class);
              q.setParameter("username",username);
              q.setParameter("emailId",emailed);

        } catch(Exception e) {
            throw new CustomException(e.getMessage());  // Wrap the original exception
        }

        List<Register> results = q.list();
        boolean isEmptyList = CollectionUtils.isEmpty(results);
        if(!isEmptyList) {
          Register  object  = Optional.ofNullable(results.get(0)).orElseGet(this::getMyDefault);
            if (object instanceof Register) {
                System.out.println("movable is an instance of Car.");
                return Optional.of(object);
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Register> fetchUserRegisterList() {

        int pageSize = 100;
        int pageNumber = 0;

        Session session = getSession();;
       // Transaction transaction = session.beginTransaction();

        String hql = "FROM Register";
        Query<Register> query = session.createQuery(hql, Register.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        List<Register> registerList = query.getResultList();
        registerList.sort(RegisterComparators.byId());

       // transaction.commit();
        session.close();


        return registerList;
    }


    public Optional<Register>  findByPasswordOrMail(String password, String emailed) throws CustomException {

        String hql = "from Register where password=:password or emailId=:emailed";
        Query q = null;
        Session session = getSession();

        try {

            q = session.createQuery(hql);
            q.setParameter("password",password);
            q.setParameter("emailed",emailed);

        } catch(Exception e) {
            throw new CustomException(e.getMessage());  // Wrap the original exception
        }

        List<Register> results = q.list();
        boolean isEmptyList = CollectionUtils.isEmpty(results);
        if(!isEmptyList) {
            Register  object  = Optional.ofNullable(results.get(0)).orElseGet(this::getMyDefault);
            if (object instanceof Register) {
                System.out.println("movable is an instance of Car.");
                return Optional.of(object);
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    public Register getMyDefault() {
        System.out.println("Getting Default Value");
        return null;
    }

    public Session getSession() {

        SessionFactory sessionFactory = getSessionFactory();
       return sessionFactory.openSession();
    }

}
