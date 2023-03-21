package Demoauth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import Pojo.LoginRequest;
import Pojo.LoginResponse;

public class EcommerceAPITest {
	public static void main(String[] args) {
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON).build();
		
		LoginRequest loginrequest=new LoginRequest();
		loginrequest.setUserEmail("sireesha.mocharla@gmail.com");
		loginrequest.setUserPassword("Sireesha@1023");
		
		RequestSpecification reqlogin=given().log().all().spec(req).body(loginrequest);
		LoginResponse loginResponse=reqlogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUserId());
	}
	
	

}
