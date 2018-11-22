package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.repositories.AttackerRepository;

import java.util.List;

public class OriginIpRule implements Rule {

    private AttackerRepository attackerRepository;

    public OriginIpRule(AttackerRepository attackerRepository) {
        this.attackerRepository = attackerRepository;
    }

    @Override
    public Verdict judge(Threat threat) {
        RULE_LOGGER.info(OriginIpRule.class.getName() + " Analyzing Threat: " + threat);
        List<String> strings = attackerRepository.allAttackersIps();
        return strings.contains(threat.getOriginIp()) ? Verdict.DANGEROUS : Verdict.CLEAR;
    }
}
