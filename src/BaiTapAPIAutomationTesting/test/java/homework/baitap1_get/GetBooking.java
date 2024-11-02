package homework.baitap1_get;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBooking {
    @Test
    public void getBookingById() {
        //Given
        RequestSpecification request = given();
        request.baseUri("https://restful-booker.herokuapp.com")
                .accept("application/json");

        //When: GET method
        String id = "1";
        Response response = request.when().get("/booking/" + id);
        response.prettyPrint();

        //Verify response
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is not returned");
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("firstname"), "Jim", "Firstname difference from expected");
        Assert.assertEquals(jsonPath.get("lastname"), "Jackson", "Lastname difference from expected");
        Assert.assertEquals(jsonPath.get("totalprice").toString(), "350", "Total price difference from expected");
        Assert.assertTrue(jsonPath.get("depositpaid"), "Depositpaid is not true");
        Assert.assertEquals(jsonPath.get("bookingdates.checkin").toString(), "2020-07-09", "Checkin date is not true");
        Assert.assertEquals(jsonPath.get("bookingdates.checkout").toString(), "2023-05-25", "Checkout date is not true");
        Assert.assertEquals(jsonPath.get("additionalneeds"), "Breakfast", "Additional needs is wrong");
    }

    @Test
    public void getAllBooking(){
        //Given
        RequestSpecification request = given();
        request.baseUri("https://restful-booker.herokuapp.com");

        //When: GET method
        Response response = request.when().get("/booking/");
        response.prettyPrint();

        //Verify response
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is not returned");
        JsonPath jsonPath = response.jsonPath();
        //List<Integer> bookingid = jsonPath.getList("bookingid");
        Assert.assertTrue(response.jsonPath().getList("bookingid").contains(500000), "Booking ID is not listed here");
    }
}
