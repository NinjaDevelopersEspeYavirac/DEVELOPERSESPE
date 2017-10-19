/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author luis
 */
public class Connection {

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    private static final Connection INSTANCE = new Connection();
    private final Datastore datastore;
    private final ConfigDTO config;

    private Connection() {
        ConfigReader reader = new ConfigReader();
        this.config = reader.getConfiguration();
        if (this.config != null) {
            MongoClient mongoClient;
            MongoClientOptions mongoOptions = MongoClientOptions.builder().socketTimeout(this.config.getSocketTimeout().intValue()).connectTimeout(this.config.getConnectionTimeout().intValue()).build();
            try {
                String user = "developers.2017";
                String database = "developersEspe";
                char[] password = {'E', 's', 'p', 'e', '.', '2', '0', '1', '7'};
                MongoCredential credential = MongoCredential.createCredential(user, database, password);
                mongoClient = new MongoClient(new ServerAddress(this.config.getHost(), this.config.getPort().intValue()),
                        Arrays.asList(credential),
                        mongoOptions);
            } catch (Exception e) {
                throw new RuntimeException("Error initializing MongoDB", e);
            }
            mongoClient.setWriteConcern(WriteConcern.SAFE);
            Morphia morphia = new Morphia();
            for (String packageN : this.config.getPackages()) {
                morphia.mapPackage(packageN, true);
            }
            this.datastore = morphia.createDatastore(mongoClient, this.config.getDatabase());
            this.datastore.ensureIndexes();
            LOG.log(Level.INFO, "Connection: {0} initialized", this.config.toString());
        } else {
            LOG.info("Configuracion invalida, persistencia no disponible.");
            this.datastore = null;
        }
    }

    public static Connection instance() {
        return INSTANCE;
    }

    public Datastore getDatabase() {
        return this.datastore;
    }
}
