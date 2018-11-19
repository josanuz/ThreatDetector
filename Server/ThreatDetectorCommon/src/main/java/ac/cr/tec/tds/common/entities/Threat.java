
package ac.cr.tec.tds.common.entities;

import org.ektorp.support.CouchDbDocument;

import java.util.*;


/**
 * Event
 * <p>
 * Events Generated by the clients
 * 
 */
public class Threat extends CouchDbDocument {

    /**
     * Packet Origin IP
     * 
     */
    private String originIp;
    /**
     * Packet Destination IP
     * 
     */
    private String destinationIP;
    private List<Header> headers = null;
    /**
     * HTTP | POP3 | IMAP
     * 
     */
    private String protocol;
    /**
     * Content Lenght
     * 
     */
    private Integer length;
    /**
     * El contenido del mensaje
     * 
     */
    private Content content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Threat() {
    }

    /**
     * 
     * @param content
     * @param headers
     * @param protocol
     * @param length
     * @param originIp
     * @param destinationIP
     */
    public Threat(String originIp, String destinationIP, List<Header> headers, String protocol, Integer length, Content content) {
        super();
        this.originIp = originIp;
        this.destinationIP = destinationIP;
        this.headers = headers;
        this.protocol = protocol;
        this.length = length;
        this.content = content;
    }

    /**
     * Packet Origin IP
     * 
     */
    public String getOriginIp() {
        return originIp;
    }

    /**
     * Packet Origin IP
     * 
     */
    public void setOriginIp(String originIp) {
        this.originIp = originIp;
    }

    /**
     * Packet Destination IP
     * 
     */
    public String getDestinationIP() {
        return destinationIP;
    }

    /**
     * Packet Destination IP
     * 
     */
    public void setDestinationIP(String destinationIP) {
        this.destinationIP = destinationIP;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    /**
     * HTTP | POP3 | IMAP
     * 
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * HTTP | POP3 | IMAP
     * 
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Content Lenght
     * 
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Content Lenght
     * 
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * El contenido del mensaje
     * 
     */
    public Content getContent() {
        return content;
    }

    /**
     * El contenido del mensaje
     * 
     */
    public void setContent(Content content) {
        this.content = content;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Threat{" +
                "originIp='" + originIp + '\'' +
                ", destinationIP='" + destinationIP + '\'' +
                ", headers=" + Arrays.toString(headers.toArray()) +
                ", protocol='" + protocol + '\'' +
                ", length=" + length +
                ", content=" + content.toString() +
                '}';
    }
}
