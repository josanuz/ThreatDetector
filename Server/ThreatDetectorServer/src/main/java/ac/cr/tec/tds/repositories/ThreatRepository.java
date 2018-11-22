package ac.cr.tec.tds.repositories;


import ac.cr.tec.tds.common.entities.couchDb.Threat;
import ac.cr.tec.tds.db.CouchDB;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreatRepository extends CouchDbRepositorySupport<Threat> {

    private static final String DB_NAME = "thread_db";

    @Autowired
    public ThreatRepository(CouchDB db){
        super(Threat.class, db.getDbConnector(DB_NAME), true);
        initStandardDesignDocument();
    }
}

