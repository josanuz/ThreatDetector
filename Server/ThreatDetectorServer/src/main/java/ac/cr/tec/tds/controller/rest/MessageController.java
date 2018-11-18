package ac.cr.tec.tds.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/messages")
public class MessageController {

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public void receiveMessage(){

    }

}
