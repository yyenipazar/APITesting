package AlertAware.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Groups {
	@Test(priority=1,enabled=false)
	public void createANewGroupEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("name", "AlertAware#")
			      .formParam("description","Alert group")
			      .formParam("author_uuid", "959de795-752e-406a-8d3d-36409227f818")
			      .formParam("organization_uuid", "825a0c97-71cf-4998-b30a-c96c2bc70035")
			      .formParam("allow_subscription", "false")
			      .formParam("auto_subscribe","true")
			      .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	
		Response response=request.post("/api/groups");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=2,enabled=false)
	public void returnAllGroupEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/groups");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}
@Test(priority=3,enabled=false)
public void updateASpecificGroupEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		      .formParam("name", "AlertAware$")
		      .formParam("description","Alert group")
		      .formParam("author_uuid", "959de795-752e-406a-8d3d-36409227f818")
		      .formParam("organization_uuid", "825a0c97-71cf-4998-b30a-c96c2bc70035")
		      .formParam("allow_subscription", "false")
		      .formParam("auto_subscribe","false")
		      .formParam("slug", "AlertAware$")
		      .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.put("/api/groups/c4d1e14e-0f34-4e9e-8352-bdbbb3a720f5");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);

}
@Test(priority=4,enabled=true)
public void deleteASpecificGroupEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request =RestAssured.given().log().all();
	request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
	
	
	Response response=request.delete("/api/groups/c4d1e14e-0f34-4e9e-8352-bdbbb3a720f5");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
		}
@Test(priority=5,enabled=false)
public void ReturnsAGroupBasedOnSingleUUID(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/groups/c4d1e14e-0f34-4e9e-8352-bdbbb3a720f5");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}
}



