package lesson5;

import lesson5.api.ProductService;
import lesson5.model.Product;
import lesson5.utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateProductTest extends AbstractTest {
    static ProductService productService;

    private int productId;

    @BeforeAll
    static void beforeAll() {
        productService =
                RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @BeforeEach
    void setUp() throws IOException {
        Product product = Product.builder().title("Product for update").price(25).categoryTitle("Food").build();

        Response<Product> response = productService.createProduct(product).execute();

        assert response.body() != null;
        productId = response.body().getId();
    }

    @Test
    void fullProductUpdate() throws IOException {
        Product updatedProduct = Product.builder().id(productId).title("Test gadget").price((int) (Math.random() * 10000)).categoryTitle("Electronic").build();;

        Product response = productService.modifyProduct(updatedProduct).execute().body();

        assert response != null;
        assertThat(response.getId(), is(productId));
        assertThat(response.getTitle(), is(updatedProduct.getTitle()));
        assertThat(response.getPrice(), is(updatedProduct.getPrice()));
        assertThat(response.getCategoryTitle(), is(updatedProduct.getCategoryTitle()));
    }

    @Test
    void updateProductWithoutNameAndPrice() throws IOException {
        Product product = Product.builder().id(productId).categoryTitle("Electronic").build();
        Response<Product> response = productService.modifyProduct(product).execute();

        productId = response.body().getId();
        assertThat(response.body().getId(), not(nullValue()));
        assertThat(response.body().getTitle(), is(nullValue()));
        assertThat(response.body().getPrice(), is(0));
        assertThat(response.body().getCategoryTitle(), is("Electronic"));
    }

    @Test
    void tryToUpdateProductWithoutId() throws IOException {
        Product product = Product.builder().title("Updated product").price(10).categoryTitle("Electronic").build();

        Response<ResponseBody> response = productService.modifyProductWithIncorrectData(product).execute();

        assertThat(response.isSuccessful(), is(false));
        assertThat(getErrorBody(response).getMessage(), is("Id must be not null for new entity"));
    }

    @Test
    void tryToCreateProductWithoutCategory() throws IOException {
        Product product = Product.builder().id(productId).title("Test product").price(10).build();

        Response<ResponseBody> response = productService.modifyProductWithIncorrectData(product).execute();

        assertThat(response.isSuccessful(), is(false));
    }

    @Test
    void tryToCreateProductWithIncorrectCategory() throws IOException {
        Product product = Product.builder().id(productId).title("Test product").price(10).categoryTitle("Category").build();

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
