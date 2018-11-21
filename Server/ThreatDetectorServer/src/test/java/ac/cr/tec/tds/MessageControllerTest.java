package ac.cr.tec.tds;

import ac.cr.tec.tds.common.entities.Content;
import ac.cr.tec.tds.common.entities.Header;
import ac.cr.tec.tds.common.entities.Threat;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class MessageControllerTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    @Ignore
    public void sendMessage(){
        List<Header> headers = Arrays.asList(
                new Header("Accept", "application/json"),
                new Header("Content Type", "application/json"),
                new Header("User Agent", "SpringTestJUnit/CURL"),
                new Header("Forwarder", "0.0.0.0"),
                new Header("Host", "Local Host")
        );
        Content content = new Content("HTTP Request", "GET /api/messages?url=SELECT%20*%20FROM%20USER%20WHERE%20TRUE%3B");
        Threat threat = new Threat("127.0.0.1","127.0.0.1", headers, "HTTP", 512,content);
        given().contentType("application/json")
                .body(threat)
                .post("/api/message/")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo("Success"));
    }
}
