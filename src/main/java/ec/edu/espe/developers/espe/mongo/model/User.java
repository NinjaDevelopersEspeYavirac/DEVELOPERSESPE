/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;



public final class User extends BaseEntity {

    private String codigo;
    private Boolean admin;
    private Integer flag;
    
    private BasicDBObject DBObjectUser= new BasicDBObject();

    public User(String codigo, Boolean admin, Integer flag) {
        this.setCodigo(codigo);
        this.setAdmin(admin);
        this.setFlag(flag);
    }

    public User() {
        this.admin = Boolean.FALSE;
        this.flag = 0;
       
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.DBObjectUser.put("Codigo", codigo);
    }
    
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
        this.DBObjectUser.put("Admin", admin);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
        this.DBObjectUser.put("Flag", flag);
    }
    
    public BasicDBObject getDBObjectUser() {
        return DBObjectUser;
    }

    public void setDBObjectUser(BasicDBObject DBObjectUser) {
        this.DBObjectUser = DBObjectUser;
    }

     public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.codigo= (String) b.get("Codigo");
        this.admin = (Boolean) b.get("Admin");
        this.flag = (Integer) b.get("Flag");
    }

}
