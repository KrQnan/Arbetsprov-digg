package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.acme.dto.User;
import org.acme.entity.UserEntity;
import org.acme.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@QuarkusTest
public class UserControllerTest {

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.name = "John";
        testUser.email = "john@acme.com";
        testUser.address = "123 Main Street";
        testUser.telephone = "555-555-5555";
    }

    @Test
    void testCreateUser() {
        given()
                //Vi skickar in våran testperson för att skapa en ny användare
                .contentType(ContentType.JSON)
                .body(testUser)
                .when()
                //Postar testpersonen till våran endpoint
                .post("/digg/create")
                .then()
                //Vi förväntar oss statuskod 200
                .statusCode(200);

    }

    @Test
    void testGetAllUsers(){
        UserController userController = new UserController();
        List<UserEntity> users = userController.listUsers();
        assertTrue(users.size() >= 30);
        boolean minbool = users.stream().anyMatch(user -> user.name.contains("Maria"));
        assertTrue(minbool);
    }

    @Test
    void testUpdateUser() {
        given()
                //Vi väljer första personen i våran databas för att uppdatera med attributen från våran testperson
                .pathParam("id",100)
                .contentType(ContentType.JSON)
                .body(testUser)
        .when()
                .put("/digg/update/{id}")
        .then()
                //Vi förväntar oss statuskod 200 och att john ska finnas i våran databas
                .statusCode(200)
                .body(containsString("john"));
    }

    @Test
    void testDeleteUser() {
        given()
                //Vi väljer våran första person i databasen för att ta bort
                .pathParam("id",2)
        .when()
                .delete("/digg/delete/{id}")
        .then()
                //Vi förväntar oss att det går bra och att vi får tillbaka statuskod 204
                .statusCode(204);
    }
    @Test
    void testDeleteUserNoId() {
        given()
                //Vi väljer våran första person i databasen för att ta bort
                .pathParam("id",1000)
                .when()
                .delete("/digg/delete/{id}")
                .then()
                //Vi förväntar oss att det går bra och att vi får tillbaka statuskod 204
                .statusCode(404);
    }
}
