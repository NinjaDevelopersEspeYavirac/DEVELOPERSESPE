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
import java.util.Objects;


public final class Token extends BaseEntity {

    private String codigo;
    private String hash;
    private Date date_in;
    private Date date_out;
    private Boolean forever;
    private Integer flag;
    
    private BasicDBObject DBObjectToken= new BasicDBObject();

    public Token(String codigo, String hash, Date date_in, Date date_out, Boolean forever, Integer flag) {
        this.setCodigo(codigo);
        this.setHash(hash);
        this.setDate_in(date_in);
        this.setDate_out(date_out);
        this.setForever(forever);
        this.setFlag(flag);
    }

    public Token() {
        this.forever = Boolean.FALSE;
        this.flag = 0;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
        this.DBObjectToken.put("Hash", hash);
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
        this.DBObjectToken.put("Date_in", date_in);
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
        this.DBObjectToken.put("Date_out", date_out);
    }

    public Boolean getForever() {
        return forever;
    }

    public void setForever(Boolean forever) {
        this.forever = forever;
        this.DBObjectToken.put("Forever", forever);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.DBObjectToken.put("Codigo", codigo);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
        this.DBObjectToken.put("Flag", flag);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
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
    
    public BasicDBObject getDBObjectToken() {
        return DBObjectToken;
    }

    public void setDBObjectToken(BasicDBObject DBObjectToken) {
        this.DBObjectToken = DBObjectToken;
    }

     public void makePojofromBson(DBObject bson) {
        BasicDBObject b = (BasicDBObject) bson;
        this.codigo= (String) b.get("Codigo");
        this.hash = (String) b.get("Hash");
        this.date_in = (Date) b.get("Date_in");
        this.date_out = (Date) b.get("Date_out");
        this.forever = (Boolean) b.get("Forever");
        this.flag = (Integer) b.get("Flag");
    }
    @Override
    public String toString() {
        return "Token{" + "codigo=" + codigo + ", hash=" + hash + ", date_in=" + date_in + ", date_out=" + date_out + ", forever=" + forever + ", flag=" + flag + '}';
    }

}
