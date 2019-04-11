/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author fernandoms
 */
public interface Investment {
    
    int value = 0;
    int transactionsPeformed = 0;
    String type = null;
    
    public int getValue();
    public String getType();
    
}
