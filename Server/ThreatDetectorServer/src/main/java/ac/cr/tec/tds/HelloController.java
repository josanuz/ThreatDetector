package ac.cr.tec.tds;

import ac.cr.tec.tds.dao.ThreatDB;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello() {

        return "Hello World!";
    }

    @RequestMapping( value = "/apitest", method = RequestMethod.GET)
    String hi() {
        ThreatDB couchDB = new ThreatDB("spam_det");
        couchDB.getAllEmails();
        return "<h1 style=\"color: blue;\"> Test for HTML  </h1>";
    }

    @RequestMapping(value = "/getString", method = RequestMethod.POST, produces = "application/json")
    String hi2(@RequestBody String data) {
        ThreatDB couchDB = new ThreatDB("spam_det");
        System.out.println(data);
        couchDB.insertElements(data);
        return "{\"hello\":\"lala\"}";
    }

    @Data
    static class Result {
        public Result(int left, int right, long answer) {
            this.left = left;
            this.right = right;
            this.answer = answer;
        }

        private final int left;
        private final int right;
        private final long answer;
    }

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("left", left)
                .addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }
}
