/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import entities.Company;
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
    private Report report = new Report();
            
    public ShareBroker(){
    
        
    }
    
    public void update(){
        this.valueShares(report.highDemandShares());
        this.devalueShares(report.lowDemandShares());
    }
    @Override
    public Investment[] investmentsUpTo(int amount){
        // get list of investments
        ArrayList<Investment> temp = investments;
        // filter investments valued up to @param amount
        temp.removeIf(i-> (i.getValue() < amount));
        
        return (Investment[])temp.toArray();
    }
    @Override
    public void createInvestments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recordTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void valueShares(Share[] shares){
        for(Share share:shares){
            int actualValue = share.getValue();
            share.setValue(actualValue*2);
            daoShare.save(share);
            investments.removeIf(i -> (i.getID() == share.getID));
            investments.add(share);
        }
    }
    private void devalueShares(Share[] shares){
        for(Share share:shares){
            int actualValue = share.getValue();
            share.setValue(actualValue*0.05);
            daoShare.save(share);
            investments.removeIf(i -> (i.getID() == share.getID));
            investments.add(share);
        }
    }
    public void performTransaction(Investor investor, Investment investment ){
        try{
            investor.confirmAquisition(investment);
            this.recordTransaction(investor, investment);
            transactionsPeformed++;
        }catch(Exception e){
            System.out.println(e);
        }
    }

    
    public void recordTransaction(Investor investor, Investment investment ){
        report.saveTransaction(investor, investment);
    }

    

 
    
    private class Report{
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        void saveTransaction(Investor buyer, Investment investment){
            
        }
        Company[] getOnDemandCompanies(){
            Company[] temp = null;
            return temp;
        }
            
        public Share[] highDemandShares(){
            Share[] shares = null;
//            ArrayList<Investment> temp = investments;
//            // filter shares from investments
//            temp.removeIf(i -> (i.getType() == "share"));
//            // get array of companies ids, which has sold 10 shares
//            Company[] companies = report.getOnDemandCompanies();
//            temp.removeIf(i -> (i.getCompany() == "share"));
//            for (Company company:companies){
//                
//            }

            return shares;
        }
        public Share[] lowDemandShares(){
            Share[] shares = null;
            return shares;
        }

    }
    
    
    
}
