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
          test.setDescription("APPPP"+RandomStringUtils.randomAlphabetic(6));
          test.setCodigo(RandomStringUtils.randomAlphabetic(4));

          service.insert(test);
          System.out.println(">> " + i);
      }
        System.out.println("-------------------------");
    //TOKEN
        Date date_in = new Date();
        Date date_out = new Date();
        
        AppService appService = new AppService();
        App application = appService.findByCodigo("APP24RYPZCP");
        TokenService service0 = new TokenService();
        
        for (int i = 0; i < 500; i++) {
            Token test = new Token();
            test.setApplication(application);
            test.setHash(RandomStringUtils.randomNumeric(8));
            test.setDate_in(date_in);
            test.setDate_out(date_out);
            test.setForever(Boolean.TRUE);
            service0.insert(test);
            System.out.println(">> " + i);
            
        }
         System.out.println("-------------------------");
        //AUDIT
        Date date= new Date();
             AuditService service1 = new AuditService();
       App app = appService.findByCodigo("APP24RYPZCP");
       for (int i = 0; i < 250; i++) {
           Audit test = new Audit();
           test.setApplication(app);
           test.setDate(date);
           test.setIp("104.168.1." + RandomStringUtils.randomNumeric(3));
           test.setToken(RandomStringUtils.randomNumeric(6));
           test.setSearch("https://aplicaciones.espe.edu.ec:8443/authentication/api/query/ced=1718552365&auth=ba82e1071cd1ea9669a62f24213ba4a4.cf3df0e97b7a4cc68aeaab8d6bbb9691");
           service1.insert(test);
           System.out.println(">> " + i);
       }
        System.out.println("-------------------------");
       UserService service2 = new UserService();
       for (int i = 0; i < 250; i++) {
           User test = new User();
           test.getLocal().setId("L00" + RandomStringUtils.randomNumeric(6));
           test.getLocal().setName("1804110474");
           test.getLocal().setPassword(RandomStringUtils.randomAlphanumeric(32));
           test.setAdmin(Boolean.TRUE);

           service2.insert(test);
           System.out.println(">> " + i);
   }
        System.out.println("EXITO");
    }
    // TokenService service0 = new TokenService();
 //Token token= service0.findByToken("TOKEN10IAARLK");
 
      // System.out.println(">> "+""+token.toString());
    }
     
    // TODO code application logic here
