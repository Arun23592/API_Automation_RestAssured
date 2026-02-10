package API.testcase;

import API.endpoints.userEndPoints;
import API.payload.user;
import API.utils.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;

public class UserTestDD {

    @Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
    public void testCreateUser(String UserID, String UserName, String fname, String lname, String email, String pwd, String phone){

        user  userPayload = new user();

//        userPayload.setId(Integer.parseInt(UserID));

        if (UserID != null && !UserID.isEmpty()) {
            try {
                userPayload.setId(Integer.parseInt(UserID));
            } catch (NumberFormatException e) {
                // Handle the case where UserID is not a valid integer
                // For example, set a default value or throw an exception
                userPayload.setId(0); // Setting a default value of 0
            }
        } else {
            // Handle the case where UserID is null or empty
            userPayload.setId(0); // Setting a default value of 0
        }


        userPayload.setUsername(UserName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(email);
        userPayload.setPassword(pwd);
        userPayload.setPhone(phone);

        Response response = userEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }



    @Test(priority = 3, dataProvider = "userNamesData", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String username){

        Response response = userEndPoints.deleteUser(username);
        System.out.println("Delete the user");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dataProvider = "userNamesData", dataProviderClass = DataProviders.class)
    public void testGetUser(String username){

        Response response = userEndPoints.getUser(username);
        System.out.println("Get the user");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

}

