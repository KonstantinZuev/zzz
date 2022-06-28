import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
*Java 2. Home work #6
*
*@author Zuev Konstantin
*@version 28.06.2022
*/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String city;
    @JsonProperty(value = "Date")
    private String localDate;
    private double temperature;

    public Weather() {
    }

    public Weather(String city, String localDate, double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", temperature=" + String.format("%.2f", temperature) +
                '}';
    }
}