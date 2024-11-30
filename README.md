Screenmatch
Screenmatch es una aplicación desarrollada en Java que permite gestionar y evaluar episodios y contenidos multimedia. Está diseñada como una herramienta educativa para aprender a manejar flujos de datos, validaciones y transformaciones utilizando Streams y otros conceptos avanzados de Java.
________________________________________
Características principales
1.	Gestión de Episodios
o	Permite registrar y listar episodios de series o contenidos.
o	Asigna evaluaciones numéricas a los episodios.
o	Gestiona datos no válidos como "N/A" y asigna valores predeterminados.
2.	Validación robusta de datos
o	Comprueba que los datos de entrada sean válidos antes de procesarlos.
o	Maneja excepciones para evitar fallos inesperados durante la ejecución.
3.	Uso de Streams
o	Implementa operaciones avanzadas como filtrado, ordenamiento y transformación de datos mediante Streams.
4.	Arquitectura moderna
o	Basada en Spring Boot para aprovechar la escalabilidad y robustez del framework.
________________________________________
Requisitos
•	Java 17 o superior
•	Maven 3.6+ (opcional para gestión de dependencias)
•	Spring Boot 3.3.5
•	Un entorno de desarrollo como IntelliJ IDEA, Eclipse, o Visual Studio Code.
________________________________________


Instalación y configuración
1.	Clona el repositorio
2.	
git clone https://github.com/tuusuario/screenmatch.git
cd screenmatch


3.	Construye el proyecto
Usa Maven para compilar:
mvn clean install

4.	Ejecuta la aplicación

java -jar target/screenmatch-1.0.jar


5.	Accede al menú
Sigue las instrucciones en la consola para interactuar con la aplicación.
________________________________________




Estructura del proyecto
css


src/
├── main/

│   ├── java/

│   │   ├── com.aluracursos.screenmatch/

│   │   │   ├── ScreeenmatchApplication.java

│   │   │   ├── model/

│   │   │   │   ├── Episodio.java

│   │   │   ├── principal/

│   │   │       ├── Principal.java

│   ├── resources/

│       ├── application.properties

________________________________________
Uso
1.	Añadir episodios
Sigue el flujo del menú para agregar episodios y proporcionar evaluaciones.
2.	Ver evaluaciones y episodios
Usa las opciones del menú para listar episodios y filtrar los mejores evaluados.
3.	Manejo de excepciones
Si un episodio tiene una evaluación inválida ("N/A", null o vacía), el sistema asignará automáticamente un valor predeterminado de 0.0.
________________________________________
Desarrollo
Tecnologías utilizadas
•	Java 17: Lenguaje de programación principal.
•	Spring Boot: Framework para la creación de aplicaciones robustas.
•	Streams de Java: Para operaciones avanzadas sobre colecciones.
•	Maven: Gestión de dependencias.
________________________________________




Contribuciones
¡Contribuciones son bienvenidas! Si tienes ideas para mejorar esta aplicación, por favor abre un issue o crea un pull request.
1.	Haz un fork del proyecto.
2.	Crea una rama para tu nueva funcionalidad:
bash
Copiar código
git checkout -b feature/nueva-funcionalidad
3.	Realiza los cambios y envíalos:
bash
Copiar código
git commit -m "Agrego nueva funcionalidad"
git push origin feature/nueva-funcionalidad


________________________________________
Autor
Cristian Andrés Godoy Angel
Desarrollador Java y estudiante de Alura Latam, auspiciado por Oracle.


________________________________________
Licencia
Este proyecto está licenciado bajo los términos de la MIT License.
________________________________________
Contacto
¿Tienes preguntas o comentarios?
📧 creacciones@gmail.com
🌐 https://www.linkedin.com/in/cristian-godoy-angel/
________________________________________
¡Gracias por usar Screenmatch! 🎥✨

