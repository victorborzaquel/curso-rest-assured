package curso_rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ola_mundo {
	public static void main(String[] args) {
		Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
		
		System.out.println(response.getBody().asString());
		System.out.println(response.statusCode());
		
		ValidatableResponse validatableResponse = response.then();
		
		validatableResponse.statusCode(200);
	}
}
