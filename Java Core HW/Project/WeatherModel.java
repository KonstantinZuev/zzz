/**
*Java 2. Home work #6
*
*@author Zuev Konstantin
*@version 26.04.2022
*/

package lesson7.project;

import lesson7.project.entity.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;

    public List<Weather> getSavedToDBWeather();
}