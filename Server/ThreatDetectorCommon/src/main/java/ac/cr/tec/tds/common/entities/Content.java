
package ac.cr.tec.tds.common.entities;

import java.util.HashMap;
import java.util.Map;


/**
 * El contenido del mensaje
 * 
 */
public class Content {

    /**
     * Mail | HTTP Request| HTTP Request
     * 
     */
    private String messageType;
    /**
     * The Message Content Check Wiky
     * 
     */
    private String content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Content() {
    }

    /**
     * 
     * @param content
     * @param messageType
     */
    public Content(String messageType, String content) {
        super();
        this.messageType = messageType;
        this.content = content;
    }

    /**
     * Mail | HTTP Request| HTTP Request
     * 
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Mail | HTTP Request| HTTP Request
     * 
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * The Message Content Check Wiky
     * 
     */
    public String getContent() {
        return content;
    }

    /**
     * The Message Content Check Wiky
     * 
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Content{" +
                "messageType='" + messageType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
