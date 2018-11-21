package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;

public class ClearThreatRule implements Rule {

    public final static ClearThreatRule clearThreatRule = new ClearThreatRule();

    @Override
    public Verdict judge(Threat threat) {
        return Verdict.CLEAR;
    }
}
