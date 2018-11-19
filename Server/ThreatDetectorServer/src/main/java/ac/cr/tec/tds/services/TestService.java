package ac.cr.tec.tds.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestService {

    public int getLuckyNumber(){
        return new Random().nextInt();
    }
}
