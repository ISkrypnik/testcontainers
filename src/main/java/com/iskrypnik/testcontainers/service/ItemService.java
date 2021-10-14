package com.iskrypnik.testcontainers.service;

import com.iskrypnik.testcontainers.exception.ItemNotFoundException;
import com.iskrypnik.testcontainers.model.Item;
import com.iskrypnik.testcontainers.repository.ItemRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public Item getItemById(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException();
        }
    }
}
