package feature.review;

import com.friendtrest.rest.PattersonLogin;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static org.junit.Assert.*;

public class CreateAccountSteps extends JerseyTest {
    Response response;

    @Override
    protected Application configure() {
        return new ResourceConfig(PattersonLogin.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @When("^I request to create an account with (.*)$")
    public void i_request_to_create_an_account_with_NewUser(String username) throws Throwable {
        WebTarget target = target("createAccount").queryParam("username", username).queryParam("password", "123");
        response = target.request().get();
    }

    @Then("^I will recieve the message Hello (.*). Account created successfully!$")
    public void i_will_recieve_the_message_Hello_NewUser_Account_created_successfully(String user) throws Throwable {
        String res = "Welcome " + user + ". Account created successfully!";
        assertTrue(res.equals(response.readEntity(String.class)));
    }

}