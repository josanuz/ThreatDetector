package ac.cr.tec.tds.common.CouchDb.Repositories;


import ac.cr.tec.tds.common.CouchDb.Entities.Threat;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class ThreadRepository extends CouchDbRepositorySupport<Threat> {

    public ThreadRepository(CouchDbConnector db){
        super(Threat.class, db);
    }
}

