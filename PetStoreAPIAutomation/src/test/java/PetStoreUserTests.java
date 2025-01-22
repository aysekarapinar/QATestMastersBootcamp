import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class PetStoreUserTests {

    @Test
    public void getUser(){

        userCreate();

        RestAssured
                .get("https://petstore.swagger.io/v2/user/ayseozlem");
    }

    @Test
    public void userCreate(){

        Map<String, Object> bodyPayload= new HashMap<>();
        bodyPayload.put("id", 216622);
        bodyPayload.put("username", "ayseozlem");
        bodyPayload.put("firstname", "Ayse");
        bodyPayload.put("lastname", "Karapinar");
        bodyPayload.put("email","ayseozlem.com");
        bodyPayload.put("password", "ayseozlem123");
        bodyPayload.put("phone","5555555555");
        bodyPayload.put("userStatus", 1);

        Map<String,String> header=new HashMap<>();
        header.put("Contect-Type", "application/json");
        header.put("accept", "application/json");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers(header)
                .body(bodyPayload)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);
    }

    @Test
    public void userUpdate(){

        Map<String, Object> bodyPayload= new HashMap<>();
        bodyPayload.put("id", 1201);
        bodyPayload.put("username", "covcov1201");
        bodyPayload.put("firstname", "Covcov");
        bodyPayload.put("lastname", "Karapinar");
        bodyPayload.put("email","covcov@mail.com");
        bodyPayload.put("password", "covcov123");
        bodyPayload.put("phone","5666666666");
        bodyPayload.put("userStatus", 1);

        Map<String,String> header=new HashMap<>();
        header.put("Contect-Type", "application/json");
        header.put("accept", "application/json");


        given()
                .contentType("application/json")
                .body(bodyPayload)
                .headers(header)
                .when()
                .put("https://petstore.swagger.io/v2/user/tester1234")
                .then()
                .statusCode(200);
    }

    @Test
    public void userDelete(){

        userCreate();

        RestAssured
                .delete("https://petstore.swagger.io/v2/user/ayseozlem")
                .then()
                .statusCode(200);
    }

    @Test
    public void userLogin(){

        Map<String,String> queryParamsValue=new HashMap<>();
        queryParamsValue.put("username", "covcov1201");
        queryParamsValue.put("password", "covcov123");

        RestAssured
                .given()
                .queryParams(queryParamsValue)
                .when()
                .get("https://petstore.swagger.io/v2/user/login")
                .then()
                .statusCode(200);
    }

    @Test
    public void userLogout(){
        RestAssured
                .get("https://petstore.swagger.io/v2/user/logout")
                .then()
                .statusCode(200);
    }
}
