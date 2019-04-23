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
    
    private int transactionsPeformed;
    private Report report = new Report();
    InvestmentDao investmentDao = new InvestmentDao();
    
    public void update(){
        // decrease price of low demand companies
        //get low demand investments
        Object[] list = ((Object[])report.getLowDemandInvestment());
        
            System.out.println(transactionsPeformed);
        // for each investment on the list reduce 2% of its price
        if(list != null){
            for(Object item:list){
               Investment i = investmentDao.getById((int)item);
//                System.out.println((int)Math.round(((Share)i).getValue()*0.98));
               ((Share)i).setValue((int)Math.round(((Share)i).getValue()*0.98)); 
               investmentDao.update(i);
            }
        }
        
    }
    @Override
    public Investment[] investmentsUpTo(int amount){
        // get list of investments
        List<Investment> temp = investmentDao.getAll();
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
            investmentDao.update(investment);
            transactionsPeformed++;
            //update shares prices
            if((transactionsPeformed%10)==0){
                this.update();
            }
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
        Object[] getLowDemandInvestment(){
            List<Object[]> list = new TransactionDao().getLowDemandInvestment();
            Iterator iList = list.iterator();
            List<Integer> cIdList = new ArrayList<Integer>();
            while(iList.hasNext()){
                Object[] o = (Object[])iList.next();
                cIdList.add((Integer)o[0]);
            }
            return cIdList.toArray();
        }

    } 
}
