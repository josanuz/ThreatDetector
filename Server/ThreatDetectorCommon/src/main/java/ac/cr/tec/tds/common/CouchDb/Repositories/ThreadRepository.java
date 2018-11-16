package ac.cr.tec.tds.common.CouchDb.Repositories;


import ac.cr.tec.tds.common.CouchDb.Entities.Thread;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class ThreadRepository extends CouchDbRepositorySupport<Thread> {

    public ThreadRepository(CouchDbConnector db){
        super(Thread.class, db);
    }
}

