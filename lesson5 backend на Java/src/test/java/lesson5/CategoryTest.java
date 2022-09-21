package lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson5.api.CategoryService;
import lesson5.model.ErrorBody;
import lesson5.model.GetCategoryResponse;
import lesson5.utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoryTest extends AbstractTest{
    static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() {
        categoryService =
                RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @Test
    void getCategoryByExistingIdTest() throws IOException {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();

        assertThat(response.isSuccessful(), is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Food")));
    }

    @Test
    void tryToGetNonExistingCategory() throws IOException {
        Response<ResponseBody> response = categoryService.getIncorrectCategory(3).execute();


        assertThat(response.isSuccessful(), is(false));
        assertThat(getErrorBody(response).getMessage(), is("Unable to find category with id: 3"));
    }
}
