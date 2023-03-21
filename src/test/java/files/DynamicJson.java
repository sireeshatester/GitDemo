package files;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;

public class DynamicJson {

	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		given().header("Content-Type","application/json")
		.body(payload.Addbook())
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
	}
}
