package space.srikanth.heyhere;

// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ColourControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private transient TestRestTemplate restTemplate;

	@Test
	public void testIndex() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/").toString(), String.class);
			assertNotNull(response.getBody());
	}

	@Test
	public void testHereDefault() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/here").toString(), String.class);
			assertTrue(response.getBody().contains("#ffffff"));
	}

	@Test
	public void testHereParams() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/here?colour=ffff00").toString(), String.class);
			assertTrue(response.getBody().contains("#ffff00"));
	}

}
