package ac.cr.tec.tds.common.CouchDb;

import ac.cr.tec.tds.common.CouchDb.Entities.Thread;
import ac.cr.tec.tds.common.CouchDb.Repositories.ThreadRepository;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class ThreadDB extends CouchDB {


    public ThreadDB(String dbName){
        super(dbName);
    }


    /**
     * Get all elements from the current database
     *
     */
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


    /**
     *  Use Json Array to insert data into the database
     *
     * @param jsonContent String Json Array
     */
    public void insertElements(String jsonContent){
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonItems = mapper.readTree(jsonContent);
            List<JsonNode> itemList = new ArrayList<JsonNode>();

            if (jsonItems.isArray())
                for (JsonNode item : jsonItems) {
                    //normalizeId(item);
                    itemList.add(item);
                }

            this.dbConnector.executeBulk(itemList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }





}
