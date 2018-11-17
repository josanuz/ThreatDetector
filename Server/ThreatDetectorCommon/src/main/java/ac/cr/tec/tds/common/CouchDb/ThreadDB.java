package ac.cr.tec.tds.common.CouchDb;

import ac.cr.tec.tds.common.CouchDb.Entities.Thread;
import ac.cr.tec.tds.common.CouchDb.Repositories.ThreadRepository;
import org.codehaus.jackson.JsonNode;

import java.util.List;

public class ThreadDB extends CouchDB {


    public ThreadDB(String dbName){
        super(dbName);
    }

    public void getAllEmails(){
        ThreadRepository repo = new ThreadRepository(this.dbConnector);
        List<Thread> lal =repo.getAll();
        for (Thread email: lal){
            System.out.println(email);
            //System.out.println(email.getProperties());
            //System.out.println(email.propertiesContent());
            for (JsonNode node: email.propertiesRequired()){
                System.out.println(node);
            }
        }
    }

}