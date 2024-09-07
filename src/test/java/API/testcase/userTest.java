package API.testcase;

import API.endpoints.userEndPoints;
import API.payload.user;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userTest {
    Faker faker;
    user  userPayload;

    @BeforeClass
    public void generateTestData(){
       faker = new Faker();
       userPayload = new user();

       userPayload.setId(faker.idNumber().hashCode());
       userPayload.setUsername(faker.name().username());
       userPayload.setFirstName(faker.name().firstName());
       userPayload.setLastName(faker.name().lastName());
       userPayload.setEmail(faker.internet().safeEmailAddress());
       userPayload.setPassword(faker.internet().password(5,10));
       userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void test_CreateUser(){
      Response response = userEndPoints.createUser(userPayload);
      //log
      response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
1
    }

    @Test(priority = 2)
    public void test_getUser(){
       Response response = userEndPoints.getUser(this.userPayload.getUsername());
       response.then().log().all();

       Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void test_updateUser(){
     Response response =  userEndPoints.updateUser(this.userPayload.getFirstName(), userPayload);
     response.then().log().all();

     Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void test_deleteUser(){
     Response response =  userEndPoints.deleteUser(this.userPayload.getUsername());
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(), 200);
    }


}
