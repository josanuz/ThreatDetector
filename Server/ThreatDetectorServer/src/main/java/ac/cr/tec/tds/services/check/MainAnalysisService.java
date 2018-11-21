package ac.cr.tec.tds.services.check;

import ac.cr.tec.tds.common.Util;
import ac.cr.tec.tds.common.Util.KeyValue;
import ac.cr.tec.tds.common.Util.Tuple;
import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.common.entities.VerdictResult;
import ac.cr.tec.tds.repositories.AttackerRepository;
import ac.cr.tec.tds.repositories.ThreatRepository;
import ac.cr.tec.tds.repositories.VerdictResultRepository;
import ac.cr.tec.tds.rules.ClearThreatRule;
import ac.cr.tec.tds.rules.OriginIpRule;
import ac.cr.tec.tds.rules.Rule;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ac.cr.tec.tds.rules.ClearThreatRule.clearThreatRule;

@Service
public class MainAnalysisService implements InitializingBean {

    @Autowired
    VerdictResultRepository resultRepository;
    @Autowired
    AttackerRepository attackerRepository;
    @Autowired
    ThreatRepository threatRepository;

    List<Rule> ruleList = new ArrayList<>();

    private static KeyValue<Rule, Verdict> allGood = KeyValue.from(clearThreatRule, Verdict.CLEAR);

    public MainAnalysisService() {
    }


    public Verdict analyseThreat(final Threat threat) {
        KeyValue<Rule, Verdict> ruleVerdictFinalJudge = ruleList.stream()
                .map(rule -> KeyValue.from(rule, rule.judge(threat)))
                .filter(keyValue -> keyValue.value != Verdict.CLEAR)
                .findFirst()
                .orElse(allGood);

        ruleVerdictFinalJudge.consume((rule, verdict) -> resultRepository.add(new VerdictResult(rule.getClass().getName(),verdict)));

        return ruleVerdictFinalJudge.value;
    }

    @Override
    public void afterPropertiesSet() {
        ruleList.add(new OriginIpRule(attackerRepository));
    }
}
