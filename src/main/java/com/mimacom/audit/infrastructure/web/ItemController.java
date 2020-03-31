package com.mimacom.audit.infrastructure.web;

import com.mimacom.audit.api.ItemService;
import com.mimacom.audit.core.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void createItem(@RequestBody String value) {
        service.create(value);
    }

    @GetMapping
    public List<Item> items() {
        return service.items();
    }
}
