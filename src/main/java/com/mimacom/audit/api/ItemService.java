package com.mimacom.audit.api;

import com.mimacom.audit.core.Item;
import com.mimacom.audit.core.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {
    final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void create(String value) {
        repository.save(new Item(value));
    }

    public List<Item> items() {
        return repository.findAll();
    }
}
