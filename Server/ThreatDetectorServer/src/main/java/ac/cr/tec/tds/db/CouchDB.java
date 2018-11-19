package ac.cr.tec.tds.db;


import ac.cr.tec.tds.CouchDBConfig;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;*/


@Component
public class CouchDB {


    private HttpClient authenticatedHttpClient;

    Map<String, CouchDbConnector> connectorMap = new HashMap<>();


    @Autowired
    public CouchDB(CouchDBConfig config) {
        // Load DotEnv CouchDB credentials
        // Manage CouchDB url endpoint

        System.out.println("http://" + config.getHost() + ":" + config.getPort());
        try {
            authenticatedHttpClient = new StdHttpClient.Builder()
                    .url("http://" + config.getHost() + ":" + config.getPort())
                    .username(config.getUser())
                    .password(config.getPassword())
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public HttpClient getAuthenticatedHttpClient() {
        return authenticatedHttpClient;
    }

    public CouchDbConnector getDbConnector(String dbName) {
        if(connectorMap.containsKey(dbName)){
            return connectorMap.get(dbName);
        }

        CouchDbInstance dbInstance = new StdCouchDbInstance(this.authenticatedHttpClient);
        CouchDbConnector connector = dbInstance.createConnector(dbName, false);
        connectorMap.put(dbName, connector);
        return connector;
    }

}
