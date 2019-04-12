/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TransactionRecord;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import org.hibernate.Transaction;



/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class TransactionDao implements Dao<TransactionRecord>{

    @Override
    public void save(TransactionRecord t) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // start a transaction
            transaction = session.beginTransaction();
            // save the company object
            session.save(t);
            // commit transaction
            transaction.commit();
        }catch(Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
