package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherApiClient {

    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";
    private static final String API_KEY = "cef56a08de84492b973121917241412";

    public String sendRequest(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + "?key=" + API_KEY + "&q=" + city + "&aqi=no")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
