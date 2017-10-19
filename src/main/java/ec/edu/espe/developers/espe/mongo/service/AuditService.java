/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.developers.espe.mongo.service;

import ec.edu.espe.developers.espe.mongo.model.Audit;
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


public class AuditService implements Serializable{
    
    private static final long serialVersionUID = 170646726473538026L;
    
    private MongoPersistence conn = new MongoPersistence();
    
    private Datastore ds = conn.context();
    
    public Boolean insert(Audit audit) {
        Boolean exito = Boolean.FALSE;
        Audit axu = this.findByCodigo(audit);
        if (axu.getId() == null) {
            audit.setCodigoAudit(this.obtenerCodigo());
            audit.setFlag(1);
            this.ds.save(audit);
            exito = Boolean.TRUE;
        }
        return exito;
    }
       private Integer obtenerCodigo() {
        List<Audit> audits = this.ds.find(Audit.class).asList();
        if (audits == null) {
            audits = new ArrayList<>();
        }
        Integer size = audits.size();
        Integer number = 1000 + 1 * size;
        return number;
    }

    public Audit findByCodigo(Audit audit) {
        Audit find = new Audit();
        Query<Audit> result = this.ds.find(Audit.class).
                field("codigo").equal(audit.getCodigoAudit()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public Audit findByCodigo(Integer audit) {
        Audit find = new Audit();
        Query<Audit> result = this.ds.find(Audit.class).
                field("codigo").equal(audit).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }
    public Audit findById(Audit audit) {
        Audit find = new Audit();
        Query<Audit> result = this.ds.find(Audit.class).
                field("id").equal(audit.getId()).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }

    public Audit findById(Integer audit) {
        Audit find = new Audit();
        Query<Audit> result = this.ds.find(Audit.class).
                field("id").equal(audit).
                field("flag").equal(1);
        if (result.asList() != null && !result.asList().isEmpty()) {
            find = result.asList().get(0);
        }
        return find;
    }


    public Boolean deteleFlag(Audit audit) {
        Query<Audit> query = this.ds.createQuery(Audit.class);
        audit.setFlag(0);
        query.and(
                query.criteria("codigo").equal(audit.getCodigoAudit())
        );
        UpdateOperations<Audit> update = this.ds.createUpdateOperations(Audit.class);
        update.set("flag", audit.getFlag());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }
    
    public Boolean update(Audit audit) {
        Query<Audit> query = this.ds.createQuery(Audit.class);
        query.and(
                query.criteria("codigo").equal(audit.getCodigoAudit())
        );
        UpdateOperations<Audit> update = this.ds.createUpdateOperations(Audit.class);
        update.set("Token", audit.getToken()).
                set("Date", audit.getDate()).
                set("Search", audit.getSearch()).
                set("Ip", audit.getIp()).
                set("Flag", audit.getFlag()).
                set("last_change", audit.getLastChange());
        UpdateResults results = this.ds.update(query, update);
        return results.getUpdatedExisting();
    }
}