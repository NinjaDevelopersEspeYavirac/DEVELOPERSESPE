/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.test;

import ec.edu.espe.developers.espe.mongo.model.User;
import ec.edu.espe.developers.espe.mongo.service.UserService;

/**
 *
 * @author luis
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User test = new User();
        test.getLocal().setId("L00000181");
        test.getLocal().setName("LUIS IVAN ESPIN VELASCO");
        test.getLocal().setPassword("11111111111111111111111111");
        test.setAdmin(Boolean.TRUE);
        UserService service = new UserService();
        service.insert(test);
        
        

    }
}
    // TODO code application logic here
