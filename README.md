# UEFA Champions League - Análisis de Equipos y Jugadores

Este proyecto es una aplicación Java que permite analizar datos de equipos y jugadores de la UEFA Champions League. Utiliza archivos JSON para almacenar la información y proporciona un menú interactivo para realizar consultas y análisis sobre los equipos y jugadores.

## Características

- **Menú Principal**: Permite elegir entre dos menús de opciones:
  1. **Retos Propuestos**: Incluye funcionalidades básicas como listar equipos fundados después del año 2000, mostrar el promedio de edad de los jugadores por equipo, y más.
  2. **Retos Adicionales**: Incluye funcionalidades avanzadas como listar jugadores de nacionalidad "Brasileño", agrupar jugadores por posición, y más.

- **Manejo de Excepciones**: El programa maneja excepciones como `InputMismatchException` para evitar errores cuando el usuario ingresa valores no válidos.

- **Uso de Streams y Lambdas**: Utiliza la API de Streams de Java y expresiones lambda para filtrar, ordenar y procesar datos de manera eficiente.

## Requisitos

- **Java 17**: Asegúrate de tener Java 17 instalado en tu sistema.
- **Maven**: El proyecto utiliza Maven para la gestión de dependencias.

## Configuración

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
