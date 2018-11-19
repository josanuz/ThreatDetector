package ac.cr.tec.tds.dao;

import ac.cr.tec.tds.common.entities.couchDb.Threat;
import ac.cr.tec.tds.db.CouchDB;
import ac.cr.tec.tds.repositories.ThreatRepository;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.ektorp.CouchDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ThreatDAO{


    public ThreatDAO(){
        super();
    }

    @Autowired
    ThreatRepository repo;

    /**
     * Get all elements from the current database
     *
     */
    public void getAllEmails(){
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

            //this.dbConnector.executeBulk(itemList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }





}
