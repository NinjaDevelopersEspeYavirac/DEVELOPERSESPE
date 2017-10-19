/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author F.R.G
 */
@Entity(value = "Audit")
@Indexes({
    @Index(fields = @Field("codigoAudit")),
    @Index(fields = @Field("flag"))})
public class Audit extends BaseEntity {

    @Indexed(options = @IndexOptions(unique = true))
    private Integer codigoAudit;

    @Reference
    private App application;

    private String token;
    private Date date;
    private String search;
    private String ip;
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    
    

    public Audit() {
        this.application = new App();
    }

    public Integer getCodigoAudit() {
        return codigoAudit;
    }

    public void setCodigoAudit(Integer codigoAudit) {
        this.codigoAudit = codigoAudit;
    }

    public App getApplication() {
        return application;
    }

    public void setApplication(App application) {
        this.application = application;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
