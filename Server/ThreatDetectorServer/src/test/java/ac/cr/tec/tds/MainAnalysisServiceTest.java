package ac.cr.tec.tds;

import ac.cr.tec.tds.common.entities.Attacker;
import ac.cr.tec.tds.common.entities.Content;
import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.repositories.AttackerRepository;
import ac.cr.tec.tds.services.check.MainAnalysisService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class MainAnalysisServiceTest {

    @Autowired
    MainAnalysisService mainAnalysisService;

    @Autowired
    AttackerRepository attackerRepository;

    @Before
    public void init(){
        attackerRepository.add(new Attacker("10.10.10.1","1010101","1010101@attacker.com"));
    }

    @After
    public void cleanUp(){
        attackerRepository.deleteAll();
    }

    @Test
    public void testClearVerdict() {
        Threat t = new Threat("127.0.0.10", "127.0.0.11", Collections.emptyList(), "HTTP", 0, new Content(Threat.MESSAGE_TYPE_HTTP, ""));
        Verdict verdict = mainAnalysisService.analyseThreat(t);
        Assert.assertSame("Verdict should be CLEAR", verdict, Verdict.CLEAR);
    }

    @Test
    public void testKnowAttackerIpVerdictDangerous() {
        Threat t = new Threat("10.10.10.1", "127.0.0.11", Collections.emptyList(), "HTTP", 0, new Content(Threat.MESSAGE_TYPE_HTTP, ""));
        Verdict verdict = mainAnalysisService.analyseThreat(t);
        Assert.assertSame("Verdict should be Dangerous", verdict, Verdict.DANGEROUS);
    }

    @Test
    public void testKnowAttackerMailAddressVerdictDangerous() {
        String [] mailContents = new String[5];
        mailContents[0] = "1010101@attacker.com";
        mailContents[1] = "person@mail.com";
        mailContents[2] = "cc@mail.com";
        mailContents[3] = "Nigerian Prince Wants to Give you $1.000.000";
        mailContents[4] = "The Nigerian prince wants you to have money, send him your credit card number and pin";
        Content content = new Content(Threat.MESSAGE_TYPE_MAIL, String.join("\n", mailContents));
        int size = (Threat.MESSAGE_TYPE_MAIL.length() + content.getContent().length()) * 8;
        Threat t = new Threat("10.10.10.1", "127.0.0.11", Collections.emptyList(), "HTTP", size, content);
        Verdict verdict = mainAnalysisService.analyseThreat(t);
        Assert.assertSame("Verdict should be Dangerous", verdict, Verdict.DANGEROUS);
    }

    @Test
    public void testSqlInjectionVerdictDangerous() {
        String content = "SELECT * FROM MY_TABLE;";
        Threat t = new Threat("127.0.0.15", "127.0.0.11", Collections.emptyList(), "HTTP", 0, new Content(Threat.MESSAGE_TYPE_PLAIN, content));
        Verdict verdict = mainAnalysisService.analyseThreat(t);
        Assert.assertSame("Verdict should be Dangerous", verdict, Verdict.DANGEROUS);
    }

    @Test
    @Ignore
    public void dummy(){
        String x = "SELECT * FROM TABLE;";
        String replaceAll = x.replaceAll("(\\w+);(\\w+)", "$1; $2");
        Assert.assertNotNull(replaceAll);
    }
}
