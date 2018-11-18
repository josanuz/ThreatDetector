package ac.cr.tec.tds.repositories;


import ac.cr.tec.tds.common.entities.Threat;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class ThreatRepository extends CouchDbRepositorySupport<Threat> {

    public ThreatRepository(CouchDbConnector db){
        super(Threat.class, db);
    }
}

