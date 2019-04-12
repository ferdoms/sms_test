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
import interfaces.Broker;
import java.util.ArrayList;
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
        
                
        //----------Simulator TESTS----------------------------------------------      
            Simulator sim = new Simulator();
//            sim.loadCompany();
//            sim.loadInvestors();
            
        //----------Broker TESTS----------------------------------------------
            
            sim.loadCompanies(10);
            sim.loadInvestors(10);
            sim.tradingDay();
            
        }
}