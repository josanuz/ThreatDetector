package ac.cr.tec.tds.dao;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.db.CouchDB;
import ac.cr.tec.tds.repositories.ThreatRepository;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ThreatDB extends CouchDB {


    public ThreatDB(String dbName){
        super(dbName);
    }


    /**
     * Get all elements from the current database
     *
     */
    public void getAllEmails(){
        ThreatRepository repo = new ThreatRepository(this.dbConnector);
        List<Threat> lal = repo.getAll();
        for (Threat email: lal){
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
