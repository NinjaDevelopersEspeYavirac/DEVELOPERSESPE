/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexes;

/**
 *
 * @author luis
 */
@Entity(value = "users")
@Indexes({
    @Index(fields = @Field("codigo"), options = @IndexOptions(unique = true)),
    @Index(fields = @Field("flag"))})
public class User extends BaseEntity {

    private String codigo;

    @Embedded
    private Local local;

    @Embedded
    private Facebook facebook;

    @Embedded
    private Twitter twitter;

    @Embedded
    private Google google;

    private Boolean admin;
    
    private Integer flag;

    public User() {
        this.local = new Local();
        this.facebook = new Facebook();
        this.twitter = new Twitter();
        this.google = new Google();
        this.admin = Boolean.FALSE;
        this.flag = 0;
       
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
