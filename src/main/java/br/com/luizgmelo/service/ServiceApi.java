package br.com.luizgmelo.service;

import br.com.luizgmelo.dto.ApiResponseDto;
import br.com.luizgmelo.dto.MovieDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ServiceApi {

    final String API_TOKEN = "YOUR_TOKEN";

    public List<MovieDto> getMoviesByType(String type) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/" + type))
                    .header("Authorization", "Bearer " + API_TOKEN)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseDto responseDto = objectMapper.readValue(response.body(), ApiResponseDto.class);
            return responseDto.getResults();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
