package lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson5.model.ErrorBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

public class AbstractTest {
    ErrorBody getErrorBody(Response<ResponseBody> response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        assert response.errorBody() != null;
        return mapper.readValue(response.errorBody().charStream(), ErrorBody.class);
    }
}
