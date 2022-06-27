
/**
*@author Zuev Konstantin
*@version 24.06.2022
*/


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<WeatherResponse> response = objectMapper.readValue(new File("weather.json"), new TypeReference<List<WeatherResponse>>() {});
        System.out.println(response);
    }
}
