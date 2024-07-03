# ms-travel-route

Este proyecto implementa un servicio restful para la optimización de rutas de viaje entre estaciones, minimizando costos. Permite gestionar estaciones y caminos, y encontrar el camino óptimo entre dos estaciones dadas.

## Funcionalidades

- **Estaciones (`/stations/`)**:
    - `PUT /stations/{station_id}`: Crea una nueva estación con un Id específico.

- **Caminos (`/paths/`)**:
    - `PUT /paths/{path_id}`: Crea un nuevo camino entre dos estaciones con un costo específico.
    - `GET /paths/{source_id}/{destination_id}`: Encuentra el camino más corto entre dos estaciones, minimizando costos.

## Instalación y ejecución

### Requisitos previos

- Java 17 instalado
- Maven instalado
- Docker (ejecución con contenedores)

### Pasos para ejecutar el proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/.../ms-travel-route.git
   cd ms-travel-route
   
2. Prepara el proyecto
    
    ```bash
   mvn clean package

3. Ejecuta el proyecto
    
    ```bash
   java -jar target/ms-travel-route-0.0.1-SNAPSHOT.jar

### Pasos levantar imagen Docker

1. Construye la imagen de Docker

    ```bash
   docker build -t ms-travel-route .

2. Ejecuta el contenedor

    ```bash
   docker run -p 8080:8080 ms-travel-route

