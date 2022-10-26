package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonplaceholderBaseUrl {

    /*
      Given
          https://jsonplaceholder.typicode.com/todos/23

      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get01() {
        // set the URL
        spec.pathParams("first","todos","second",23);
        //pathParams kullanma sebebimiz bir den fazla url eklentisi olmasi /todos ve /23 ornegin bu url de
        //eger tek bir eklenti olsaydi o zaman pathParam kullanacaktik, yani /todos tan sonra baska bir sey olmasaydi mesela.

        // Set The Expected  Data (Put, Patch, Post)

        // Send the request and Get Response
        Response response = given().spec(spec).when().get("/{first}/{second}"); //first kismi urlmizdeki todos kismi, second kismi url mizdeki sayi kismi /todos/23 seklinde
        response.prettyPrint();


        //Not: eger soruda Then varsa assrtion yapiyoruz.
        //do assertion
        //1.YOL
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).body("completed", equalTo(false)).body("userId", equalTo(2));

        //2.YOL
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false), "userId", equalTo(2));

        /*
        Soft assert testi gerçekleştirir ve assert başarısız olursa hata fırlatma gerçekleştirmez.
        Hard assert anında hata fırlatır, sonrasında test işlemine devam eder
        */
    }


}
