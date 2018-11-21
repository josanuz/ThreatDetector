package ac.cr.tec.tds.common.entities;

public class Verdict{

    public enum RESOLUTION {
        THREAT, DANGEROUS, SUSPICIOUS, CLEAR
    }

    public static Verdict DANGEROUS = new Verdict(RESOLUTION.DANGEROUS);
    public static Verdict THREAT = new Verdict(RESOLUTION.THREAT);
    public static Verdict SUSPICIOUS = new Verdict(RESOLUTION.SUSPICIOUS);
    public static Verdict CLEAR = new Verdict(RESOLUTION.CLEAR);

    private RESOLUTION resolution;

    private Verdict(RESOLUTION resolution) {
        this.resolution = resolution;
    }

    public RESOLUTION getResolution() {
        return resolution;
    }

    public void setResolution(RESOLUTION resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Verdict))
            return false;
        Verdict o = (Verdict)obj;
        return o.resolution.equals(resolution);
    }
}
