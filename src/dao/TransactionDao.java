/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Transaction;
import org.hibernate.Session;
import util.HibernateUtil;



/**
 *
 * @author joao-
 */
public class TransactionDao implements Dao<Transaction>{

    @Override
    public void save(Transaction t) {
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the company object
            session.save(t);
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
}
