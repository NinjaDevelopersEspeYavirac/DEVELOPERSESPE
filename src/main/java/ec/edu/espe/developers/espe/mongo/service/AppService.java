/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.service;

import ec.edu.espe.developers.espe.mongo.model.App;
import ec.edu.espe.developers.espe.mongo.util.MongoPersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author NADIE
 */
public class AppService implements Serializable {

    private static final long serialVersionUID = 563549719444755084L;

    private MongoPersistence conn = new MongoPersistence();
    
    private Datastore ds = conn.context();

    public Boolean insert(App app) {
        Boolean exito = Boolean.FALSE;
        App axu = this.findByCodigo(app);
        if (axu.getId() == null) {
            app.setCodigoApp(this.obtenerCodigo());
            app.setFlag(1);
            this.ds.save(app);
            exito = Boolean.TRUE;
        }
        return exito;
    }
       private Integer obtenerCodigo() {
        List<App> apps = this.ds.find(App.class).asList();
        if (apps == null) {
            apps = new ArrayList<>();
        }
        Integer size = apps.size();
        Integer number = 1000 + 1 * size;
        return number;
    }

    public App findByCodigo(App app) {
        App find = new App();
        Query<App> result = this.ds.find(App.class).
                field("codigo").equal(app.getCodigoApp()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public App findByCodigo(Integer app) {
        App find = new App();
        Query<App> result = this.ds.find(App.class).
                field("codigo").equal(app).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }
    public App findById(App app) {
        App find = new App();
        Query<App> result = this.ds.find(App.class).
                field("id").equal(app.getId()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public App findById(Integer app) {
        App find = new App();
        Query<App> result = this.ds.find(App.class).
                field("id").equal(app).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }


    public Boolean deteleFlag(App app) {
        Query<App> query = this.ds.createQuery(App.class);
        app.setFlag(0);
        query.and(
                query.criteria("codigo").equal(app.getCodigoApp())
        );
        UpdateOperations<App> update = this.ds.createUpdateOperations(App.class);
        update.set("flag", app.getFlag());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }
    
    public Boolean update(App app) {
        Query<App> query = this.ds.createQuery(App.class);
        query.and(
                query.criteria("codigo").equal(app.getCodigoApp())
        );
        UpdateOperations<App> update = this.ds.createUpdateOperations(App.class);
        update.set("name", app.getName()).
                set("description", app.getDescription()).
                set("client_id", app.getClient_id()).
                set("client_secret", app.getClient_secret()).
                set("flag", app.getFlag()).
                set("last_change", app.getLastChange());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }

}