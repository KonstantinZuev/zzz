package lesson3;

import io.restassured.path.json.JsonPath;
import model.AddToShoppingListRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingListTest extends AbstractTest {
    private long id;

    @Test
    public void addItemToShoppingList() {
        //given
        AddToShoppingListRequest body = new AddToShoppingListRequest("1 package baking powder", "Baking", true);

        //when
        JsonPath response = addItemToShoppingList(body).then().extract().jsonPath();

        //then
        id = response.getLong("id");
        assertThat(id, not(nullValue()));
        assertThat(response.getString("name"), is("baking powder"));
        assertThat(response.getString("measures.original.amount"), is("1.0"));
        assertThat(response.getString("measures.original.unit"), is("package"));
    }

    @AfterEach
    public void tearDown() {
        removeItemFromShoppingList(id);
    }
}
