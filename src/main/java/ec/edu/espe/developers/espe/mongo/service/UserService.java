/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.service;

import ec.edu.espe.developers.espe.mongo.model.User;
import ec.edu.espe.developers.espe.mongo.util.MongoPersistence;
import java.io.Serializable;
import org.apache.commons.lang3.RandomStringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author NADIE
 */
public class UserService implements Serializable {

    private static final long serialVersionUID = 7359478675389151589L;

    private MongoPersistence conn = new MongoPersistence();
    private Datastore ds = conn.context();

    public Boolean insert(User user) {
        Boolean exito = Boolean.FALSE;
        User axu = this.findByCodigo(user);
        if (axu.getId() == null) {
            user.setCodigo("USER" + this.count() + RandomStringUtils.randomAlphabetic(6).toUpperCase());
            user.setFlag(1);
            this.ds.save(user);
            exito = Boolean.TRUE;
        }
        return exito;
    }

    private Integer count() {
        Integer count = 0;
        Long result = this.ds.find(User.class).count();
        count = new Integer(result.intValue());
        return count + 1 * 10;
    }

    public User findByCodigo(User user) {
        User find = new User();
        Query<User> result = this.ds.find(User.class).
                field("codigo").equal(user.getCodigo()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public User findByCodigo(String user) {
        User find = new User();
        Query<User> result = this.ds.find(User.class).
                field("codigo").equal(user).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public User findById(User user) {
        User find = new User();
        Query<User> result = this.ds.find(User.class).
                field("id").equal(user.getId()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public User findById(Integer user) {
        User find = new User();
        Query<User> result = this.ds.find(User.class).
                field("id").equal(user).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public Boolean deteleFlag(User user) {
        Query<User> query = this.ds.createQuery(User.class);
        user.setFlag(0);
        query.and(
                query.criteria("codigo").equal(user.getCodigo())
        );
        UpdateOperations<User> update = this.ds.createUpdateOperations(User.class);
        update.set("flag", user.getFlag());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }

    public Boolean update(User user) {
        Query<User> query = this.ds.createQuery(User.class);
        query.and(
                query.criteria("codigo").equal(user.getCodigo())
        );
        UpdateOperations<User> update = this.ds.createUpdateOperations(User.class);
        update.set("Facebook", user.getFacebook()).
                set("Twitter", user.getTwitter()).
                set("Google", user.getGoogle()).
                set("Admin", user.getAdmin()).
                set("flag", user.getFlag()).
                set("last_change", user.getLastChange());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }

}
