/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.service;

import ec.edu.espe.developers.espe.mongo.model.App;
import ec.edu.espe.developers.espe.mongo.model.User;
import ec.edu.espe.developers.espe.mongo.util.MongoPersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
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
        if (app == null) {
            app.setCodigo("APP" + this.count() + RandomStringUtils.randomAlphabetic(6).toUpperCase());
            app.setFlag(1);
            this.ds.save(app);
            exito = Boolean.TRUE;
        }
        return exito;
    }

    private Integer count() {
        Integer count = 0;
        Long result = this.ds.find(App.class).count();
        count = new Integer(result.intValue());
        return count + 1 * 10;
    }

    public App findByCodigo(App app) {
        App find = new App();
        Query<App> result = this.ds.find(App.class).
                field("codigo").equal(app.getCodigo()).
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
                query.criteria("codigo").equal(app.getCodigo())
        );
        UpdateOperations<App> update = this.ds.createUpdateOperations(App.class);
        update.set("flag", app.getFlag());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }

    public Boolean update(App app) {
        Query<App> query = this.ds.createQuery(App.class);
        query.and(
                query.criteria("codigo").equal(app.getCodigo())
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
