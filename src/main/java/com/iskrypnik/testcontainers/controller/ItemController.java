package com.iskrypnik.testcontainers.controller;

import com.iskrypnik.testcontainers.model.Item;
import com.iskrypnik.testcontainers.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        log.info("Incoming GET request for \"/item/{}\"", id);
        return itemService.getItemById(id);
    }
}
