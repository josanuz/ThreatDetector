package ac.cr.tec.tds.services.check;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.common.entities.VerdictResult;
import ac.cr.tec.tds.repositories.AttackerRepository;
import ac.cr.tec.tds.repositories.VerdictResultRepository;
import ac.cr.tec.tds.rules.OriginIpRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpRuleCheckService implements CheckService{

    private OriginIpRule originIpRule;

    @Autowired
    VerdictResultRepository resultRepository;

    @Autowired
    public IpRuleCheckService(AttackerRepository repository) {
        this.originIpRule = new OriginIpRule(repository);
    }

    @Override
    public Verdict check(Threat threat) {
        Verdict result = originIpRule.judge(threat);
        VerdictResult verdictResult = new VerdictResult(this.getClass().getName(), result.getResolution().name(), result.getResolution().ordinal());
        resultRepository.add(verdictResult);
        return result;
    }
}
