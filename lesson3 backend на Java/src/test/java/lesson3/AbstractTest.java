package lesson3;

import io.restassured.response.Response;
import model.AddToShoppingListRequest;
import model.MealPlannerItem;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    private static String userName;
    private static String hash;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/application.properties");
        prop.load(configFile);

        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("base_url");
        userName =  prop.getProperty("user_name");
        hash =  prop.getProperty("hash");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    Response complexSearch(Map<String, String> params) {
        params.put("apiKey", apiKey);

        return given()
                .queryParams(params)
                .when()
                .get(baseUrl + "/recipes/complexSearch");
    }

    Response defineCuisine(Map<String, String> queryParams, Map<String, String> formParams) {
        queryParams.put("apiKey", apiKey);

        return given()
                .queryParams(queryParams)
                .contentType("application/x-www-form-urlencoded")
                .formParams(formParams)
                .when()
                .post(baseUrl + "/recipes/cuisine");
    }

    Response addItemToMealPlan(List<MealPlannerItem> items) {
        Map<String, String> params = Map.of("apiKey", apiKey, "hash", hash);

        return given()
                .queryParams(params)
                .body(items)
                .post(baseUrl + "/mealplanner/{username}/items", userName);
    }

    Response removeItemFromMealPlan(long id) {
        Map<String, String> params = Map.of("apiKey", apiKey, "hash", hash);

        return given()
                .queryParams(params)
                .delete(baseUrl + "/mealplanner/{username}/items/{id}", userName, id);
    }

    Response addItemToShoppingList(AddToShoppingListRequest body) {
        Map<String, String> params = Map.of("apiKey", apiKey, "hash", hash);

        return given()
                .queryParams(params)
                .body(body)
                .post(baseUrl + "/mealplanner/{username}/shopping-list/items", userName);
    }

    Response removeItemFromShoppingList(long id) {
        Map<String, String> params = Map.of("apiKey", apiKey, "hash", hash);

        return given()
                .queryParams(params)
                .delete(baseUrl + "/mealplanner/{username}/shopping-list/items/{id}", userName, id);
    }
}
