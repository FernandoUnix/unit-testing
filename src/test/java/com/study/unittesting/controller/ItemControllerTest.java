package com.study.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.study.unittesting.model.Item;
import com.study.unittesting.service.ItemService;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemService itemService;
	
	@Test
	public void item_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantidade\":100}"))
				.andReturn();

	}
	
	@Test
	public void itemFromService_basic() throws Exception {

		when(itemService.returnHardCodedItem()).thenReturn(new Item(1,"Ball", 10,100));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-service")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantidade\":100}"))
				.andReturn();

	}
	
	@Test
	public void itemFromServiceDataBase_basic() throws Exception {

		when(itemService.retrieveAllItens()).thenReturn(
				Arrays.asList(
				new Item(1,"Ball", 10,100),
						new Item(2, "Ball 2", 15, 110))
				);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/all-itens-from-service")
				.accept(MediaType.APPLICATION_JSON);
		
		String item1 = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantidade\":100},";
		String item2 = "{\"id\":2,\"name\":\"Ball 2\",\"price\":15,\"quantidade\":110}";
		
		mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("["+ item1.concat(item2)+"]"))
				.andReturn();

	}
	
}