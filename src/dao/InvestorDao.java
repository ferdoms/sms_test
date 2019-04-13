/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Investor;
import util.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacqu
 */
public class InvestorDao implements Dao <Investor>{
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    
   
    @Override
    public void save (Investor i) {
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object investor
            session.save(i);
            //Commit transaction
            transaction.commit();
            //Close session
            session.close();
        
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Investor getById(int id) {
        
        try {
            //Start a transaction
            transaction = session.beginTransaction();
            //Get investor by primary key id
            Investor  i = (Investor) session.get(Investor.class, id);
            //Commit transaction
            transaction.commit();
            //Return company
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Investor> getAll() {
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<Investor> criteria = builder.createQuery(Investor.class);
            //Specify criteria root
            criteria.from(Investor.class);
            //Execute query
            List<Investor> investors = session.createQuery(criteria).getResultList();
            //Close session
            session.close();
            //Return all investors
            return investors;

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

   

}
