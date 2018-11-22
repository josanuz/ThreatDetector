package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Rule {
    Logger RULE_LOGGER = LoggerFactory.getLogger(Rule.class.getName());
    Verdict judge(Threat threat);
}
