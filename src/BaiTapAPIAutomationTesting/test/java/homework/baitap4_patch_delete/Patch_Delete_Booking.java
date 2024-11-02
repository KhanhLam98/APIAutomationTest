package homework.baitap4_patch_delete;

import com.google.gson.Gson;
import core.BaseTest;
import globals.ConfigGlobal;
import globals.ToKenGlobal;
import helpers.SystemHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.pojo.BookingPoJo_Lombok;
import model.pojo.PatchBooking_Lombok;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Patch_Delete_Booking extends BaseTest {
    @Test
    public void patchBooking(){
        //Prepare data
        PatchBooking_Lombok patchBooking = new PatchBooking_Lombok();
        patchBooking.setFirstname("Lime");
        patchBooking.setLastname("Nguyen");
        patchBooking.setAdditionalneeds("Patch method");

        Gson gson = new Gson();
        //Given
        RequestSpecification request = given();
        request.baseUri(ConfigGlobal.baseUri)
                .accept(ConfigGlobal.accept)
                .contentType(ConfigGlobal.contentType)
                .header("Cookie", "token=" + ToKenGlobal.TOKEN)
                .body(gson.toJson(patchBooking));

        //When
        Response response = request.when().patch("/booking/105");
        response.prettyPrint();

        //Then - Verify
        response.then().statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("firstname"), "Lime", "Your First name is not true");
        Assert.assertEquals(jsonPath.get("lastname"), "Nguyen", "Your Last name is not true");
        Assert.assertEquals(jsonPath.get("totalprice").toString(), "111", "Your Total price is not true");
        Assert.assertTrue(jsonPath.get("depositpaid"), "Deposit paid is not true");
        Assert.assertEquals(jsonPath.get("bookingdates.checkin"), "2018-01-01", "Check in date is not true");
        Assert.assertEquals(jsonPath.get("bookingdates.checkout"), "2019-01-01", "Check out date is not true");
        Assert.assertEquals(jsonPath.get("additionalneeds"), "Patch method", "Additional needs is not true");
    }

    @Test
    public void deleteBooking() {
        Gson gson = new Gson();
        //Given
        RequestSpecification request = given();
        request.baseUri(ConfigGlobal.baseUri)
                .accept(ConfigGlobal.accept)
                .contentType(ConfigGlobal.contentType)
                .header("Cookie", "token=" + ToKenGlobal.TOKEN);

        //When
        Response response = request.when().delete("/booking/19");
        response.prettyPrint();
        response.then().statusCode(201);

        //Verify
        String message = response.getBody().asString();
        Assert.assertEquals(message, "Created", "The message not match.");
        Response verifyResponse = request.when().get("/booking/19");
        Assert.assertEquals(verifyResponse.statusCode(),"404","Status code of Get method not true");
    }
}
