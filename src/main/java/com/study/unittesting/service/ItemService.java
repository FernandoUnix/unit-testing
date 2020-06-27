package com.study.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.unittesting.model.Item;
import com.study.unittesting.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public Item returnHardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItens() {
		List<Item> items = itemRepository.findAll();
		
		for(Item item : items) {
			item.setValue(item.getPrice() * item.getQuantidade());
		}
		
		return items;
	}
}
