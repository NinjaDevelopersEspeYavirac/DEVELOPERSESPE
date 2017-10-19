/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.service;

import ec.edu.espe.developers.espe.mongo.model.Token;
import ec.edu.espe.developers.espe.mongo.util.MongoPersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author nelly
 */
public class TokenService implements Serializable{
    
    private static final long serialVersionUID = 170646726473538026L;
    
    private MongoPersistence conn = new MongoPersistence();
    
    private Datastore ds = conn.context();
    
    public Boolean insert(Token token) {
        Boolean exito = Boolean.FALSE;
        Token axu = this.findByCodigo(token);
        if (axu.getId() == null) {
         //   token.setCodigo(this.obtenerCodigo());
            token.setFlag(1);
            this.ds.save(token);
            exito = Boolean.TRUE;
        }
        return exito;
    }
       private Integer obtenerCodigo() {
        List<Token> tokens = this.ds.find(Token.class).asList();
        if (tokens == null) {
            tokens = new ArrayList<>();
        }
        Integer size = tokens.size();
        Integer number = 1000 + 1 * size;
        return number;
    }

    public Token findByCodigo(Token token) {
        Token find = new Token();
        Query<Token> result = this.ds.find(Token.class).
                field("codigo").equal(token.getCodigo()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public Token findByCodigo(Integer token) {
        Token find = new Token();
        Query<Token> result = this.ds.find(Token.class).
                field("codigo").equal(token).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }
    public Token findById(Token token) {
        Token find = new Token();
        Query<Token> result = this.ds.find(Token.class).
                field("id").equal(token.getId()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public Token findById(Integer token) {
        Token find = new Token();
        Query<Token> result = this.ds.find(Token.class).
                field("id").equal(token).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }


    public Boolean deteleFlag(Token token) {
        Query<Token> query = this.ds.createQuery(Token.class);
        token.setFlag(0);
        query.and(
                query.criteria("codigo").equal(token.getCodigo())
        );
        UpdateOperations<Token> update = this.ds.createUpdateOperations(Token.class);
        update.set("flag", token.getFlag());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }
    
    public Boolean update(Token token) {
        Query<Token> query = this.ds.createQuery(Token.class);
        query.and(
                query.criteria("codigo").equal(token.getCodigo())
        );
        UpdateOperations<Token> update = this.ds.createUpdateOperations(Token.class);
        update.set("Hash", token.getHash()).
                set("Date_in", token.getDate_in()).
                set("Date_out", token.getDate_out()).
                set("Forever", token.getForever()).
                set("Flag", token.getFlag()).
                set("last_change", token.getLastChange());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }
}
