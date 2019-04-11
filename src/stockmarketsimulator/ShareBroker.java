/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import entities.Investor;
import interfaces.Broker;
import interfaces.Investment;
import java.util.ArrayList;
import entities.Share;
import entities.Transaction;

/**
 *
 * @author fernandoms
 */
public class ShareBroker implements Broker {
    
    private ArrayList<Investment> investments = new ArrayList<Investment>();
    private int transactionsPeformed;
            
    public ShareBroker(){
    
        
    }
    
    public void update(){
        this.valueShares(this.highDemandShares());
        this.devalueShares(this.lowDemandShares());
    }
    
    public Investment[] SharesUpTo(int amount){
        // get list of investments
        ArrayList<Investment> temp = investments;
        // filter investments valued up to @param amount
        temp.removeIf(i-> (i.getValue() < amount));
        
        return (Investment[])temp.toArray();
    }
    
    public void performTransaction(Investor investor, Investment Investment ){
        
    }
    
    private class Report{
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        void saveTransaction(Investor buyer, Investment investment){
            
        }
    }
    
    
    
}
