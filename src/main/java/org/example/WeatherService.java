package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

@Service
public class WeatherService {

    @Autowired
    private WeatherApiClient weatherApiClient;
    @PostConstruct
    public void init() {
        try {
            fetchAndPrintWeather();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchAndPrintWeather() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название города: ");
        String city = scanner.nextLine();

        String jsonResponse = weatherApiClient.sendRequest(city);
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = mapper.readValue(jsonResponse, WeatherResponse.class);
        float temperature = weatherResponse.getCurrent().getTemp_c();
        String cloudiness = weatherResponse.getCurrent().getCondition().getText();
        System.out.println(city + ": " + "температура: " + temperature + "°C," + " облачность: " + cloudiness);
    }
}
