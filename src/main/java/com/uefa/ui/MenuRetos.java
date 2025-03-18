package com.uefa.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.uefa.Main;

import models.Equipo;
import models.Jugador;

public class MenuRetos {
    private List<Equipo> equipos;

    public MenuRetos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void mostrarMenuRetosPropuestos() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                // Mostrar el menú
                System.out.println("\n--- Menú ---");
                System.out.println("1. Listar equipos fundados después del año 2000");
                System.out.println("2. Listar los nombres de los entrenadores");
                System.out.println("3. Promedio de edad de los jugadores por equipo");
                System.out.println("4. Equipos con más de 20 victorias");
                System.out.println("5. Jugador más alto de cada equipo");
                System.out.println("6. Total de goles por equipo");
                System.out.println("7. Volver al menu pricipal");
                System.out.print("Seleccione una opción: ");

                try {
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer del scanner

                    switch (opcion) {
                        case 1:
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
                            System.out.println("\nEquipos fundados después del año 2000:");
                            equiposFiltrados.forEach(equipo -> System.out
                                    .println(equipo.getName() + " fundado en: " + equipo.getYearFoundation()));
                            break;

                        case 2:
                            Consumer<Equipo> imprimirEntrenador = equipo -> {
                                System.out.println("Entrenador de " + equipo.getName() + ": " + equipo.getCoach());
                            };
                            System.out.println("\nNombre de los entrenadores:");
                            equipos.forEach(imprimirEntrenador);
                            break;

                        case 3:
                            // BiConsumer para calcular y mostrar el promedio de edad
                            BiConsumer<Equipo, List<Jugador>> calcularPromedioEdad = (equipo, jugadores) -> {
                                double promedioEdad = jugadores.stream()
                                        .mapToInt(jugador -> Integer.parseInt(jugador.getAge()))
                                        .average()
                                        .orElse(0);
                                System.out.printf("Promedio de edad en el %s: %.2f años%n", equipo.getName(), promedioEdad);
                            };

                            System.out.println("\nPromedio de edad de los jugadores por equipo:");
                            equipos.forEach(equipo -> calcularPromedioEdad.accept(equipo, equipo.getPlayers()));
                            break;

                        case 4:
                            Predicate<Equipo> masDe20Victorias = equipo -> {
                                int partidosGanados = Integer.parseInt(equipo.getStatistics().get(0).getPg());
                                return partidosGanados > 20;
                            };

                            // Filtrar la lista de equipos usando Stream
                            List<Equipo> equiposConMas20Victorias = equipos.stream()
                                    .filter(masDe20Victorias)
                                    .collect(Collectors.toList());

                            System.out.println("\nEquipos con más de 20 victorias:");
                            equiposConMas20Victorias.forEach(equipo -> System.out
                                    .println(equipo.getName() + " con: " + equipo.getStatistics().get(0).getPg() + " Victorias"));
                            break;

                        case 5:
                            System.out.println("\nJugador más alto en cada equipo:");
                            equipos.forEach(equipo -> {
                                Jugador jugadorMasAlto = equipo.getPlayers().stream()
                                        .max((j1, j2) -> Integer.compare(
                                                Integer.parseInt(j1.getHeight()),
                                                Integer.parseInt(j2.getHeight())))
                                        .orElse(null); // Si no hay jugadores, devuelve null

                                // Mostrar el resultado
                                if (jugadorMasAlto != null) {
                                    System.out.printf("%-20s: %s (Altura: %s cm)%n",
                                            equipo.getName(),
                                            jugadorMasAlto.getName(),
                                            jugadorMasAlto.getHeight());
                                } else {
                                    System.out.printf("%-20s: No tiene jugadores registrados.%n", equipo.getName());
                                }
                            });
                            break;

                        case 6:
                            System.out.println("\nTotal de goles por equipo:");
                            equipos.forEach(equipo -> {
                                int totalGoles = equipo.getStatistics().stream()
                                        .mapToInt(estadisticas -> Integer.parseInt(estadisticas.getGf()))
                                        .sum();

                                System.out.printf("%s: %d goles a favor%n", equipo.getName(), totalGoles);
                            });
                            break;

                        case 7:
                            Main.main(null);
                            break;

                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Entrada no válida. Intente de nuevo.");
                    sc.nextLine(); 
                    opcion = 0; 
                } 
            } while (opcion != 7);

            sc.close();
        }
    }
}