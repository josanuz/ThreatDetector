package ac.cr.tec.tds.common.CouchDb;


import io.github.cdimascio.dotenv.Dotenv;
import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;
/*import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CouchDB {


    protected HttpClient authenticatedHttpClient;

    protected CouchDbConnector dbConnector;


    public CouchDB(String dataBaseName) {
        // Load DotEnv CouchDB credentials
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("couchdb_host");
        String port = dotenv.get("couchdb_port");
        String user = dotenv.get("couchdb_user");
        String password = dotenv.get("couchdb_password");
        // Manage CouchDB url endpoint
        System.out.println("http://" + host + ":" + port);
        try {
            authenticatedHttpClient = new StdHttpClient.Builder()
                    .url("http://" + host + ":" + port)
                    .username(user)
                    .password(password)
                    .build();
            CouchDbInstance dbInstance = new StdCouchDbInstance(this.authenticatedHttpClient);
            this.dbConnector = dbInstance.createConnector(dataBaseName, false);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public HttpClient getAuthenticatedHttpClient() {
        return authenticatedHttpClient;
    }

    public CouchDbConnector getDbConnector() {
        return dbConnector;
    }
}
