package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import request.AuthUserRequest;
import request.RegistrationRequest;
import util.Browser;

import java.util.Random;

import static constants.DataConstants.*;
import static io.restassured.RestAssured.given;

public abstract class BaseTest {
    protected WebDriver driver;
    private ObjectMapper objectMapper;
    private String token;
    protected RegistrationRequest registrationRequest;

    @Before
    public void setUp() throws Exception {
        driver = Browser.getWebDriver();
        driver.manage().window().maximize();
        driver.get(LINK_FOR_MAIN_PAGE);
        objectMapper = new ObjectMapper();
        createUser();
    }

    private void createUser() throws Exception {
        Random random = new Random();
        String name = "TestUser";
        String password = "qwerty";
        String email = "testuser" + System.currentTimeMillis() + "@mail.ru";
        registrationRequest = new RegistrationRequest(email, password, name);

        RestAssured.baseURI = LINK_FOR_MAIN_PAGE;
        String json = objectMapper.writeValueAsString(registrationRequest);
        Response response = given()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(json)
                .post(API_AUTH_REGISTER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        token = response.jsonPath().getString(ACCESS_TOKEN);
    }

    @After
    public void tearDown() {
        if (token != null) {
            given()
                    .header(AUTHORIZATION, token)
                    .delete(API_AUTH_USER)
                    .then();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    protected void deleteSpecifiedUser(String email, String password) throws Exception {
        AuthUserRequest authUserRequest = new AuthUserRequest(email, password);
        String body = new ObjectMapper().writeValueAsString(authUserRequest);
        String token = given()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(body)
                .post(API_AUTH_LOGIN)
                .then()
                .statusCode(200)
                .extract().path(ACCESS_TOKEN);
        given()
                .header(AUTHORIZATION, token)
                .delete(API_AUTH_USER)
                .then();
    }
}