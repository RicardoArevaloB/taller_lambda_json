package com.uefa.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.Equipo;
import models.Jugador;

public class MenuAdicional {
    private List<Equipo> equipos;

    public MenuAdicional(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void mostrarMenuNuevo() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                // Mostrar el menú
                System.out.println("\n--- Nuevo Menú ---");
                System.out.println("1. Listar equipos con más de 15 puntos en la fase de liga");
                System.out.println("2. Obtener el promedio de goles a favor por equipo");
                System.out.println("3. Mostrar el equipo con más victorias");
                System.out.println("4. Jugador más alto de todos los equipos");
                System.out.println("5. Jugadores son delanteros en toda la UEFA Champions League");
                System.out.println("6. Listar entrenadores que han empatado al menos un partido");
                System.out.println("7. Listar equipos y la cantidad total de goles a favor");
                System.out.println("8. Listar jugadores Brasileños ordenados por edad");
                System.out.println("9. Entrenador con más de 10 caracteres en su nombre");
                System.out.println("10. Determinar si algún equipo tiene más de 25 puntos");
                System.out.println("11. Agrupar los jugadores por posición y contar cuántos hay en cada una");
                System.out.println("12. Obtener los equipos con más de 20 goles a favor ordenados de mayor a menor");
                System.out.println("13. Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                try {
                    opcion = sc.nextInt();
                    sc.nextLine(); 

                    switch (opcion) {
                        case 1:
                            // Predicate para filtrar equipos con más de 15 puntos
                            Predicate<Equipo> masDe15Puntos = equipo -> {
                                int puntos = Integer.parseInt(equipo.getStatistics().get(0).getTp());
                                return puntos > 15;
                            };

                            // Filtrar y mostrar equipos
                            List<Equipo> equiposConMas15Puntos = equipos.stream()
                                    .filter(masDe15Puntos)
                                    .collect(Collectors.toList());

                            System.out.println("\nEquipos con más de 15 puntos:");
                            equiposConMas15Puntos.forEach(equipo -> System.out
                                    .println(equipo.getName() + " con: " + equipo.getStatistics().get(0).getTp() + " puntos"));
                            break;

                        case 2:
                            // Calcular el promedio de goles a favor (gf) de todos los equipos
                            double promedioGoles = equipos.stream()
                                    .mapToInt(equipo -> Integer.parseInt(equipo.getStatistics().get(0).getGf()))
                                    .average()
                                    .orElse(0);

                            System.out.printf("\nPromedio de goles a favor por equipo: %.2f%n", promedioGoles);
                            break;

                        case 3:
                            // Encontrar el equipo con más victorias (pg)
                            Equipo equipoConMasVictorias = equipos.stream()
                                    .max((e1, e2) -> Integer.compare(
                                            Integer.parseInt(e1.getStatistics().get(0).getPg()),
                                            Integer.parseInt(e2.getStatistics().get(0).getPg())))
                                    .orElse(null);

                            if (equipoConMasVictorias != null) {
                                System.out.printf("\nEquipo con más victorias: %s (%s victorias)%n",
                                        equipoConMasVictorias.getName(),
                                        equipoConMasVictorias.getStatistics().get(0).getPg());
                            } else {
                                System.out.println("\nNo se encontraron equipos.");
                            }
                            break;

                        case 4:
                            Jugador jugadorMasAlto = equipos.stream()
                                    .flatMap(equipo -> equipo.getPlayers().stream())
                                    .max((j1, j2) -> Integer.compare(
                                            Integer.parseInt(j1.getHeight()),
                                            Integer.parseInt(j2.getHeight())))
                                    .orElse(null);

                            if (jugadorMasAlto != null) {
                                System.out.printf("\nJugador más alto: %s (Altura: %s cm)%n",
                                        jugadorMasAlto.getName(),
                                        jugadorMasAlto.getHeight());
                            } else {
                                System.out.println("\nNo se encontraron jugadores.");
                            }
                            break;

                        case 5:
                            long totalDelanteros = equipos.stream()
                                    .flatMap(equipo -> equipo.getPlayers().stream())
                                    .filter(jugador -> jugador.getPosition().equalsIgnoreCase("Delantero"))
                                    .count();

                            System.out.printf("\nTotal de delanteros en la UEFA Champions League: %d%n", totalDelanteros);
                            break;

                        case 6:
                            List<String> entrenadoresConEmpates = equipos.stream()
                                    .filter(equipo -> Integer.parseInt(equipo.getStatistics().get(0).getPe()) > 0)
                                    .map(Equipo::getCoach)
                                    .collect(Collectors.toList());

                            System.out.println("\nEntrenadores de equipos que han empatado al menos un partido:");
                            entrenadoresConEmpates.forEach(System.out::println);
                            break;

                        case 7:
                            Map<String, Integer> golesPorEquipo = equipos.stream()
                                    .collect(Collectors.toMap(
                                            Equipo::getName,
                                            equipo -> Integer.parseInt(equipo.getStatistics().get(0).getGf())));

                            System.out.println("\nMap de equipos y goles a favor:");
                            golesPorEquipo.forEach((nombre, goles) -> System.out.printf("%s: %d goles%n", nombre, goles));
                            break;

                        case 8:
                            
                            List<Jugador> jugadoresBrasileños = equipos.stream()
                                    .flatMap(equipo -> equipo.getPlayers().stream())
                                    .filter(jugador -> jugador.getNationality().equalsIgnoreCase("Brasileño"))
                                    .sorted((j1, j2) -> Integer.compare(
                                            Integer.parseInt(j1.getAge()),
                                            Integer.parseInt(j2.getAge())))
                                    .collect(Collectors.toList());

                            System.out.println("\nJugadores brasileños ordenados por edad:");
                            jugadoresBrasileños.forEach(jugador -> System.out.printf("%s (Edad: %s)%n",
                                    jugador.getName(), jugador.getAge()));
                            break;

                        case 9:
                            
                            Predicate<Equipo> entrenadorMasDe10Caracteres = equipo -> equipo.getCoach().length() > 10;

                            List<Equipo> equiposFiltrados = equipos.stream()
                                    .filter(entrenadorMasDe10Caracteres)
                                    .collect(Collectors.toList());

                            System.out.println("\nEquipos cuyo entrenador tiene más de 10 caracteres en su nombre:");
                            equiposFiltrados.forEach(equipo -> System.out.println(equipo.getName() + " - Entrenador: " + equipo.getCoach()));
                            break;

                        case 10:
                            
                            boolean algunEquipoConMasDe25Puntos = equipos.stream()
                                    .anyMatch(equipo -> Integer.parseInt(equipo.getStatistics().get(0).getTp()) > 25);

                            System.out.println("\n¿Algún equipo tiene más de 25 puntos? " + (algunEquipoConMasDe25Puntos ? "Sí" : "No"));
                            break;

                        case 11:
                            
                            Map<String, Long> jugadoresPorPosicion = equipos.stream()
                                    .flatMap(equipo -> equipo.getPlayers().stream())
                                    .collect(Collectors.groupingBy(
                                            Jugador::getPosition,
                                            Collectors.counting()));

                            System.out.println("\nJugadores por posición:");
                            jugadoresPorPosicion.forEach((posicion, cantidad) -> System.out.printf("%s: %d%n", posicion, cantidad));
                            break;

                        case 12:
                            List<Equipo> equiposConMasDe20Goles = equipos.stream()
                                    .filter(equipo -> Integer.parseInt(equipo.getStatistics().get(0).getGf()) > 20)
                                    .sorted((e1, e2) -> Integer.compare(
                                            Integer.parseInt(e2.getStatistics().get(0).getGf()),
                                            Integer.parseInt(e1.getStatistics().get(0).getGf())))
                                    .collect(Collectors.toList());

                            System.out.println("\nEquipos con más de 20 goles a favor (ordenados de mayor a menor):");
                            equiposConMasDe20Goles.forEach(equipo -> System.out.printf("%s: %d goles%n",
                                    equipo.getName(), Integer.parseInt(equipo.getStatistics().get(0).getGf())));
                            break;

                        case 13:
                            System.out.println("Volviendo al menú principal...");
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
            } while (opcion != 13);

            sc.close();
        }
    }
}