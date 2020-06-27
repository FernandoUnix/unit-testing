package com.study.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
