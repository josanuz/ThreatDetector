package ac.cr.tec.tds.common.CouchDb.Entities;

import org.ektorp.support.CouchDbDocument;

public class Thread extends CouchDbDocument{

    /* ------------------------------ Document Keys ----------------- */
    private String $schema;
    private String title;
    private String description;



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

    private String type;



    @Override
    public String toString() {
        return "id: "+this.getId() + " " +
                "title: " + this.title
                ;
    }
}