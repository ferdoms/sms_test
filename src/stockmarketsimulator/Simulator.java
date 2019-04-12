/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import builders.CompanyBuilder;
import builders.Director;
import builders.InvestorBuilder;
import dao.CompanyDao;
import dao.InvestorDao;
import entities.Company;
import entities.Investor;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class Simulator {
    //creating arraylists for company and investors
    public ArrayList<Company> companies = new ArrayList<Company>();
    public ArrayList<Investor> investors = new ArrayList<Investor>();
    
    public void loadCompanies(int amount){
        // instantiate company's builder
        CompanyBuilder comBuilder = new CompanyBuilder();
        // instantiate director's object
        Director director = new Director();
        
        //loop over elements
        for(int n=1; n<=amount; n++){
            director.constructCompany(comBuilder);
            Company newCompany = comBuilder.getObject();
           new CompanyDao().save(newCompany);
           companies.add(newCompany);
        }
    }
    
    public void loadInvestors(int amount){
         // instantiate investor's builder
        InvestorBuilder invBuilder = new InvestorBuilder();
        // instantiate director's object
        Director director = new Director();
        //loop over elements
        for(int n=1; n<=amount; n++){
            director.constructInvestor(invBuilder);
            Investor newInvestor = invBuilder.getObject();
           new InvestorDao().save(newInvestor);
           investors.add(newInvestor);
        }
    }
    
    public void tradingDay(){
        ShareBroker sb = new ShareBroker();
        sb.createInvestments(companies);
        
        Iterator investorsIte = investors.iterator();
        while(investorsIte.hasNext()){
            ((Investor)investorsIte.next()).buyInvestent(sb);
//            sb.update();
        }
    }
}
