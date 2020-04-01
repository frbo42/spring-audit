package com.mimacom.audit.infrastructure.web;

import com.mimacom.audit.api.ItemService;
import com.mimacom.audit.core.composition.CompositionItem;
import com.mimacom.audit.core.hierachy.HierarchyItem;
import com.mimacom.audit.core.plain.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping(value = "/plain", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void createItem(@RequestBody String value) {
        service.createPlain(value);
    }

    @GetMapping(value = "/plain")
    public List<Item> items() {
        return service.plains();
    }

    @PostMapping(value = "/hierarchy", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void createSub(@RequestBody String value) {
        service.createHierarchy(value);
    }

    @GetMapping(value = "/hierarchy")
    public List<HierarchyItem> subs() {
        return service.hierarchies();
    }


    @PostMapping(value = "/composition", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createDel(@RequestBody String value) {
        return service.createComposition(value);
    }

    @GetMapping(value = "/composition")
    public List<CompositionItem> dels() {
        return service.compositions();
    }

    @PatchMapping(value = "/composition/{id}")
    public void updateDel(@PathVariable("id") String id, @RequestBody String value) {
        service.updateComposition(id, value);
    }
}