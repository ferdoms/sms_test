/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.Investment;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 *
 * @author fernandoms
 */
@Entity
@DiscriminatorValue("share")
public class Share extends Investment {
    
    
    @Override
    public int getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
