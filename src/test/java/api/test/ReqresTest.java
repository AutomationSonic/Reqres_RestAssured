package api.test;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.ReqresEndOintsa;
import api.payload.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
public class ReqresTest {
	Faker faker;
	User data;
	@BeforeTest
	public void setupData() {
		faker = new Faker();
		data = new User();
		data.setName(faker.name().fullName());
		data.setJob(faker.job().position());
		data.setEmail("eve.holt@reqres.in");
		data.setPassword("pistol");
}
	@Test(priority = 1)
	public void testlistuser() {
		Response response = ReqresEndOintsa.List_User();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 2)
	public void testcreateuser() {
		Response response = ReqresEndOintsa.Create_user(data);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		JsonPath jsonPathEvaluator = response.jsonPath();
		 String Id = jsonPathEvaluator.get("id");
		 System.out.println(Id);
	}
	@Test(priority = 3)
	public void testupdate() {
		Response response = ReqresEndOintsa.Put_update(data);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 4)
	public void deleteuser() {
		Response response = ReqresEndOintsa.delete_user();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	@Test(priority = 5)
	public void registeruser() {
		Response response = ReqresEndOintsa.register_user(data);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}	
}