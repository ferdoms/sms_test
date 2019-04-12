/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 *
 * @author fernandoms
 */
@Entity
@DiscriminatorValue("share")
public class Share extends Investment {
    
    Company company;
    
    public Share(Company company){
        this.value = company.getSharePrice();
        this.company = company;
    }
        
            
    public void setValue(int value){
        this.value = value;
    }
    
    public Company getCompany(){
        return company;
    }
}
