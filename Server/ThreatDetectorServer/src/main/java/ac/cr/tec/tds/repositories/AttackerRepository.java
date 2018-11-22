package ac.cr.tec.tds.repositories;

import ac.cr.tec.tds.common.entities.Attacker;
import ac.cr.tec.tds.db.CouchDB;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.Filter;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@View(name = "all", map = "function (doc) { if(doc.type = 'Attacker') { emit(null, doc) } }")
public class AttackerRepository extends CouchDbRepositorySupport<Attacker> {

    private static final String DB_NAME = "attacker_db";

    @Autowired
    protected AttackerRepository(CouchDB db) {
        super(Attacker.class, db.getDbConnector(DB_NAME), true);
        this.initStandardDesignDocument();
    }

    @View(name = "kAttacker_Ip", map = "function (attacker) { if(attacker && attacker.ip) { emit(attacker._id, attacker.ip)} }")
    public List<String> allAttackersIps(){
        ViewResult r = db.queryView(createQuery("kAttacker_Ip"));
        return r.getRows().stream().map(ViewResult.Row::getValue).collect(Collectors.toList());
    }

    @View(name = "kAttacker_email", map = "function (attacker) { if(attacker && attacker.mailAddress) { emit(attacker._id, attacker.mailAddress)} }")
    public List<String> allAttackersEmail(){
        ViewResult r = db.queryView(createQuery("kAttacker_email"));
        return r.getRows().stream().map(ViewResult.Row::getValue).collect(Collectors.toList());
    }

    @GenerateView
    public List<Attacker> findByIp(String ip){
        return queryView("by_ip", ip);
    }

    @GenerateView
    public List<Attacker> findByMailAddress(String address) {
        return queryView("by_mailAddress", address);
    }

    public void deleteAll() {
        getAll().forEach(this::remove);
    }
}
