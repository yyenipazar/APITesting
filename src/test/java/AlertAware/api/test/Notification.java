package AlertAware.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Notification {
	@Test(priority=1,enabled=false)
	public void createANewNotificationEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("name", "AlertAware")
			      .formParam("description", "Alert technologies")
			      .formParam("delivery_date", "2021-05-29 11:30:00")
			      .formParam("organization_uuid", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e08")
			      .formParam("author_uuid","0e896985-8279-4200-a8d0-e52619a8095e")
			      .formParam("delivery_methods","0")
			      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	
		Response response=request.post("/api/notifications");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=2,enabled=false)
	public void returnAllNotificationEntries(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/notifications");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}
	@Test(priority=3,enabled=false)
	public void returnANotificationBasedOnASingleUUID(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/notifications/85889aa3-559b-4568-9330-27ea722d9c61");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
	}
@Test(priority=4,enabled=false)
public void updateASpecificNotificationEntry(){
RestAssured.baseURI="https://devapi.alertaware.com";	
RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
	     .encoderConfig(EncoderConfig.encoderConfig()
	     .encodeContentTypeAs("x-www-form-urlencoded",
	     ContentType.URLENC)))
	     .contentType("x-www-form-urlencoded")
	      .formParam("name", "Alertus Technology")
	      .formParam("description", "Alert technologies")
	      .formParam("organization_uuid", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e08")
	      .formParam("author_uuid","0e896985-8279-4200-a8d0-e52619a8095e")
	      .formParam("delivery_methods","0")
	      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	     

Response response=request.put("/api/notifications/85889aa3-559b-4568-9330-27ea722d9c61");
System.out.println(response.prettyPrint());

Assert.assertEquals(response.getStatusCode(),200);

}
@Test(priority=5,enabled=false)
public void deleteASpecificNotificationEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request =RestAssured.given().log().all();
	request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
	
	
	Response response=request.delete("/api/notifications/85889aa3-559b-4568-9330-27ea722d9c61");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
		}
@Test(priority=6,enabled=false)
public void returnAllDeliveryMethodsEntries(){
RestAssured.baseURI="https://devapi.alertaware.com";	
RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
	     .encoderConfig(EncoderConfig.encoderConfig()
	     .encodeContentTypeAs("x-www-form-urlencoded",
	     ContentType.URLENC)))
	     .contentType("x-www-form-urlencoded")
	     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

Response response=request.get("/api/delivery-methods");
System.out.println(response.prettyPrint());

Assert.assertEquals(response.getStatusCode(),200);
}
@Test(priority=3,enabled=true)
public void returnsADeliveryMethodOnASingleID(){
RestAssured.baseURI="https://devapi.alertaware.com";	
RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
	     .encoderConfig(EncoderConfig.encoderConfig()
	     .encodeContentTypeAs("x-www-form-urlencoded",
	     ContentType.URLENC)))
	     .contentType("x-www-form-urlencoded")
	     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

Response response=request.get("/api/delivery-methods/1");
System.out.println(response.prettyPrint());

Assert.assertEquals(response.getStatusCode(),200);
}

}



