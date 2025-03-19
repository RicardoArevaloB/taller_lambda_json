# UEFA Champions League - Análisis de Equipos y Jugadores

## 📝 Descripción
Este proyecto es una aplicación Java que permite analizar datos de equipos y jugadores de la UEFA Champions League. Utiliza archivos JSON para almacenar la información y proporciona un menú interactivo para realizar consultas y análisis sobre los equipos y jugadores.

El proyecto incluye dos menús principales:
1. **Retos Propuestos**: Funcionalidades básicas como listar equipos fundados después del año 2000, mostrar el promedio de edad de los jugadores por equipo, y más.
2. **Retos Adicionales**: Funcionalidades avanzadas como listar jugadores de nacionalidad "Brasileño", agrupar jugadores por posición, y más.

---

## 🚀 Características
- **Menú Principal**: Permite elegir entre dos menús de opciones:
  1. **Retos Propuestos**:
     - Listar equipos fundados después del año 2000.
     - Listar los nombres de los entrenadores.
     - Calcular el promedio de edad de los jugadores por equipo.
     - Mostrar equipos con más de 20 victorias.
     - Encontrar el jugador más alto de cada equipo.
     - Calcular el total de goles por equipo.
  2. **Retos Adicionales**:
     - Listar equipos con más de 15 puntos en la fase de liga.
     - Calcular el promedio de goles a favor por equipo.
     - Mostrar el equipo con más victorias.
     - Encontrar el jugador más alto de todos los equipos.
     - Contar cuántos jugadores son delanteros.
     - Listar entrenadores de equipos que han empatado al menos un partido.
     - Crear un mapa de equipos y sus goles a favor.
     - Listar jugadores brasileños ordenados por edad.
     - Filtrar equipos cuyo entrenador tiene más de 10 caracteres en su nombre.
     - Determinar si algún equipo tiene más de 25 puntos.
     - Agrupar jugadores por posición y contar cuántos hay en cada una.
     - Obtener los equipos con más de 20 goles a favor ordenados de mayor a menor.

- **Manejo de Excepciones**: El programa maneja excepciones como `InputMismatchException` para evitar errores cuando el usuario ingresa valores no válidos.

- **Uso de Streams y Lambdas**: Utiliza la API de Streams de Java y expresiones lambda para filtrar, ordenar y procesar datos de manera eficiente.

---

## 🛠️ Tecnologías utilizadas
- **Java 17**: Lenguaje de programación principal.
- **Jackson**: Biblioteca para la serialización y deserialización de JSON.
- **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.
- **Stream API**: Para el procesamiento funcional de datos.
- **Scanner**: Para la entrada de datos desde la consola.

---

## 📌 Requisitos previos
Para ejecutar este proyecto, necesitas:
- **Java (JDK) 17.0.13 o superior**.
- **Maven** instalado.
- **Git** (opcional, para clonar el repositorio).
- **Visual Studio Code** (recomendado) con las extensiones:
  - **Debugger for Java**.
  - **Code Runner** (opcional).

---

## 📖 Uso
### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/tu-repositorio.git

## ✅ Abrir en Visual Studio Code

1. Abre **Visual Studio Code**.
2. Ve a **Archivo > Abrir carpeta** y selecciona la carpeta del proyecto.
3. Instala las extensiones **Debugger for Java** y **Code Runner** si aún no las tienes.

## ✅ Compilar y ejecutar el proyecto

1. Abre una terminal en la carpeta del proyecto.
2. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```
3. Ejecuta el programa:
   ```bash
   mvn exec:java -Dexec.mainClass="com.uefa.Main"
   ```

## ✅ Interactuar con la aplicación

El programa mostrará un menú principal con dos opciones:

- **Retos Propuestos**
- **Retos Adicionales**

Selecciona una opción y sigue las instrucciones en pantalla.

## 👤 Estructura del proyecto

```
- src/main/java/com/uefa          # Contiene la clase principal Main.java
- src/main/java/com/uefa/ui       # Contiene las clases de menú (MenuRetos.java, MenuAdicional.java)
- src/main/java/models            # Contiene las clases de modelo (Equipo.java, Jugador.java, Estadisticas.java, EquiposService.java)
- src/main/resources              # Contiene el archivo equipos.json con los datos de los equipos y jugadores
- pom.xml                         # Archivo de configuración de Maven
```

## 📷 Ejemplo de ejecución

### Menú Principal
```bash
--- Menú Principal ---
1. Retos Propuestos
2. Retos Adicionales
3. Salir
Seleccione una opción: 1
```

### Retos Propuestos
```bash
--- Menú ---
1. Listar equipos fundados después del año 2000
2. Listar los nombres de los entrenadores
3. Promedio de edad de los jugadores por equipo
4. Equipos con más de 20 victorias
5. Jugador más alto de cada equipo
6. Total de goles por equipo
7. Volver al menú principal
Seleccione una opción: 5
```

**Salida:**
```bash
Jugador más alto en cada equipo:
Real Madrid          : Thibaut Courtois (Altura: 199 cm)
FC Barcelona         : Gerard Piqué (Altura: 194 cm)
...
```

### Retos Adicionales
```bash
--- Nuevo Menú ---
1. Listar equipos con más de 15 puntos en la fase de liga
2. Obtener el promedio de goles a favor por equipo
3. Mostrar el equipo con más victorias
...
Seleccione una opción: 1
```

**Salida:**
```bash
Equipos con más de 15 puntos:
Real Madrid: 86 puntos
FC Barcelona: 79 puntos
...
```

👤
Hecho por [Ricardo Arevalo Boorquez](https://github.com/RicardoArevaloB)

[!NOTE]
Este es un proyecto hecho con fines educativos.


