package ac.cr.tec.tds.controller.rest;

import ac.cr.tec.tds.common.entities.Response;
import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.services.check.IpRuleCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    @Autowired
    IpRuleCheckService ipRuleCheckService;


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Response receiveMessage(@RequestBody Threat threat){
        System.out.println(threat.toString());
        return new Response(200, "Success");
    }

    @RequestMapping(value = "/lucky", method = RequestMethod.GET)
    public int getLuckyNumber(){
        return ipRuleCheckService.getLuckyNumber();
    }

}
