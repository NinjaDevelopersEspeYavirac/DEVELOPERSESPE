/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;
import java.util.Date;

/**
 *
 * @author F.R.G
 */

public final class Audit extends BaseEntity {

    private BasicDBObject DBObjectAudit= new BasicDBObject();
    
    private String codigo;
    private String token;
    private Date date;
    private String search;
    private String ip;
    private Integer flag;

    public Audit(String codigo, String token, Date date, String search, String ip, Integer flag) {
        this.setCodigo(codigo);
        this.setToken(token);
        this.setDate(date);
        this.setSearch(search);
        this.setIp(ip);
        this.setFlag(flag);
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.DBObjectAudit.put("Codigo", codigo);

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.DBObjectAudit.put("Token", token);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.DBObjectAudit.put("Date", date);
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        this.DBObjectAudit.put("Search", search);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
        this.DBObjectAudit.put("Ip", ip);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
        this.DBObjectAudit.put("Flag", flag);
    }
    
     public BasicDBObject getDBObjectAudit() {
        return DBObjectAudit;
    }

    public void setDBObjectAudit(BasicDBObject DBObjectAudit) {
        this.DBObjectAudit = DBObjectAudit;
    }
    
    public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.codigo= (String) b.get("Codigo");
        this.token = (String) b.get("Token");
        this.date = (Date) b.get("Date");
        this.search = (String) b.get("Search");
        this.ip = (String) b.get("Ip");
        this.flag = (Integer) b.get("Flag");
    }
   
}
