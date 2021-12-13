# Tipo cambio service

El proyecto contiene de dos POST en la cual uno realiza el calculo de un tipo de cambio el otro POST devuelve el nuevo valor del monto de tipo de cambio

##  Temas
- H2 database
- Javax validation
- Lombok
- rxjava
- Spring Boot 2.6.1
- Docker
## Instalación
Ejecutar los siguientes comandos
`'mvn clean'`       
 `'mvn install'`    
## Despligue
Ejecutar
 `'mvn spring-boot:run'`  
## Puntos finales de la API
Hay un archivo JSON  `'EnpointBanco.postman_collection.json'`     para importar al Postman

. POST: Para calcular el tipo de cambio
`'http://localhost:8080/api/calcular'`    

.POST: Para actualizar el tipo de cambio
`'http://localhost:8080/api/actualizar'`  

