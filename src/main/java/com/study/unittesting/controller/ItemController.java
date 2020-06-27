package com.study.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.unittesting.model.Item;
import com.study.unittesting.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-service")
	public Item itemFromService() {
		return itemService.returnHardCodedItem();
	}

	@GetMapping("/all-itens-from-service")
	public List<Item> retrieveAllItens() {
		return itemService.retrieveAllItens();
	}
}
