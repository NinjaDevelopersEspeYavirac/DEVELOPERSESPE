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

public final class Twitter {

    private String id;
    private String token;
    private String email;
    private String displayname;
    private String username;
    
    private BasicDBObject DBObjectTwitter= new BasicDBObject();
    
    public Twitter() {
        this.id = "";
        this.token = "";
        this.email = "";
        this.displayname = "";
        this.username = "";
    }

    public Twitter(String id, String token, String email, String displayname, String username) {
        this.setId(id);
        this.setToken(token);
        this.setEmail(email);
        this.setDisplayname(displayname);
        this.setUsername(username);
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.DBObjectTwitter.put("Id", id);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.DBObjectTwitter.put("Token", token);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.DBObjectTwitter.put("Email", email);
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
        this.DBObjectTwitter.put("Displayname", displayname);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.DBObjectTwitter.put("Ussrname", username);
    }
    
    public BasicDBObject getDBObjectTwitter() {
        return DBObjectTwitter;
    }

    public void setDBObjectTwitter(BasicDBObject DBObjectTwitter) {
        this.DBObjectTwitter = DBObjectTwitter;
    }

     public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.id= (String) b.get("Id");
        this.token = (String) b.get("Token");
        this.email = (String) b.get("Email");
        this.displayname = (String) b.get("Displayname");
        this.username = (String) b.get("Username");
    }

}
