package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;

public interface Rule {

    Verdict judge(Threat threat);
}
