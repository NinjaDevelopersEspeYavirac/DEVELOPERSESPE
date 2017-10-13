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
 * @author luis
 */
@Entity(value = "Token")
@Indexes({
    @Index(fields = @Field("codigo")),
    @Index(fields = @Field("flag"))})
public class Token extends BaseEntity {

    @Indexed(options = @IndexOptions(unique = true))
    private Integer codigo;

    @Reference
    private App application;

    private String hash;
    private Date date_in;
    private Date date_out;
    private Boolean forever;
    private Integer flag;

    public Token() {
        this.forever = Boolean.FALSE;
        this.flag = 0;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public Boolean getForever() {
        return forever;
    }

    public void setForever(Boolean forever) {
        this.forever = forever;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public App getApplication() {
        return application;
    }

    public void setApplication(App application) {
        this.application = application;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
