package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBaseUrl {
    protected RequestSpecification spec;
    //protected yapiyoruz ki inheritance ile extend edebilelim

    @Before
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
