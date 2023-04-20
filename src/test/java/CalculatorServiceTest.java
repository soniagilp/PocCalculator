import com.poc.AppConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.boot.web.server.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorServiceTest {
    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<Double> calculate(double firstNumber, double secondNumber, String mathOperation) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/resources/calculate?firstNumber=" + firstNumber +
                "&secondNumber=" + secondNumber + "&mathOperation=" + mathOperation;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> resultado = restTemplate.getForEntity(uri, Double.class);
        return resultado;
    }

    @Test
    public void sumTestOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(100, 200, "suma");

        Assert.assertEquals(300.0d, resultado.getBody().doubleValue(), 0.001d);
        Assert.assertEquals(200, resultado.getStatusCodeValue());
    }

    @Test
    public void subtractionTestOk() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculate(100, 200, "resta");

        Assert.assertEquals(-100.0d, resultado.getBody().doubleValue(), 0.001d);
        Assert.assertEquals(200, resultado.getStatusCodeValue());
    }
   
    
}