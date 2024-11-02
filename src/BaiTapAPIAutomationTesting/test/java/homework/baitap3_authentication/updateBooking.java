package homework.baitap3_authentication;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.pojo.BookingDate;
import model.pojo.BookingPOJO;
import model.pojo.LoginPOJO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;


public class updateBooking {
    private String TOKEN;

    @BeforeMethod
    public void loginBooking() {
        //Khởi tạo giá trị với POJO class
        LoginPOJO login = new LoginPOJO("admin", "password123");

        //Thư viện gson chuyển class POJO
        Gson gson = new Gson();

        //Given
        RequestSpecification request = given();
        request.baseUri("https://restful-booker.herokuapp.com/")
                .contentType("application/json")
                .accept("application/json")
                .body(gson.toJson(login));

        //When
        Response response = request.when().post("/auth");
        response.prettyPrint();

        //Verify
        response.then().statusCode(200);

        //Save token
        TOKEN = response.getBody().path("token");
        System.out.println(TOKEN);
    }

    @Test
    public void editBooking() {
        // Data
        BookingPOJO bookingPOJO = new BookingPOJO();
        BookingDate bookingDate = new BookingDate();
        bookingPOJO.setFirstname("khanhlam1");
        bookingPOJO.setLastname("nguyen");
        bookingPOJO.setTotalprice(300);
        bookingPOJO.setDepositpaid(false);
        bookingPOJO.setAdditionalneeds("Change information");

        bookingDate.setCheckin("2024-10-18");
        bookingDate.setCheckout("2024-10-19");
        bookingPOJO.setBookingdates(bookingDate);

        Gson gson = new Gson();
        //System.out.println(gson.toJson(bookingPOJO)); //In Json

        // Given
        RequestSpecification request = given();
        request.baseUri("https://restful-booker.herokuapp.com/")
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token=" + TOKEN)
                .body(gson.toJson(bookingPOJO));

        // When
        Response response = request.when().put("/booking/2");
        response.prettyPrint(); // In nội dung phản hồi

        // Verify
        response.then().statusCode(200);
//        String message = response.getBody().path("message");
//        Assert.assertEquals(message, "Success", "The message not match.");

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("booking.firstname"), "khanhlam1", "Your First name is not true"); // Đã sửa
        Assert.assertEquals(jsonPath.get("booking.lastname"), "nguyen", "Your Last name is not true");
        Assert.assertEquals(jsonPath.get("booking.totalprice").toString(), "300", "Your Total price is not true");
        Assert.assertFalse(jsonPath.get("booking.depositpaid"), "Deposit paid is not true");
        Assert.assertEquals(jsonPath.get("booking.bookingdates.checkin"), "2024-10-18", "Check in date is not true");
        Assert.assertEquals(jsonPath.get("booking.bookingdates.checkout"), "2024-10-19", "Check out date is not true");
        Assert.assertEquals(jsonPath.get("booking.additionalneeds"), "Change information", "Additional needs is not true");
    }
}
