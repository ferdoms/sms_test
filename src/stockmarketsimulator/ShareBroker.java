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
import java.util.List;

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
        Object[] cId = ((Object[])report.getLastTransactionsComp());
        p
        
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
            Investment share = new Share(company);
            investmentDao.save(share);
            investments.add(share);
        }
    }

    @Override
    public void recordTransaction(Investor investor, Investment investment) {
        report.saveTransaction(investor, investment);
    }
    public void performTransaction(Investor investor, Investment investment ){
        try{
            investor.confirmAquisition(investment);
            this.recordTransaction(investor, investment);
            ((Share)investment).accountSoldShare();
            investmentDao.save(investment);
            transactionsPeformed++;
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
        Object[] getLastTransactionsComp(){
            List<Object[]> list = new TransactionDao().getLastTransactionsComp();
            
            return list.toArray();
        }

    } 
}
