package br.com.luizgmelo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

    private String title;

    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    private Double popularity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDateFormatted() {
        if (releaseDate == null || releaseDate.isEmpty()) {
            return "";
        }

        try {
            DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate date = LocalDate.parse(releaseDate, formatInput);
            return date.format(formatOutput);
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao formatar data: " + releaseDate);
            return releaseDate;
        }
    }

    public Double getPopularity() {
        return popularity;
    }

    @Override
    public String toString() {
        return "\n" + "Título: " + title + "\n" +
                "Descrição: " + overview + "\n" +
                "Data de Lançamento: " + getReleaseDateFormatted() + "\n" +
                "Popularidade: " + String.format("%.2f", popularity);
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
}
