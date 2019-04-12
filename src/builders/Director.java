/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.Random;

/**f
 *
 * @author fernandoms
 */
public class Director {
    
    Random rand = new Random();
    String[] fname = {"Joao", "Pedro", "Fernando", "Jacqueline"};
    String[] lname = {"Nascimento", "Haddad", "Marinho", "Silva"};
    String[] cname = {"Facebook", "Google", "Microsoft", "Amazon"};
    
    public void constructInvestor(InvestorBuilder builder){
        String fname = this.fname[rand.nextInt(this.fname.length)];
        builder.setFirstName(fname);
        String lname = this.lname[rand.nextInt(this.lname.length)];
        builder.setLastName(lname);
        builder.setBudget(rand.nextInt(9000)+1000);
    }
    public void constructCompany(CompanyBuilder builder){
        String name = this.cname[rand.nextInt(this.cname.length)];
        builder.setName(name);
        builder.setNShare(rand.nextInt(500)+500);
        builder.setIPOShareValue(rand.nextInt(90)+10);
    }   
}
