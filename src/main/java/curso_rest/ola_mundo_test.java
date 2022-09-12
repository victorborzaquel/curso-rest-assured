package curso_rest;

import static io.restassured.RestAssured.*;

import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ola_mundo_test {
	@Test
	public void test() {
		Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");

		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue("O status code deve ser 200", response.statusCode() == 200);
		Assert.assertEquals(200, response.statusCode());

		ValidatableResponse validatableResponse = response.then();

		validatableResponse.statusCode(200);
	}
	
	@Test
	public void formaCompleta() {
		Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");

		Assert.assertEquals(200, response.statusCode());

		ValidatableResponse validatableResponse = response.then();

		validatableResponse.statusCode(200);
	}
	
	@Test
	public void formaEnchuta() {
		RestAssured.get("http://restapi.wcaquino.me/ola").then().statusCode(201);
	}

	@Test
	public void formaMaisEnchuta() {
		get("http://restapi.wcaquino.me/ola").then().statusCode(201);
	}

	@Test
	public void formaLegivel() {
//		Given When Then - Dado Quando Entao
		given()//Pre condicoes
		.when()//acao
			.get("http://restapi.wcaquino.me/ola")
		.then()//verificacao / Assertivos
//			.assertThat()
			.statusCode(200);
	}
}
