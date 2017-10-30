/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.test;

import ec.edu.espe.developers.espe.mongo.model.App;
import ec.edu.espe.developers.espe.mongo.model.Audit;
import ec.edu.espe.developers.espe.mongo.model.Token;
import ec.edu.espe.developers.espe.mongo.model.User;
import ec.edu.espe.developers.espe.mongo.service.AppService;
import ec.edu.espe.developers.espe.mongo.service.AuditService;
import ec.edu.espe.developers.espe.mongo.service.TokenService;
import ec.edu.espe.developers.espe.mongo.service.UserService;
import java.util.Date;
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
        //APP
        AppService service = new AppService();
        for (int i = 0; i < 250; i++) {
            App test = new App();
            test.setName("APP" + RandomStringUtils.randomNumeric(6));
            test.setClient_id(RandomStringUtils.randomAlphanumeric(32));
            test.setClient_secret(RandomStringUtils.randomAlphanumeric(32));
            test.setDescription("APPPP" + RandomStringUtils.randomAlphabetic(6));
            test.setCodigo(RandomStringUtils.randomAlphabetic(4));

            service.insert(test);
            System.out.println(">> " + i);
        }
        System.out.println("-------------------------");

    }
}
