package test_scripts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StoreTest {

    @Test
    void theJsonTest() {

       Response response =  given()
                .when()
                .get("http://localhost:9090/store");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("content-type"), "application/json; charset=utf-8");

       String bookName = response.jsonPath().get("books[0].title").toString();

       Assert.assertEquals(bookName, "The lovers");

    }

    @Test
    void theJsonTest2() {

        Response response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:9090/store");

        JSONObject jsonObject = new JSONObject(response.asString());
        boolean status = false;
        for (int i=0; i<jsonObject.getJSONArray("books").length(); i++){
            String bookTitle = jsonObject.getJSONArray("books").getJSONObject(i).get("title").toString();
            if(bookTitle.equals("Do you like the rain?")){

                System.out.println(bookTitle);
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
    }

    @Test
    void theJsonTest3() {

        Response response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:9090/store");

        JSONObject jsonObject = new JSONObject(response.asString());
        boolean status = false;
        double totalPrice = 0;
        for (int i=0; i<jsonObject.getJSONArray("books").length(); i++){
            String price = jsonObject.getJSONArray("books").getJSONObject(i).get("price").toString();
           totalPrice = totalPrice + Double.parseDouble(price);
            }
    System.out.println("total price of books is : " + totalPrice);
        Assert.assertEquals(totalPrice, 244);
    }
}
