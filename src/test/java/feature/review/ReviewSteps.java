package feature.review;

import com.friendtrest.rest.Leids_MovieSearchService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static org.junit.Assert.*;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Created by Zac Leids on 9/26/2016.
 */
public class ReviewSteps extends JerseyTest{
    Response response;
    String movie;

    @Override
    protected Application configure() {
        return new ResourceConfig(Leids_MovieSearchService.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @When("^I request the reviews of (.*)$")
    public void i_request_the_reviews_of(String movie) throws Throwable {
        this.movie = movie;
        WebTarget webTarget = target("getNumReviews").queryParam("movie", movie);
        response = webTarget.request().get();
    }

    @Then("^the number of reviews should be (\\d+)$")
    public void the_number_of_reviews_should_be(int numReviews) throws Throwable {
        //Leids_MovieSearchService service = new Leids_MovieSearchService();
        System.out.println("\n The num od reviews for " + movie + " is " + numReviews + "\n");
        assertTrue(numReviews == response.readEntity(Integer.class));
    }




}
