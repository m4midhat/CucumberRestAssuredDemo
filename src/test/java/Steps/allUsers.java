package Steps;

import Data.Response.Posts;
import Data.Response.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class allUsers {

    Response response;
    private String userBaseURI = "https://reqres.in/api/";
    private String usersRoute = "users/";

    private String postsBaseURI = "http://localhost:3000/";
    private String postsRoute = "posts";

    private JsonPath jsonResponse;

    @Given("user do nothing")
    public void userDoNothing() {
    }

    @When("User calls the posts API")
    public void userCallsPostsAPI() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(postsBaseURI + postsRoute);
        log.info("Getting : "+ postsBaseURI + postsRoute);
        jsonResponse = response.jsonPath();
    }

    @When("User calls the User API")
    public void userCallsUsersAPI() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(userBaseURI + usersRoute);
        log.info("Getting : "+ userBaseURI + usersRoute);
        jsonResponse = response.jsonPath();
    }

    @Then("response code is {int}")
    public void responseCodeIs(int statusCode) {
        log.info("Expected Status code :" + statusCode);
        response.then().assertThat().statusCode(statusCode);
    }

    @And("All users are returned")
    public void allUsersAreReturned() {
        Users[] user = response.jsonPath().getObject("data", Users[].class);

        log.info("Total User Count : "+user.length);

        for(int i=0;i<user.length;i++){
            log.info("User ID : "+user[i].getId());
            log.info("User First Name : "+user[i].getFirst_name());
            log.info("User Last Name : "+user[i].getLast_name());
            log.info("User Avatar : "+user[i].getAvatar());
        }

        Assert.assertTrue(user.length>0);
    }

    @And("All posts are returned")
    public void allPostsAreReturned() {
        Posts[] posts = response.jsonPath().getObject("", Posts[].class);
        for(int i=0;i< posts.length;i++){
            log.info(posts[i].getTitle());
        }
    }

    @When("User calls the User API with {string}")
    public void userCallsTheUserAPIWith(String userID) {
        String reqURl = userBaseURI+usersRoute+userID;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(reqURl);
    }

    @Then("User details are fetched {string}{string}{string}")
    public void userDetailsAreFetched(String userFirstName, String userLastName, String userEmailAddress) {
        response.body().print();
        log.info(response.body().path("data.id").toString());
        log.info(response.body().path("data.first_name"));
        log.info(response.body().path("data.last_name"));
        log.info(response.body().path("data.email"));
        log.info(response.body().path("data.avatar"));
        Assert.assertEquals(userFirstName, response.body().path("data.first_name"));
        Assert.assertEquals(userLastName, response.body().path("data.last_name"));
        Assert.assertEquals(userEmailAddress, response.body().path("data.email"));
    }


}
