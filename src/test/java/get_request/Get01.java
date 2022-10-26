package get_request;

import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //RestAssured Library'si

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullaniyoruz.
    2) Otomasyon testleri icinde Rest Assured Library kullanacagiz.
    3) Otomasyon testlerimizi yaparken asagidaki adimlari takip ederiz
        a) Gereksinimleri anlamak.
        b) Test Case yaziyoruz.
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz.
            Bizler yazilim diline hakim olsakta, karsimizdaki kisiler
            hakim olmayabilir ama Gherkin ile yazilan testleri anlamakta
            zorluk cekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;
            - Given : ön koşullar
            - When : Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete())
            - Then : Istek yaptiktan sonra (request gonderdikten sonra) dogrulama
            - And : Coklu islemlerde kullanacagiz. Yani Then den sonra Then olarak degil and olarak devam edecegiz.
       c) Test kodlarimizi yazmaya baslayacagiz
            i) Set the URL,
            ii) Set the expected data (beklenen data'nin olusturulmasi, Post, Put, Patch ile)
            iii) Type code to send request (talep gondermek icin kod yazimi)
            iv) Do assertion (dogrulama yap)
     */
    /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */
    @Test
    public void get01() {

        //i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        //ii) Set the expected data (beklenen data'nin olusturulmasi, Post, Put, Patch ile)
        //Bizden post, put, ya da patch istenmedigi icin bu case'de kullanmayacagiz.

        //iii) Type code to send request (talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        //iv) Do assertion (dogrulama yap)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");


        //Status code konsola yazdiralim
        System.out.println("Status code: " + response.getStatusCode());

        //Content type konsola yazdiralim
        System.out.println("Content type: " + response.contentType());

        //Statuc line konsola yazdiralim
        System.out.println("Status line: " + response.statusLine());

        //Header konsola yazdiralim
        System.out.println("Header: " + response.getHeader("Server"));  //server'in cowboy oldugunu getirecek bize

        //Headers kismini konsola yazdiralim
        System.out.println("Headers: " + response.getHeaders());

        //Time konsola yazdiralim
        System.out.println("Time: " + response.getTime());

    }

}
