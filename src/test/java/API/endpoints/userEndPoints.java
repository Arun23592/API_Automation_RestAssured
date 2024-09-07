package API.endpoints;

import API.payload.user;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static API.endpoints.Routes.*;
import static io.restassured.RestAssured.given;

public class userEndPoints {

    public static Response createUser(user payload){
       Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)

                .when()
                .post(post_url);
                return response;
    }


    public static Response getUser(String userName){
        Response response = given()
                .accept(ContentType.JSON)

                .pathParam("username", userName)

                .when()
                .get(get_url);
        return response;
    }


    public static Response updateUser(String userName, user payload){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)

                .when()
                .put(put_url);
        return response;
    }

    public static Response deleteUser(String userName){
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("username", userName)

                .when()
                .delete(delete_url);
        return response;
    }
}
