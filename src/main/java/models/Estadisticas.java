package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estadisticas {
    @JsonProperty("pj")
    private String pj; // Partidos jugados

    @JsonProperty("pg")
    private String pg; // Partidos ganados

    @JsonProperty("pe")
    private String pe; // Partidos empatados

    @JsonProperty("pp")
    private String pp; // Partidos perdidos

    @JsonProperty("gf")
    private String gf; // Goles a favor

    @JsonProperty("gc")
    private String gc; // Goles en contra

    @JsonProperty("tp")
    private String tp; // Total de puntos

    // Getters y Setters
    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
}