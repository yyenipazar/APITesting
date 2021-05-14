package AlertAware.api.test;

import java.io.FileInputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SignIn {
	@Test(priority=1,enabled=true)
	public void loginAsAUserWithValidCredentials(){
		
		RestAssured.baseURI="https://devapi.alertaware.com";	
		
		
		Response request = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",
				ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", "yarslan$")
				.formParam("password", "password")
				.post("/api/login");
				System.out.println("Response is"+request);
				String responsestring=request.asString();
				System.out.println(responsestring);
				io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
				System.out.println("js is:"+js);
				String token=js.get("access_token");
				System.out.println("token is:"+token);
				//if we can get a token, it means login is possible with this credentials
				Assert.assertNotEquals(token, null);
	}
	@Test(priority=2,enabled=true)
	public void loginAsAUserWithInValidCredentials(){
		
		RestAssured.baseURI="https://devapi.alertaware.com";
		Response request = RestAssured.given()
		.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",
				ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", "yars")
				.formParam("password", "password")
				.post("/api/login");
				System.out.println("Response is"+request);
				String responsestring=request.asString();
				System.out.println(responsestring);
				io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
				System.out.println("js is:"+js);
				String token=js.get("access_token");
				System.out.println("token is:"+token);
				//if we can not get a token as null, it means login is not possible with this credentials
				Assert.assertEquals(token, null);
	}
	@Test(priority=3,enabled=true)
	public void logoutCurrentUser(){
		
			RestAssured.baseURI="https://devapi.alertaware.com";	
			RequestSpecification request =RestAssured.given().log().all();
			request.header("Access-Token","0e932758738ef09dc82a739e09aa71cbba36b52e583aef9be133b155c87740c7f4c8e003978a439af2c332e6a1a3d9487f740efa7b6a4aa0138a25c00e9393f1");
			
			
			Response response=request.post("/api/logout");
			System.out.println(response.prettyPrint());
			
			Assert.assertEquals(response.getStatusCode(),200);
				}
		
		
	
	@Test(priority=4,enabled=true)
	public void logoutInvalidUser(){
	
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","e932758738ef09dc82a739e09aa71cbba36b52e583aef9be133b155c87740c7f4c8e003978a439af2c332e6a1a3d9487f740efa7b6a4aa0138a25c00e9393f1");
		
		
		Response response=request.post("/api/logout");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),400);
		}
	@Test(priority=5,enabled=false)
	public void loginAsAUserWith2fa(){
		
		RestAssured.baseURI="https://devapi.alertaware.com";	
		
		
		Response request = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",
				ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", "yasemin")
				.formParam("password", "password")
				.formParam("code","599364")
				.post("/api/login");
				System.out.println("Response is"+request);
				String responsestring=request.asString();
				System.out.println(responsestring);
				io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
				System.out.println("js is:"+js);
				String token=js.get("access_token");
				System.out.println("token is:"+token);
				//if we can get a token, it means login is possible with this credentials
				Assert.assertNotEquals(token, null);
	}
	@Test(priority=6,enabled=false)
	public void get2fa(){
		RestAssured.baseURI="https://devapi.alertaware.com";
			RequestSpecification request =RestAssured.given().log().all();
		
			Response request1 = RestAssured.given()
				.get("/api/get-2fa");
			
			System.out.println("Response is"+request1);
			String responsestring=request1.asString();
			System.out.println(responsestring);
			io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
			System.out.println("js is:"+js);
			String code=js.get("code");
			System.out.println("code is:"+code);
			//if we can get a token, it means login is possible with this credentials
			Assert.assertNotEquals(code, null);
	}
	@Test(priority=7,enabled=false)
	public void verifyTwoFactorAuth(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		
		
		Response request = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",
				ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", "yasemin")
				.formParam("password", "password")
				.formParam("code","329434")
				.post("/api/verify-2fa");
				System.out.println("Response is"+request);
				String responsestring=request.asString();
				System.out.println(responsestring);
				io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
				System.out.println("js is:"+js);
				String token=js.get("access_token");
				System.out.println("Token is:"+token);
				//if we can get a token, it means login is possible with this credentials
				Assert.assertNotEquals(token, null);
	}
	@Test(priority=8,enabled=false)
	public void verifyTwoFactorAuthWithInvalidCredentials(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		
		
		Response request = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",
				ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("username", "yasemin")
				.formParam("password", "pass")
				.formParam("code","329434")
				.post("/api/verify-2fa");
				System.out.println("Response is"+request);
				String responsestring=request.asString();
				System.out.println(responsestring);
				io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responsestring);
				System.out.println("js is:"+js);
				String token=js.get("access_token");
				System.out.println("Token is:"+token);
				//if we can get a token, it means login is possible with this credentials
				Assert.assertEquals(token, null);
	}

		
}
	

	
	

	



