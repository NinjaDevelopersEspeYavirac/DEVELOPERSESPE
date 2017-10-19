/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.test;

import ec.edu.espe.developers.espe.mongo.model.User;
import ec.edu.espe.developers.espe.mongo.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author luis
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UserService service = new UserService();
        for (int i = 0; i < 10000000; i++) {
            User test = new User();
            test.getLocal().setId("L00" + RandomStringUtils.randomNumeric(6));
            test.getLocal().setName(RandomStringUtils.randomAlphabetic(4) + " "
                    + RandomStringUtils.randomAlphabetic(4) + " "
                    + RandomStringUtils.randomAlphabetic(6) + " "
                    + RandomStringUtils.randomAlphabetic(5));
            test.getLocal().setPassword(RandomStringUtils.randomAlphanumeric(32));
            test.setAdmin(Boolean.TRUE);

            service.insert(test);
            System.out.println(">> " + i);
        }
    }
}
    // TODO code application logic here
