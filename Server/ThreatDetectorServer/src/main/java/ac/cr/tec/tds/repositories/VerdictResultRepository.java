package ac.cr.tec.tds.repositories;

import ac.cr.tec.tds.common.entities.VerdictResult;
import ac.cr.tec.tds.db.CouchDB;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerdictResultRepository extends CouchDbRepositorySupport<VerdictResult> {

    public static final String DB_NAME = "verdict_db";

    @Autowired
    protected VerdictResultRepository(CouchDB db) {
        super(VerdictResult.class, db.getDbConnector(DB_NAME));
        initStandardDesignDocument();
    }
}
