package testsAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.mail.iap.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APITests extends TestBase {
	
	
	@Test
	public static void validateRockRoundCity() {

		given()

				.when().get("\n" + 
						"https://api.interzoid.com/getweather?license=c8a473c13ed0e1a88cabda7d1668e520&city=Round%20Rock&state=TX")

				.then()
				.assertThat()
				.statusCode(200).body("Code", equalTo("Success"));
	}
	
	@Test
	public static void validateTampaCity() {

		given()

				.when().get("\n" + 
						"https://api.interzoid.com/getweather?license=c8a473c13ed0e1a88cabda7d1668e520&city=Tampa&state=TX")

				.then()
				.assertThat()
				.statusCode(400).body("Code", equalTo("City and state location not found"));
	}
	
	@Test
	public static void validateNullCity() {

		given()

				.when().get("\n" + 
						"https://api.interzoid.com/getweather?license=c8a473c13ed0e1a88cabda7d1668e520&city=&state=")

				.then()
				.assertThat()
				.statusCode(404).body("Code", equalTo("Insufficient parameters: city and state are required"));
	}


}
