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
import dao.Dao;
import dao.InvestorDao;
import entities.Company;
import entities.Investor;
import org.hibernate.Session;


/**
 *
 * @author fernandoms
 */
public class StockMarketSimulator {

    private static Dao<Company> CompanyDao;
    
    public static void main(String[] args) {
        
        //
//        CompanyDao companyDao = new CompanyDao();
//        InvestorDao investorDao = new InvestorDao();
//        Company c = new Company("Test5", 11, 10);
//        System.out.println("Beginning transaction");
//        companyDao.save(c);
//        System.out.println(c.getCompanyName() + " saved into Company's table");
//        Investor i = new Investor("Jackie", "Medeiros", 1000);
//        investorDao.save(i);
//        System.out.println(i.getFirstName() + " " + i.getLastName() + " saved into Investor's table");
        
        //----------BUILDER TESTS----------------------------------------------
        
//        InvestorBuilder invBuilder = new InvestorBuilder();
//        CompanyBuilder comBuilder = new CompanyBuilder();
//        
//        Director director = new Director();
//        
//        director.constructCompany(comBuilder);
//        Company c1 = comBuilder.getObject();
//        
//        director.constructCompany(comBuilder);
//        Company c2 = comBuilder.getObject();
//        
//        director.constructCompany(comBuilder);
//        Company c3 = comBuilder.getObject();
//        
//        
//        
//        director.constructInvestor(invBuilder);
//        Investor inv1 = invBuilder.getObject();
//        
//        director.constructInvestor(invBuilder);
//        Investor inv2 = invBuilder.getObject();
//        
//        director.constructInvestor(invBuilder);
//        Investor inv3 = invBuilder.getObject();
//        
//        
//        System.out.println(c1.getCompanyName() + " saved into Company's table");
//        System.out.println(c2.getCompanyName() + " saved into Company's table");
//        System.out.println(c3.getCompanyName() + " saved into Company's table");
//        System.out.println(inv1.getFirstName() + " " + inv1.getLastName() + " saved into Investor's table");
//        System.out.println(inv2.getFirstName() + " " + inv2.getLastName() + " saved into Investor's table");
//        System.out.println(inv3.getFirstName() + " " + inv3.getLastName() + " saved into Investor's table");



 //----------Simulator TESTS----------------------------------------------      
        Simulator sim = new Simulator();
        sim.loadCompany();
        sim.loadInvestors();
    }
}