/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public final class Local {
    
    private String id;
    private String name;
    private String password;

    private BasicDBObject DBObjectLocal= new BasicDBObject();
    
    public Local(String id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }


    public Local() {
        this.id = "";
        this.name = "";
        this.password = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.DBObjectLocal.put("Id", id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.DBObjectLocal.put("Name", name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.DBObjectLocal.put("Password", password);
    }
    
    public BasicDBObject getDBObjectLocal() {
        return DBObjectLocal;
    }

    public void setDBObjectLocal(BasicDBObject DBObjectLocal) {
        this.DBObjectLocal = DBObjectLocal;
    }
    
    public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.id= (String) b.get("Id");
        this.name = (String) b.get("Name");
        this.password = (String) b.get("Password");
    }
}
