/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author luis
 */
public final class Google {

    private String id;
    private String token;
    private String email;
    private String name;
    
    private BasicDBObject DBObjectGoogle= new BasicDBObject();
    
    public Google(String id, String token, String email, String name) {
        this.setId(id);
        this.setToken(token);
        this.setEmail(email);
        this.setName(name);
    }

    public Google() {
        this.id = "";
        this.token = "";
        this.email = "";
        this.name = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.DBObjectGoogle.put("Id", id);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.DBObjectGoogle.put("Token", token);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.DBObjectGoogle.put("Email", email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.DBObjectGoogle.put("Name", name);
    }
    
    public BasicDBObject getDBObjectGoogle() {
        return DBObjectGoogle;
    }

    public void setDBObjectGoogle(BasicDBObject DBObjectGoogle) {
        this.DBObjectGoogle = DBObjectGoogle;
    }

     public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.id= (String) b.get("Id");
        this.token = (String) b.get("Token");
        this.email = (String) b.get("Email");
        this.name = (String) b.get("Name");
    }


}
