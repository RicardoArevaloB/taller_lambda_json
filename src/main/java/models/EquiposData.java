package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EquiposData {
    @JsonProperty("equipos")
    private List<Equipo> equipos;

    // Getter y Setter
    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
