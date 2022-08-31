package StepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.specification.*;
import org.json.simple.*;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import java.io.FileReader;

public class StepDefinitions {
    private static final String BASE_URL = "https://gorest.co.in/public/v2/users";
    RequestSpecification request;
    private static Response response;
    static final String authToken = "cf7be3a98b552c398bb6c1234b7c08aa9fec4fe9e88d31c1718b3e5c948539f9";

    @Given("^I set POST new user")
    public void setPostNewUser() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + authToken);
        String createUserJson;
    }

    @And("I fill in {string} with {string}")
    public void changeRequest(String field, String value, String createUserJson) {
        if (createUserJson != null || createUserJson != "") {
            createUserJson = createUserJson + "\", ";
        }

        createUserJson = createUserJson + "\"" + field + "\":\"" + value;
    }

    @And("I fill in {string} with {int}")
    public void changeRequest(String field, int value, String createUserJson) {
        if (createUserJson != null || createUserJson != "") {
            createUserJson = createUserJson + "\", ";
        }

        createUserJson = createUserJson + "\"" + field + "\":\"" + value;
    }

    @When("^I create a new user")
    public void postNewUser(String createUserJson, Response response) {
        createUserJson = "{" + createUserJson + "}";
        response = (Response) request.body(createUserJson);
    }

    @Then("Status code equals {int}")
    public void checkStatusCodeValue(int expectedCode) {
        assertEquals(expectedCode, response.getStatusCode());
    }

    @Then("Response contains new user data")
    public void checkStatusCodeValue(String createUserJson, Response response) {
        assertTrue(response.contains(createUserJson.substring(1)));
    }
}
