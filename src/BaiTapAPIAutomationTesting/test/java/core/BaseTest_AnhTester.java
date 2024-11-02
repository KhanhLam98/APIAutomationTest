package core;

import com.google.gson.Gson;
import globals.ConfigGlobal;
import globals.EndpointGlobal;
import globals.ToKenGlobal;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.dataBuilder.LoginBuilder;
import model.dataBuilder.LoginBuilder_AnhTester;
import model.pojo.LoginPoJo_Lombok;
import model.pojo.Login_Anhtester;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest_AnhTester {
    @BeforeTest
    public void loginAnhTester() {
        //Khởi tạo giá trị với POJO class
        Login_Anhtester login = LoginBuilder_AnhTester.getDataLogin();

        //Thư viện gson chuyển class POJO
        Gson gson = new Gson();

        //Given
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .contentType("application/json")
                .accept("application/json")
                .body(gson.toJson(login));

        //Response response = ApiKeyword.postNotAuth(EndPointGlobal.EP_LOGIN, gson.toJson(loginPOJO));

        //When
        Response response = request.when().post("/login");
        response.prettyPrint();

        //Verify
        response.then().statusCode(200);

        //Save token
        ToKenGlobal.TOKEN = response.getBody().path("token");
        System.out.println(ToKenGlobal.TOKEN);
    }
}
