package com.uefa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uefa.ui.MenuAdicional;
import com.uefa.ui.MenuRetos;

import models.Equipo;
import models.EquiposService;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lee el archivo JSON y deserialízalo en un objeto EquiposService
            EquiposService data = mapper.readValue(
                new File("src/main/resources/equipos.json"),
                EquiposService.class
            );

            // Obtén la lista de equipos
            List<Equipo> equipos = data.getEquipos();

            // Crear una instancia de MenuRetos y MenuAdicional
            MenuRetos menuRetos = new MenuRetos(equipos);
            MenuAdicional menuAdicional = new MenuAdicional(equipos);

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

                try {
                    opcion = scanner.nextInt(); // Leer la opción del usuario
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    switch (opcion) {
                        case 1:
                            menuRetos.mostrarMenuRetosPropuestos();
                            break;
                        case 2:
                            menuAdicional.mostrarMenuNuevo();
                            break;
                        case 3:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un número válido. Intente de nuevo.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    opcion = 0; // Reiniciar la opción para evitar un bucle infinito
                }

            } while (opcion != 3);

            // Cerrar el scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}