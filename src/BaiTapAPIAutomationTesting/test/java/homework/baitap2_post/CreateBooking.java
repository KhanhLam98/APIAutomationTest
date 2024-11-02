package homework.baitap2_post;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;

import static io.restassured.RestAssured.given;


public class CreateBooking {
    @Test
    public void createBooking() {
        String firstname = "Lam";
        String lastname = "Nguyen";
        int totalprice = 118;
        Boolean depositpaid = true;
        LocalDate checkin = LocalDate.of(2024, 10, 13);
        LocalDate checkout = LocalDate.of(2024, 10, 14);
        String additionalneeds = "Breakfast";
        //Given
        RequestSpecification request = given();
        request.baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"firstname\" : \"" + firstname + "\",\n" +
                        "    \"lastname\" : \"" + lastname + "\",\n" +
                        "    \"totalprice\" : " + totalprice + ",\n" +
                        "    \"depositpaid\" : " + depositpaid + ",\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"" + checkin + "\",\n" +
                        "        \"checkout\" : \"" + checkout + "\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"" + additionalneeds + "\"\n" +
                        "}");

        //When: POST method
        Response response = request.when().post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().contentType(ContentType.JSON);

        //Verify response
        JsonPath jsonPath = response.jsonPath();
        Assert.assertNotNull(jsonPath.get("bookingid"),"Booking id is null");
        Assert.assertEquals(jsonPath.get("booking.firstname"),"Lam","Your First name is not true");
        Assert.assertEquals(jsonPath.get("booking.lastname"),"Nguyen","Your Last name is not true");
        Assert.assertEquals(jsonPath.get("booking.totalprice").toString(),"118","Your Total price is not true");
        Assert.assertTrue(jsonPath.get("booking.depositpaid"), "Depositpaid is not true");
        Assert.assertEquals(jsonPath.get("booking.bookingdates.checkin").toString(),"2024-10-13","Check in date is not true");
        Assert.assertEquals(jsonPath.get("booking.bookingdates.checkout").toString(),"2024-10-14","Check out date is not true");
        Assert.assertEquals(jsonPath.get("booking.additionalneeds"),"Breakfast","Additional needs is not true");
    }
}
