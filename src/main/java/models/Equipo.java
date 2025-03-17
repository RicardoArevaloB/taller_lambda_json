package models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipo implements Serializable {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("yearfoundation") // Asegúrate de que coincida con el JSON
    private String yearFoundation;

    @JsonProperty("statistics")
    private List<Estadisticas> statistics;

    @JsonProperty("players")
    private List<Jugador> players;

    @JsonProperty("coach")
    private String coach;

    // Constructor vacío (necesario para Jackson)
    public Equipo() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(String yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public List<Estadisticas> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Estadisticas> statistics) {
        this.statistics = statistics;
    }

    public List<Jugador> getPlayers() {
        return players;
    }

    public void setPlayers(List<Jugador> players) {
        this.players = players;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Equipo: " + name + " | Año de fundación: " + yearFoundation + " | Entrenador: " + coach +" | Estadisticas: " + statistics;
    }
}