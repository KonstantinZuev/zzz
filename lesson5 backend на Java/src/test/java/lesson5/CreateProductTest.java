package lesson5;

import lesson5.api.ProductService;
import lesson5.model.Product;
import lesson5.utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static com.github.javafaker.Faker.instance;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateProductTest extends AbstractTest {
    static ProductService productService;

    private int productId;

    @BeforeAll
    static void beforeAll() {
        productService =
                RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    void createProduct() throws IOException {
        Product product = Product.builder().title(instance().food().ingredient()).price((int) (Math.random() * 10000)).categoryTitle("Food").build();

        Response<Product> response = productService.createProduct(product).execute();

        assert response.body() != null;
        productId = response.body().getId();
        assertThat(response.body().getId(), not(nullValue()));
        assertThat(response.body().getTitle(), is(product.getTitle()));
        assertThat(response.body().getPrice(), is(product.getPrice()));
        assertThat(response.body().getCategoryTitle(), is(product.getCategoryTitle()));
    }

    @Test
    void createProductWithoutNameAndPrice() throws IOException {
        Product product = Product.builder().categoryTitle("Food").build();

        Response<Product> response = productService.createProduct(product).execute();

        productId = response.body().getId();
        assertThat(response.body().getId(), not(nullValue()));
        assertThat(response.body().getTitle(), is(nullValue()));
        assertThat(response.body().getPrice(), is(0));
        assertThat(response.body().getCategoryTitle(), is("Food"));
    }

    @Test
    void tryToCreateProductWithId() throws IOException {
        Product product = new Product(1, "Test product", 10, "Food");

        Response<ResponseBody> response = productService.createIncorrectProduct(product).execute();

        assertThat(response.isSuccessful(), is(false));
        assertThat(getErrorBody(response).getMessage(), is("Id must be null for new entity"));
    }

    @Test
    void tryToCreateProductWithoutCategory() throws IOException {
        Product product = Product.builder().title("Test product").price(10).build();

        Response<ResponseBody> response = productService.createIncorrectProduct(product).execute();

        assertThat(response.isSuccessful(), is(false));
    }

    @Test
    void tryToCreateProductWithIncorrectCategory() throws IOException {
        Product product = Product.builder().title("Test product").price(10).categoryTitle("Category").build();

        Response<ResponseBody> response = productService.createIncorrectProduct(product).execute();

        assertThat(response.isSuccessful(), is(false));
    }

    @AfterEach
    void tearDown() {
        if (productId != 0) {
            productService.removeProduct(productId);
        }
    }
}
