package AlertAware.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignUp {
	
	@Test(priority=1,enabled=false)
	public void createANewUserEntry(){
		RestAssured.baseURI="https://devapi.alertaware.com";	
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
			     .contentType("x-www-form-urlencoded")
			      .formParam("password", "password")
			      .formParam("password_confirm","password")
			      .formParam("username", "yarslan$$??*")
			      .formParam("first_name", "Yasemin")
			      .formParam("last_name", "Arslan")
			      .formParam("phone","2079865645")
			      .formParam("is_active_at","04/26/2021")
			      .formParam("activation_code","arslan")
			      .formParam("activated_at","04/26/2021")
			      .formParam("user_verified_at","04/26/2021")
			      .formParam("email_verified_at","04/26/2021")
			      .formParam("phone_verified_at","04/26/2021")
			      .formParam("is_demo","t")
			      .formParam("uuid","")
			      .formParam("slug","")
			      .formParam("is_twofactor_enabled","t")
			      .formParam("title","Mrs")
			      .formParam("dob","09/03/1975")
			      .formParam("gender","f")
			      .formParam("email","yasemin@test.com")
			     .header("Access-Token","6c4278f0b728ad429ad34a6bae8fcf7da138a20a4fd32a617c66927c26817dd4faf82ba189369a70099dbcf48d5b3d33eae70535587c33caef922944560ef4eb").request();
	
		Response response=request.post("/api/users");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),201);
		
		
	}
	@Test(priority=2,enabled=false)
	public void returnAllUserEntries(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		     .header("Access-Token","12f4bde8753f647d96068b52c04bbd81ea260ba9bcb2f29f27740f593c16abf53c53612fe8e36ecab1b5cf989d2ca90cf25faa464b223ed15c91ea75b3d92b7f").request();

	Response response=request.get("/api/users/15ce8eac-b655-49db-bf6e-615c17a97a9c");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
}
@Test(priority=3,enabled=false)
public void updateASpecificUserEntry(){
RestAssured.baseURI="https://devapi.alertaware.com";	
RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
	     .encoderConfig(EncoderConfig.encoderConfig()
	     .encodeContentTypeAs("x-www-form-urlencoded",
	     ContentType.URLENC)))
	     .contentType("x-www-form-urlencoded")
	     .formParam("password", "password")
	      .formParam("password_confirm","password")
	      .formParam("username", "yarslan$")
	      .formParam("first_name", "Yasemin")
	      .formParam("last_name", "Arslan")
	      .formParam("phone","2079865645")
	      .formParam("is_active_at","04/26/2021")
	      .formParam("activation_code","arslan")
	      .formParam("activated_at","05/26/2021")
	      .formParam("user_verified_at","05/26/2021")
	      .formParam("email_verified_at","05/26/2021")
	      .formParam("phone_verified_at","05/26/2021")
	      .formParam("is_demo","t")
	      .formParam("uuid","15ce8eac-b655-49db-bf6e-615c17a97a9c")
	      .formParam("slug","")
	      .formParam("is_twofactor_enabled","f")
	      .formParam("title","Mrs")
	      .formParam("dob","09/03/1975")
	      .formParam("gender","f")
	      .formParam("email","yasemin@test.com")
	      .header("Access-Token","2ace00b38ac791bbb29ded86b44d246e0bead0c5263558f999fa408e2545968ff0815ab16e5570f471cdf2f50b0e1fe601944062073672916be940ac9556bc31").request();
Response response=request.put("/api/users/15ce8eac-b655-49db-bf6e-615c17a97a9c");
System.out.println(response.prettyPrint());

Assert.assertEquals(response.getStatusCode(),200);

}
@Test(priority=4,enabled=false)
public void deleteASpecificUserEntry(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request =RestAssured.given().log().all();
	request.header("Access-Token","efc881efcb9ef537b1a51f57245fb170cf7723d984a6461d5d224d51135e6c453f381122fc9e9210487b3b5cb27dff92fc81e732a8a7d6a895944e50806f5e44");
	
	
	Response response=request.delete("/api/users/61771831-3d84-4b93-95ba-e9cb949034b9");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),200);
		}
@Test(priority=5,enabled=true)
public void createANewUserEntryWithoutAuthentication(){
	RestAssured.baseURI="https://devapi.alertaware.com";	
	RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
		     .encoderConfig(EncoderConfig.encoderConfig()
		     .encodeContentTypeAs("x-www-form-urlencoded",
		     ContentType.URLENC)))
		     .contentType("x-www-form-urlencoded")
		      .formParam("password", "password")
		      .formParam("password_confirm","password")
		      .formParam("username", "yarslan@????")
		      .formParam("first_name", "Yasemin")
		      .formParam("last_name", "Arslan")
		      .formParam("phone","2079865645")
		      .formParam("is_active_at","05/11/2021")
		      .formParam("activation_code","arslan")
		      .formParam("activated_at","05/11/2021")
		      .formParam("user_verified_at","05/11/2021")
		      .formParam("email_verified_at","05/11/2021")
		      .formParam("phone_verified_at","05/11/2021")
		      .formParam("is_demo","t")
		      .formParam("uuid","")
		      .formParam("slug","")
		      .formParam("is_twofactor_enabled","t")
		      .formParam("title","Mrs")
		      .formParam("dob","09/03/1975")
		      .formParam("gender","f")
		      .formParam("email","yasemin@test.com")
		     .header("Access-Token","2ace00b38ac791bbb29ded86b44d246e0bead0c5263558f999fa408e2545968ff0815ab16e5570f471cdf2f50b0e1fe601944062073672916be940ac9556bc31").request();

	Response response=request.post("/api/register");
	System.out.println(response.prettyPrint());
	
	Assert.assertEquals(response.getStatusCode(),201);
}
}