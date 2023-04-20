
# CalculatorService 
Calculadora como micro-servicio desarrollado con Spring-boot y Maven con las funcionalidades de sumar y restar.

Api rest del recurso de acceso es un GET /resources/calculate?firstNumber= & secondNumber= & mathOperation= 

1. Descargar el repositorio de github https://github.com/soniagilp/PocCalculator
2. Desde consola ejecutar mvn validate
3. Desde consola ejecutar mvn verify
4. Desde consola ejecutar mvn clean install(contiene libreria tracer)
5. Ejecutar el JAR de la carpeta /target 'CalculatorService-spring-boot.jar' con java -jar target/CalculatorService-spring-boot.jar

Ejemplo:

GET http://localhost:8080/resources/calculate?firstNumber=10&secondNumber=9&mathOperation=suma

Resultado 19.0

6. Desde consola ejecutar los test con mvn clean test
