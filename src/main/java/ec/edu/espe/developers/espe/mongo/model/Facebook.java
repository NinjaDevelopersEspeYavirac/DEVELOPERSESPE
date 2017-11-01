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

public final class Facebook {
    
    private String id;
    private String token;
    private String email;
    private String name;

    private BasicDBObject DBObjectFacebook= new BasicDBObject();

    public Facebook(String id, String token, String email, String name) {
        this.setId(id);
        this.setToken(token);
        this.setEmail(email);
        this.setName(name);
    }
    
    public Facebook() {
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
        this.DBObjectFacebook.put("Id", id);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.DBObjectFacebook.put("Token", token);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.DBObjectFacebook.put("Email", email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.DBObjectFacebook.put("Name", name);
    }
    
    public BasicDBObject getDBObjectFacebook() {
        return DBObjectFacebook;
    }

    public void setDBObjectFacebook(BasicDBObject DBObjectFacebook) {
        this.DBObjectFacebook = DBObjectFacebook;
    }

     public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.id= (String) b.get("Id");
        this.token = (String) b.get("Token");
        this.email = (String) b.get("Email");
        this.name = (String) b.get("Name");
    }

}
