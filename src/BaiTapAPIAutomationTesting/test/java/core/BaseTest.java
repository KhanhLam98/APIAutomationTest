package core;

import com.google.gson.Gson;
import globals.ConfigGlobal;
import globals.EndpointGlobal;
import globals.ToKenGlobal;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.dataBuilder.LoginBuilder;
import model.pojo.LoginPoJo_Lombok;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {
    @BeforeTest
    public void loginBooking() {
        //Khởi tạo giá trị với POJO class
        LoginPoJo_Lombok login = LoginBuilder.getDataLogin();

        //Thư viện gson chuyển class POJO
        Gson gson = new Gson();

        //Given
        RequestSpecification request = given();
        request.baseUri(ConfigGlobal.baseUri)
                .contentType(ConfigGlobal.contentType)
                .accept(ConfigGlobal.accept)
                .body(gson.toJson(login));

        //Response response = ApiKeyword.postNotAuth(EndPointGlobal.EP_LOGIN, gson.toJson(loginPOJO));

        //When
        Response response = request.when().post(EndpointGlobal.login);
        response.prettyPrint();

        //Verify
        response.then().statusCode(200);

        //Save token
        ToKenGlobal.TOKEN = response.getBody().path("token");
        System.out.println(ToKenGlobal.TOKEN);
    }
}
