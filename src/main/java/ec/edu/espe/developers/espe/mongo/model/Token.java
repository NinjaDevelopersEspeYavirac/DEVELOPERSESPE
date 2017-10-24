/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.model;

import ec.edu.espe.developers.espe.mongo.model.entity.BaseEntity;
import java.util.Date;
import java.util.Objects;
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
@Entity(value = "tokens")
@Indexes({
    @Index(fields = @Field("codigo"), options = @IndexOptions(unique = true)),
    @Index(fields = @Field("flag"))})
public class Token extends BaseEntity {

    private String codigo;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.application);
        hash = 47 * hash + Objects.hashCode(this.hash);
        hash = 47 * hash + Objects.hashCode(this.date_in);
        hash = 47 * hash + Objects.hashCode(this.date_out);
        hash = 47 * hash + Objects.hashCode(this.forever);
        hash = 47 * hash + Objects.hashCode(this.flag);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.hash, other.hash)) {
            return false;
        }
        if (!Objects.equals(this.application, other.application)) {
            return false;
        }
        if (!Objects.equals(this.date_in, other.date_in)) {
            return false;
        }
        if (!Objects.equals(this.date_out, other.date_out)) {
            return false;
        }
        if (!Objects.equals(this.forever, other.forever)) {
            return false;
        }
        if (!Objects.equals(this.flag, other.flag)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Token{" + "codigo=" + codigo + ", application=" + application + ", hash=" + hash + ", date_in=" + date_in + ", date_out=" + date_out + ", forever=" + forever + ", flag=" + flag + '}';
    }

}
