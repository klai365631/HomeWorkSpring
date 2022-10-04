package com.skypro.homeworkspring.Service;

import com.skypro.homeworkspring.component.Basket;
import com.skypro.homeworkspring.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class StoreService {
    private final Basket basket;
    private final Map<Integer, Item> items;


    public StoreService(Basket basket) {
        this.basket = basket;
        this.items = Map.of(
                1, new Item(1, "Книга", 35),
                2, new Item(2, "Ноутбук", 70000),
                3, new Item(3, "Iphone", 40000)
        );
    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()));

    }

    public List<Item> get() {
        return basket.get();
    }
}
