package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.repositories.AttackerRepository;

public class EmailAttackerAddress implements Rule {

    private AttackerRepository attackerRepository;

    public EmailAttackerAddress(AttackerRepository attackerRepository) {
        this.attackerRepository = attackerRepository;
    }

    @Override
    public Verdict judge(Threat threat) {
        RULE_LOGGER.info(EmailAttackerAddress.class.getName() + " Analyzing Threat: " + threat);
        if(threat.getContent().getMessageType().equals(Threat.MESSAGE_TYPE_MAIL)){
            String content = threat.getContent().getContent();///TODO change getContent().getContent()
            String[] split = content.split("\n");
            String sender = split[0];
            if(attackerRepository.findByMailAddress(sender).size() > 0)
                return Verdict.DANGEROUS;
        }
        return Verdict.CLEAR;
    }
}
