package com.uefa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uefa.ui.MenuRetos;

import models.Equipo;
import models.EquiposService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lee el archivo JSON y deserialízalo en un objeto EquiposData
            EquiposService data = mapper.readValue(
                new File("src/main/resources/equipos.json"),
                EquiposService.class
            );

            // Obtén la lista de equipos
            List<Equipo> equipos = data.getEquipos();

            // Crear una instancia de MenuRetos
            MenuRetos menuRetos = new MenuRetos(equipos);

            // Scanner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                // Mostrar el menú principal
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Retos Propuestos");
                System.out.println("2. Retos Adicionales");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        menuRetos.mostrarMenuRetosPropuestos();
                        break;
                    case 2:
                        //menuRetos.mostrarMenuRetosAdicionales();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 3);

            // Cerrar el scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}