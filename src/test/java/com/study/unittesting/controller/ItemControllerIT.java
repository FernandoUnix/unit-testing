package com.study.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-itens-from-service", String.class);
		JSONAssert.assertEquals("[{\"id\":1,\"name\":\"item 1\",\"price\":10,\"value\":200,\"quantidade\":20},{\"id\":2,\"name\":\"item 2\",\"price\":12,\"value\":264,\"quantidade\":22},{\"id\":3,\"name\":\"item 3\",\"price\":15,\"value\":375,\"quantidade\":25}]", response, true);
	}
}
