package com.uefa;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Equipo;
import models.EquiposData;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    /*public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lee el archivo JSON y deserialízalo en un objeto EquiposData
            EquiposData data = mapper.readValue(
                new File("src/main/resources/equipos.json"),
                EquiposData.class
            );

            // Obtén la lista de equipos
            List<Equipo> equipos = data.getEquipos();

            // Usa los campos de la clase Equipo
            for (Equipo equipo : equipos) {
                System.out.println("Equipo: " + equipo.getName());
                System.out.println("Entrenador: " + equipo.getCoach());
                System.out.println("Año de fundación: " + equipo.getYearFoundation());
                System.out.println("Jugadores: " + equipo.getPlayers().size());
                System.out.println("Estadisticas: " + equipo.getStatistics());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lee el archivo JSON y deserialízalo en un objeto EquiposData
            EquiposData data = mapper.readValue(
                new File("src/main/resources/equipos.json"),
                EquiposData.class
            );

            // Obtén la lista de equipos
            List<Equipo> equipos = data.getEquipos();

            // Predicate para filtrar equipos fundados después del año 2000
            Predicate<Equipo> fundadosDespues2000 = equipo -> {
                int yearFoundation = Integer.parseInt(equipo.getYearFoundation());
                return yearFoundation > 2000;
            };

            // Filtrar la lista usando Stream
            List<Equipo> equiposFiltrados = equipos.stream()
                                                    .filter(fundadosDespues2000)
                                                    .collect(Collectors.toList());

            // Imprimir los equipos filtrados
            System.out.println("Equipos fundados después del año 2000:");
            equiposFiltrados.forEach(equipo -> System.out.println(equipo.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}