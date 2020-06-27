package com.study.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.study.unittesting.data.SomeDataService;
import com.study.unittesting.model.Item;
import com.study.unittesting.repository.ItemRepository;
import com.study.unittesting.service.ItemService;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessMockTest {

	@InjectMocks
	private ItemService itemService;

	@Mock
	private ItemRepository itemRepository;

	@Test
	public void calculateSumUsingDataService_basic() {

		when(itemRepository.findAll())
				.thenReturn(Arrays.asList(new Item(1, "Ball", 10, 100), new Item(2, "Ball 2", 15, 110)));

		List<Item> items = itemService.retrieveAllItens();

		assertEquals(1000, items.get(0).getValue());
		assertEquals(1650, items.get(1).getValue());
	}
}
