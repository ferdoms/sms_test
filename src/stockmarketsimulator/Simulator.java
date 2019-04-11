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

/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class Simulator {
    //creating arraylists for company and investors
    public ArrayList<Company> companies = new ArrayList<Company>();
    public ArrayList<Investor> investors = new ArrayList<Investor>();
    
    public void loadCompany(){
        // instantiate company's builder
        CompanyBuilder comBuilder = new CompanyBuilder();
        // instantiate director's object
        Director director = new Director();
        
        //loop over elements
        for(int n=0; n<=99; n++){
            director.constructCompany(comBuilder);
            Company newCompany = comBuilder.getObject();
           new CompanyDao().save(newCompany);
           companies.add(newCompany);
        }
    }
    
    public void loadInvestors(){
         // instantiate investor's builder
        InvestorBuilder invBuilder = new InvestorBuilder();
        // instantiate director's object
        Director director = new Director();
        //loop over elements
        for(int n=0; n<=99; n++){
            director.constructInvestor(invBuilder);
            Investor newInvestor = invBuilder.getObject();
           new InvestorDao().save(newInvestor);
           investors.add(newInvestor);
        }
    }
}
