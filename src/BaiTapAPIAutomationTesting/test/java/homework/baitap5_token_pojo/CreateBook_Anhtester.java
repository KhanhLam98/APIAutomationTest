package homework.baitap5_token_pojo;

import com.google.gson.Gson;
import core.BaseTest_AnhTester;
import globals.ToKenGlobal;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.pojo.CreateBookPOJO_AnhTester;
import model.pojo.CreateBook_Image;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class CreateBook_Anhtester extends BaseTest_AnhTester {
    @Test
    public void createBook() {
        //Prepate Data
        //CreateBook_Image bookImage = new CreateBook_Image();
        CreateBookPOJO_AnhTester createBook = new CreateBookPOJO_AnhTester();
        createBook.setName("Create booking");
        createBook.setCategory_id(1);
        createBook.setPrice(300000);
        createBook.setRelease_date("2024/10/26");
        //createBook.setImage_ids(1);
        createBook.setImage_ids(Collections.singletonList(1));
        createBook.setStatus(true);


        //createBook.setImage_ids(bookImage);

        //System.out.println(createBook.getName());

        Gson gson = new Gson();
        //Given
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + ToKenGlobal.TOKEN)
                .body(gson.toJson(createBook));

        //System.out.println(gson.toJson(createBook));

        //When
        Response response = request.when().post("/book");
        response.prettyPrint();

        //Then
        response.then().statusCode(200);
        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.get("response.name"),"Create booking","The name of book is not true");
        Assert.assertEquals(json.get("response.category_id").toString(),"1","The category id  is not true");
        Assert.assertEquals(json.get("response.price").toString(),"300000","The price is not true");
        Assert.assertEquals(json.get("response.release_date"),"2024/10/26","The release date is not true");
        //Assert.assertEquals(json.get("response.image_ids.id"),"Api Testing","The name of book is not true");
        //Assert.assertEquals(json.get("response.image_ids.path"),"Api Testing","The name of book is not true");
        Assert.assertTrue(json.get("response.status"),"The status is not true");

    }

}
