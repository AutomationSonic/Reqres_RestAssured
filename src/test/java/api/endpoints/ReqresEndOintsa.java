package api.endpoints;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import api.payload.User;
import api.test.ReqresTest;

public class ReqresEndOintsa {
	public static Response List_User() {
		Response response = given()
				.when()
				.get(Routes.Get_List_User);
				return response;				
	}
	public static Response Create_user(User details) {
		Response response = given()
				.when()
				.body(details)
				.post(Routes.Post_Create);
		return response;
	}
	public static Response Put_update (User details) {
		Response response = given()
				.when()
				.body(details)
				.put(Routes.Put_Update);
		return response;
				
	}
	public static Response delete_user() {
		Response response = given()
				.when()
				.delete(Routes.Delete_user);
		return response;
	}
	public static Response register_user(User details) {
		Response response = given()
				.contentType("application/json")
				.body(details)
				.post(Routes.Rigister_user);
		return response;
	}
}
