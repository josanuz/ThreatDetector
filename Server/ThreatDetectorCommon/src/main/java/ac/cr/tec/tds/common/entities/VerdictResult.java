package ac.cr.tec.tds.common.entities;

import ac.cr.tec.tds.common.entities.couchDb.DatedCouchDBDocument;

public class VerdictResult extends DatedCouchDBDocument {

    private String judge;
    private String resultString;
    private int resultInt;

    public VerdictResult(String judge, String resultString, int resultInt) {
        this.judge = judge;
        this.resultString = resultString;
        this.resultInt = resultInt;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public int getResultInt() {
        return resultInt;
    }

    public void setResultInt(int resultInt) {
        this.resultInt = resultInt;
    }
}
