/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import dao.InvestmentDao;
import dao.TransactionDao;
import entities.Company;
import entities.Investor;
import interfaces.Broker;
import entities.Investment;
import java.util.ArrayList;
import entities.Share;
import entities.TransactionRecord;
import java.util.Iterator;

/**
 *
 * @author fernandoms
 */
public class ShareBroker implements Broker {
    
    private ArrayList<Investment> investments = new ArrayList<Investment>();
    private int transactionsPeformed;
    private Report report = new Report();
    InvestmentDao investmentDao = new InvestmentDao();
    
    public void update(){
        this.valueShares(report.highDemandShares());
        this.devalueShares(report.lowDemandShares());
        
    }
    @Override
    public Investment[] investmentsUpTo(int amount){
        // get list of investments
        ArrayList<Investment> temp = investments;
        // filter investments valued up to @param amount
        temp.removeIf(i-> (i.getValue() > amount));
        
        Object[] tempArray = temp.toArray();
        Investment[] tempArrayInvest = new Investment[tempArray.length];
            for (int i=0;i<tempArray.length;i++){
                tempArrayInvest[i] = (Investment)tempArray[i];
            }
        return tempArrayInvest;
    }
    @Override
    public void createInvestments(ArrayList<Company> companies) {
        Iterator comps = companies.iterator();
        while(comps.hasNext()){
            Company company = (Company)comps.next();
            for(int i=0;i<company.getNumberOfShares();i++){
                Investment share = new Share(company);
                investmentDao.save(share);
                investments.add(share);
            }
        }
    }

    @Override
    public void recordTransaction(Investor investor, Investment investment) {
        report.saveTransaction(investor, investment);
    }
    
    private void valueShares(Share[] shares){
        for(Share share:shares){
            int actualValue = share.getValue();
            share.setValue(actualValue*2);
            investmentDao.save(share);
            investments.removeIf(i -> (i.getId() == share.getId()));
            investments.add(share);
        }
    }
    private void devalueShares(Share[] shares){
        for(Share share:shares){
            int actualValue = share.getValue();
            share.setValue((int)Math.round(actualValue*0.05));
            investmentDao.save(share);
            investments.removeIf(i -> (i.getId() == share.getId()));
            investments.add(share);
        }
    }
    public void performTransaction(Investor investor, Investment investment ){
        try{
            investor.confirmAquisition(investment);
            this.recordTransaction(investor, investment);
            transactionsPeformed++;
            investments.remove(investment);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private class Report{
        ArrayList<TransactionRecord> transactions = new ArrayList<TransactionRecord>();
        
        void saveTransaction(Investor buyer, Investment investment){
            TransactionRecord record = new TransactionRecord(buyer,investment);
            new TransactionDao().save(record);

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
