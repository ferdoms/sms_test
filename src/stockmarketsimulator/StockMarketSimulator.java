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
import dao.InvestmentDao;
import dao.InvestorDao;
import entities.Company;
import entities.Investment;
import entities.Investor;
import entities.Share;
import entities.TransactionRecord;
import interfaces.Broker;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author fernandoms
 */
public class StockMarketSimulator {

    private static Dao<Company> CompanyDao;

    public static void main(String[] args) {

        //
        CompanyDao companyDao = new CompanyDao();
        //Company company = new Company();
        InvestorDao investorDao = new InvestorDao();
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
        sim.loadBroker(new ShareBroker());
        sim.tradingDay();

        //----------findById and getAll COMPANIES TESTS----------------------------------------------
//        System.out.println(companyDao.getById(5));
//        List<Company> companies = companyDao.getAll();
//        System.out.print(companies);
//
//        
//        
//        //----------findById and getAll INVESTORS TESTS----------------------------------------------
//        System.out.println(investorDao.getById(5));
//        List<Investor> investors = investorDao.getAll();
//        System.out.print(investors);
        
//        CompanyBuilder cb = new CompanyBuilder();
//        Director d = new Director();
//        d.constructCompany(cb);
//        Company c = cb.getObject();
//        new CompanyDao().save(c);
//        Investment s = new Share(c);
//        InvestmentDao investDao = new InvestmentDao();
//        investDao.save(s);
//        
//        new TransactionRecord()
        
    }

}
