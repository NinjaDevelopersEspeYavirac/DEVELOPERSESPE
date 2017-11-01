/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author luis
 */
@Entity(value = "apps")
@Indexes({
    @Index(fields = @Field("codigo"), options = @IndexOptions(unique = true)),
    @Index(fields = @Field("flag"))})
public final class App extends BaseEntity {

    private String codigo;

    @Reference
    private User developer;

    private String name;
    private String description;
    private String client_id;
    private String client_secret;
    private Integer flag;
    
    private BasicDBObject DBObjectApp = new BasicDBObject();

    public App(String codigo, User developer, String name, String description, String client_id, String client_secret, Integer flag) {
        this.setCodigo(codigo);
        this.setDeveloper(developer);
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

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
        this.DBObjectApp.put("Developer", developer);
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
