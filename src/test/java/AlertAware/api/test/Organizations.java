package AlertAware.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Organizations {
	
		@Test(priority=1,enabled=false)
		public void createANewOrganizationEntry(){
			RestAssured.baseURI="https://devapi.alertaware.com";	
			RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
				     .encoderConfig(EncoderConfig.encoderConfig()
				     .encodeContentTypeAs("x-www-form-urlencoded",
				     ContentType.URLENC)))
				     .contentType("x-www-form-urlencoded")
				      .formParam("name", "Acme Company 6")
				      .formParam("description", "Organization for the Acme Company 10")
				      .formParam("alertus_organization_id", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e07")
				      .formParam("owner_user_uuid", "cd591a60-54a0-4975-8876-14d29bd9baf3")
				      .formParam("safety_phone_numbers","240-445-1111")
				      .formParam("alertus_server_host","https://acme.alertus.com")
				      .formParam("alertus_server_user","root")
				      .formParam("safety_website","www.acme.org")
				      .formParam("is_public","true")
				      .formParam("alertus_server_password","root")
				      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
		
			Response response=request.post("/api/organizations");
			System.out.println(response.prettyPrint());
			
			Assert.assertEquals(response.getStatusCode(),201);
			
			
		}
		@Test(priority=2,enabled=false)
		public void returnAllOrganizationsEntries(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

		Response response=request.get("/api/organizations");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
		@Test(priority=3,enabled=false)
		public void returnAnOrganizationBasedOnASingleUUID(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

		Response response=request.get("/api/organizations/b0d61133-ec57-4034-952c-70ec8d2a72bb");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
		}
	@Test(priority=4,enabled=false)
	public void updateASpecificOrganizationEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
			.formParam("name", "Acme Company 6")
		      .formParam("description", "Organization for the Acme Company 10")
		      .formParam("alertus_organization_id", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e07")
		      .formParam("owner_user_uuid", "cd591a60-54a0-4975-8876-14d29bd9baf3")
		      .formParam("safety_phone_numbers","240-445-3333")
		      .formParam("alertus_server_host","https://acme.alertus.com")
		      .formParam("alertus_server_user","root")
		      .formParam("safety_website","www.acme.org")
		      .formParam("is_public","true")
		      .formParam("alertus_server_password","root")
		      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.put("/api/organizations/b0d61133-ec57-4034-952c-70ec8d2a72bb");
	System.out.println(response.prettyPrint());

	Assert.assertEquals(response.getStatusCode(),200);

	}
	@Test(priority=5,enabled=false)
	public void deleteASpecificOrganizationEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
		
		
		Response response=request.delete("/api/organizations/b0d61133-ec57-4034-952c-70ec8d2a72bb");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
			}
	@Test(priority=6,enabled=false)
	public void returnAllOrganizationDetailsEntries(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/organization-details");
	System.out.println(response.prettyPrint());

	Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=7,enabled=false)
	public void returnsAnOrganizationsDetailsOnASingleUUID(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/organization-details/fc20cfa0-3c55-40ce-8954-fde16584e707");
	System.out.println(response.prettyPrint());

	Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=8,enabled=false)
	public void createANewOrganizationDetailEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("organization_uuid", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e08")
			      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	
		Response response=request.post("/api/organization-details");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=9,enabled=false)
	public void updateASpecificOrganizationDetailEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
			.formParam("organization_uuid", "aded2d49-dc8e-42da-bb30-7ecd3f1a2e08")
		    .formParam("banner_url", "ab")
		      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.put("/api/organization-details/fc20cfa0-3c55-40ce-8954-fde16584e707");
	System.out.println(response.prettyPrint());

	Assert.assertEquals(response.getStatusCode(),200);

	}
	@Test(priority=10,enabled=false)
	public void deleteASpecificOrganizationDetailEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
		
		
		Response response=request.delete("/api/organization-details/fc20cfa0-3c55-40ce-8954-fde16584e707");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=11,enabled=false)
	public void returnAllUserOrganizationEntries(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/user-organizations");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=12,enabled=false)
	public void createANewUserOrganizationEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("id", "1")
			      .formParam("user_uuid", "3e0326e1-bf8b-4f4b-8588-70468e68d809")
			      .formParam("organization_uuid", "c65f1e54-9eb8-4ad3-8b7c-51ad4bddc819")
			      .formParam("role_uuid", "e929029a-4218-46c0-9838-ccf92b01c152")
			      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();
	
		Response response=request.post("/api/user-organizations");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=13,enabled=false)
	public void returnsAnUserOrganizationBasedOnASingleID(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.get("/api/user-organizations/216");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=14,enabled=false)

	public void updateASpecificUserOrganizationEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		      .formParam("user_uuid", "3e0326e1-bf8b-4f4b-8588-70468e68d809")
		      .formParam("organization_uuid", "c65f1e54-9eb8-4ad3-8b7c-51ad4bddc819")
		      .formParam("role_uuid", "e929029a-4218-46c0-9838-ccf92b01c152")
		      		     .header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884").request();

	Response response=request.put("/api/user-organizations/216");
	System.out.println(response.prettyPrint());

	Assert.assertEquals(response.getStatusCode(),200);

	}
	@Test(priority=15,enabled=true)
	public void deleteASpecificUserOrganizatiEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Access-Token","23b7ee021f6b0a960621181992fe3cc0faa890749d3f395874f565aff584f0126a2ab7989b72525d36fc09c45756d2b99a078d491fab84d99cf4909b63e6f884");
		
		
		Response response=request.delete("/api/user-organizations/216");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
}



