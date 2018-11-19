package ac.cr.tec.tds;

import ac.cr.tec.tds.common.entities.Attacker;
import ac.cr.tec.tds.repositories.AttackerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class AttackerRepositoryTest {

   @Autowired
    AttackerRepository attackerRepository;

   @Before
   public void init(){
       attackerRepository.getAll().forEach(a -> attackerRepository.remove(a));
       Arrays.asList(
               new Attacker("10.10.10.1", "1010101", "1010101@attacker.com"),
               new Attacker("10.10.10.2", "1010102", "1010102@attacker.com"),
               new Attacker("10.10.10.3", "1010103", "1010103@attacker.com"),
               new Attacker("10.10.10.4", "1010104", "1010104@attacker.com"),
               new Attacker("10.10.10.5", "1010105", "1010105@attacker.com"),
               new Attacker("10.10.10.6", "1010106", "1010106@attacker.com"),
               new Attacker("10.10.10.7", "1010107", "1010107@attacker.com"),
               new Attacker("10.10.10.8", "1010108", "1010108@attacker.com"),
               new Attacker("10.10.10.9", "1010109", "1010109@attacker.com"),
               new Attacker("10.10.10.10", "10101010", "10101010@attacker.com"),
               new Attacker("10.10.10.11", "10101011", "10101011@attacker.com"),
               new Attacker("10.10.10.12", "10101013", "10101012@attacker.com")
       ).forEach(attacker -> attackerRepository.add(attacker));

   }

   @Test
    public void testGetAll(){
       List<Attacker> byIp = attackerRepository.getAll();
       assert byIp.size() == 12;
   }
}
