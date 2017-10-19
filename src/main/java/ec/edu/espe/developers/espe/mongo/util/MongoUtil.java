/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author luis
 */
public class MongoUtil {

    MongoClientURI connectionString;
    MongoClient mongoClient;
    private Morphia morphia;
    private Datastore datastore;

    public MongoUtil() {
        this.connectionString = new MongoClientURI("mongodb://yavirac:yavirac@10.1.0.93:27017/developersEspe?authSource=admin");
        this.mongoClient = new MongoClient(connectionString);
        this.datastore = this.morphia.createDatastore(mongoClient, "developersEspe");
    }

}
