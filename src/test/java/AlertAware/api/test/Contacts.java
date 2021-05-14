package AlertAware.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Contacts {
	@Test(priority=1,enabled=false)
	public void createANewContactEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("author_user_id", "")
			      .formParam("organization_user_id","")
			      .formParam("external_id", "")
			      .formParam("contact_id", "")
			      .formParam("title", "Alertus Group")
			      .formParam("first_name","Yasemin")
			      .formParam("last_name", "Arslan")
			      .formParam("phone", "2032345678")
			      .formParam("email", "yasemin@test.com")
			      .formParam("address_1","1111 Street")
			      .formParam("city", "Springfield")
			      .formParam("state", "VA")
			      .formParam("zip_code", "11111")
			      .formParam("country","US")
			      
			      .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	
		Response response=request.post("/api/contacts");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=2,enabled=false)
	public void returnAllContactEntries(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/contacts");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}
@Test(priority=3,enabled=false)
public void updateASpecificContactEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .formParam("author_user_id", "")
		      .formParam("organization_user_id","")
		      .formParam("external_id", "")
		      .formParam("contact_id", "")
		      .formParam("title", "Alertus Group")
		      .formParam("first_name","Yasemin")
		      .formParam("last_name", "Arslan")
		      .formParam("phone", "2032345678")
		      .formParam("email", "yasemin@test.com")
		      .formParam("address_1","1111 Street")
		      .formParam("city", "Springfield")
		      .formParam("state", "VA")
		      .formParam("zip_code", "11111")
		      .formParam("country","US")
		      
		      .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.put("/api/contacts/96d2a528-a2c4-444b-96cf-db0bcd2cb420");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);

}
@Test(priority=4,enabled=true)
public void deleteASpecificContactEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request =RestAssured.given().log().all();
	request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
	
	
	Response response=request.delete("/api/contacts/96d2a528-a2c4-444b-96cf-db0bcd2cb420");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
		}
@Test(priority=5,enabled=false)
public void ReturnsAContactBasedOnSingleUUID(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/contacts/96d2a528-a2c4-444b-96cf-db0bcd2cb420");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}

}
