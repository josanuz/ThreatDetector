package ac.cr.tec.tds.common.entities.couchDb;

import org.codehaus.jackson.JsonNode;
import org.ektorp.support.CouchDbDocument;

import java.util.List;

public class Threat extends CouchDbDocument{

    /* ------------------------------ Document Keys ----------------- */
    private String $schema;
    private String title;
    private String description;
    private String type;
    private JsonNode properties;


    /* ------------------------------ Protocols ----------------- */

    static public String ProtocolHttp = "HTTP";
    static public String ProtocolPop3 = "POP3";
    static public String ProtocolImap = "IMAP";

    /* ------------------------------ Message Type ----------------- */

    static public String messageTypeMail = "Mail";
    static public String messageTypeHttpRequest = "HTTP Request";


    /* ------------------------------------------------------------ */

    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonNode getProperties() {
        return properties;
    }

    /* ------------------------- Properties Keys ----------------- */


    public JsonNode propertiesOriginIP(){
        return this.properties.findValue("originIp");
    }

    public JsonNode propertiesDestinationIP(){
        return this.properties.findValue("destinationIP");
    }

    public JsonNode propertiesHeaders(){
        return this.properties.findValue("headers");
    }


    public JsonNode propertiesProtocol(){
        return this.properties.findValue("protocol");
    }

    public JsonNode propertiesLength(){
        return this.properties.findValue("length");
    }

    public JsonNode propertiesContent(){
        return this.properties.findValue("content");
    }

    public JsonNode propertiesRequired(){
        return this.properties.findValue("required");

    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }





    @Override
    public String toString() {
        return "id: "+this.getId() + " " +
                "title: " + this.title
                ;
    }
}