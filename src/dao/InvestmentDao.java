/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Investment;
import util.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author fernandoms
 */
public class InvestmentDao implements Dao <Investment> {
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    @Override
    public void save(Investment investment) {
     
        try {

            //start a transaction
            transaction = session.beginTransaction();
            //save object
            session.save(investment);
            //commit transaction
            transaction.commit();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Investment getById(int id) {
        try {
            //Start a transaction
            transaction = session.beginTransaction();
            //Get investment by primary key id
            Investment investment = (Investment) session.get(Investment.class, id);
            //Commit transaction
            transaction.commit();
            //Return investment 
            return investment;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Investment> getAll() {
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<Investment> criteria = builder.createQuery(Investment.class);
            //Specify criteria root
            criteria.from(Investment.class);
            //Execute query
            List<Investment> investments = session.createQuery(criteria).getResultList();
            //Close session
            session.close();
            //Return all investments
            return investments;

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    
   
}
