package ac.cr.tec.tds.common.entities.couchDb;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.ektorp.support.CouchDbDocument;

import java.util.Date;

@JsonSerialize(
        include = JsonSerialize.Inclusion.NON_NULL
)
public class DatedCouchDBDocument extends CouchDbDocument {

    private Date dateCreated;

    @JsonProperty("date_created")
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
