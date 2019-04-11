/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.InheritanceType;

/**
 *
 * @author fernandoms
 */

@Entity(name="investment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="investment_type", 
  discriminatorType = DiscriminatorType.STRING)
public abstract class Investment {

    @Id
    private int id;
    
    int value = 0;
    int transactionsPeformed = 0;
    String type = null;
    
    public int getValue(){
        return this.value;
    }
    public String getType(){
        return this.type;
    }

    public int getId() {
        return id;
    }
}
