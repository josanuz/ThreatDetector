package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;

public interface Rule {

    Verdict judge(Threat threat);
}
