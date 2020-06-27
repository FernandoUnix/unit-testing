package com.study.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.study.unittesting.model.Item;
import com.study.unittesting.repository.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testFindAll() {
		List<Item> items = itemRepository.findAll();
		assertEquals(3, items.size());
	}
}
