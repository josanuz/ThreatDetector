package ac.cr.tec.tds.common.entities;

import ac.cr.tec.tds.common.entities.couchDb.DatedCouchDBDocument;

public class Attacker extends DatedCouchDBDocument {

    private String ip;
    private String userName;
    private String mailAddress;

    public Attacker() {
    }

    public Attacker(String ip, String userName, String mailAddress) {
        this.ip = ip;
        this.userName = userName;
        this.mailAddress = mailAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "Attacker{" +
                "ip='" + ip + '\'' +
                ", userName='" + userName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }
}

