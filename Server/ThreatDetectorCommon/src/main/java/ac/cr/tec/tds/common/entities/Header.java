
package ac.cr.tec.tds.common.entities;

import java.util.HashMap;
import java.util.Map;

public class Header {

    private String headerName;
    private String headerValue;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Header() {
    }

    /**
     * 
     * @param headerValue
     * @param headerName
     */
    public Header(String headerName, String headerValue) {
        super();
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public String toString() {
        return "Header{" +
                "headerName='" + headerName + '\'' +
                ", headerValue='" + headerValue + '\'' +
                '}';
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
