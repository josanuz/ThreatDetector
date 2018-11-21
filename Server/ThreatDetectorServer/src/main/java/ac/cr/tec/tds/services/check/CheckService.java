package ac.cr.tec.tds.services.check;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;

public interface CheckService {

    Verdict check(Threat t);

}
