/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Investor;

/**
 *
 * @author fernandoms
 */
public interface Broker {
    
    // this method should updade investments value
    public void update();
    // should return any investment with values up to the inserted parameter
    public Investment[] investmentsUpTo(int value);
    // create investments ideally store in arrayList;
    public void createInvestments();
    
    public void performTransaction(Investor investor, Investment investment);
    
    public void recordTransaction();
    
    public class Report{};
    
}
