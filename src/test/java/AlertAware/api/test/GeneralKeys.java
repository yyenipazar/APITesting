package AlertAware.api.test;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GeneralKeys {
	@Test(priority=1,enabled=false)
	public void returnsAllApiKeyEntries(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","1e2450e2fa8ef9607d487f145741ccc0b413770a9b0078a65946edf4782414e72b6b65069f7f19af32b63c7185bea9f04be1fd2234df0494a03e8355399fe5ce");
		
		Response response=request.get("/api/api-keys");
		System.out.println(response.asString());//to print all result in JSON
		System.out.println(response.prettyPrint());	//to print on the console appropriate format
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
		
		
	}
	@Test(priority=2,enabled=true)
	public void returnsAnApiKeyBasedOnASingleID(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","1e2450e2fa8ef9607d487f145741ccc0b413770a9b0078a65946edf4782414e72b6b65069f7f19af32b63c7185bea9f04be1fd2234df0494a03e8355399fe5ce");
		
		Response response=request.get("/api/api-keys/5");
		System.out.println(response.asString());//to print all result in JSON
		System.out.println(response.prettyPrint());	//to print on the console appropriate format
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}
	@Test(priority=3,enabled=false)
	public void deleteASpecificApiKeyEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","9dbb899cb8f8e2674dd275ca3ff8f432e754ea574c6ab4034fd0b77c6588f3a6266b415f3491e3c346a89f6e3bb5640a4de0893fab393b00e91dd22009717861");
		
		
		Response response=request.delete("/api/api-keys/16");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
			}
	@Test(priority=4,enabled=false)
	public void createANewApiKeyEntry(){
		
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("secret", "eeerythbhghjgarkllll")
			      .formParam("is_active", "t")
			     .header("Access-Token", "9dbb899cb8f8e2674dd275ca3ff8f432e754ea574c6ab4034fd0b77c6588f3a6266b415f3491e3c346a89f6e3bb5640a4de0893fab393b00e91dd22009717861").request();
	
		Response response=request.post("/api/api-keys");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
	
	}
	
	@Test(priority=5,enabled=false)
	public void updateASpecificApiKeyEntry(){
		
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("secret", "yasmine")
			      .formParam("is_active", "t")
			     .header("Access-Token", "1e2450e2fa8ef9607d487f145741ccc0b413770a9b0078a65946edf4782414e72b6b65069f7f19af32b63c7185bea9f04be1fd2234df0494a03e8355399fe5ce").request();
	
		Response response=request.put("/api/api-keys/16");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
	
	}
	@Test(priority=6,enabled=false)
	public void returnsAnDeletedApiKey(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","1e2450e2fa8ef9607d487f145741ccc0b413770a9b0078a65946edf4782414e72b6b65069f7f19af32b63c7185bea9f04be1fd2234df0494a03e8355399fe5ce");
		
		Response response=request.get("/api/api-keys/13");
		System.out.println(response.asString());//to print all result in JSON
		System.out.println(response.prettyPrint());	//to print on the console appropriate format
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		
		
	}
		
	
	}
	
	



