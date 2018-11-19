package ac.cr.tec.tds.repositories;

import ac.cr.tec.tds.common.entities.Attacker;
import ac.cr.tec.tds.db.CouchDB;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttackerRepository extends CouchDbRepositorySupport<Attacker> {

    private static final String DB_NAME = "attacker_db";

    @Autowired
    protected AttackerRepository(CouchDB db) {
        super(Attacker.class, db.getDbConnector(DB_NAME), true);
    }

    @View(name = "attackers_ip", map = "function (attacker) { if(attacker.ip) {emit(attacker.ip)} }")
    public List<String> allAttackersIps(){
        ViewResult r = db.queryView(createQuery("attackers_ip"));
        return r.getRows().stream().map(ViewResult.Row::getValue).collect(Collectors.toList());
    }

    public List<Attacker> findByIp(String ip){
        return queryView("by_ip");
    }
}
