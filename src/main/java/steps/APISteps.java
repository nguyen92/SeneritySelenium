package steps;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import netscape.javascript.JSObject;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APISteps {
    Response response;
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJmZDc0NDBjZS0yNzhiLTRlMjMtYTU0NC1hM2UxNmI0ZTRiNjIiLCJ1bmlxdWVfbmFtZSI6InVzZXJhMUBnbWFpbC5jb20iLCJuYW1laWQiOiJ1c2VyYTFAZ21haWwuY29tIiwiZW1haWwiOiJ1c2VyYTFAZ21haWwuY29tIiwiYXV0aF90aW1lIjoiMDkvMDgvMjAyMiAwNToyNjo0OSIsImRiX25hbWUiOiJ3aGF0c2FwcF9pbmJveF9kZXYiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJBRE1JTklTVFJBVE9SIiwiZXhwIjoyNTM0MDIzMDA4MDAsImlzcyI6IkNsYXJlX0FJIiwiYXVkIjoiQ2xhcmVfQUkifQ.bD6_-HJGe87FbL_GSV4i-r720UoM5zSGpzvIj01PZ7o";
    String url = "https://whatsapp-inbox-server.clare.ai/api/v1/contacts";
    @Step("send request to get contact list")
    public Response sendPostRequest(int pageSize, int pageNumber) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pageSize", pageSize);
        map.put("pageNumber", pageNumber);

        response = SerenityRest.given().header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON).body(map).log().all().post(url);
        return response;

    }

    @Step("verify the status code")
    public void verifyStatusCode(int code) {
        response.then().statusCode(code).equals(code);
    }


    @Step("get contact has valid")
    public void getTheContact(Response res) {
        JsonPath extractor = res.jsonPath();
        List<String> contactLst = extractor.getList("result.items.findAll{it.contactStatus == 'VALID'}");
        System.out.println(contactLst);

    }
}
