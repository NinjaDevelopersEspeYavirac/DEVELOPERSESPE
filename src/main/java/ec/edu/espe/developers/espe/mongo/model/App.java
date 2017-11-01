/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;

/**
 *
 * @author luis
 */
public final class App extends BaseEntity {

    private String codigo;
    private String name;
    private String description;
    private String client_id;
    private String client_secret;
    private Integer flag;
    
    private BasicDBObject DBObjectApp = new BasicDBObject();

    public App(String codigo, String name, String description, String client_id, String client_secret, Integer flag) {
        this.setCodigo(codigo);
        this.setName(name);
        this.setDescription(description);
        this.setClient_id(client_id);
        this.setClient_secret(client_secret);
        this.setFlag(flag);
    }
    
    public App() {
        this.flag = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.DBObjectApp.put("Codigo", codigo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.DBObjectApp.put("Name", name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.DBObjectApp.put("Description", description);
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
        this.DBObjectApp.put("Client_Id", client_id);
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
        this.DBObjectApp.put("Client_Secret", client_secret);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
        this.DBObjectApp.put("Flag", flag);
        
    }
    
     public BasicDBObject getDBObjectApp() {
        return DBObjectApp;
    }

    public void setDBObjectApp(BasicDBObject DBObjectApp) {
        this.DBObjectApp = DBObjectApp;
    }

    public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.codigo= (String) b.get("Codigo");
        this.name = (String) b.get("Name");
        this.description = (String) b.get("Description");
        this.client_id = (String) b.get("Client_Id");
        this.client_secret = (String) b.get("Client_secret");
        this.flag = (Integer) b.get("Flag");
    }
    
}
