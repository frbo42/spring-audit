package com.mimacom.audit.api;

import com.mimacom.audit.core.composition.CompositionItem;
import com.mimacom.audit.core.composition.CompositionItemRepository;
import com.mimacom.audit.core.hierachy.HierarchyItem;
import com.mimacom.audit.core.hierachy.HierarchyItemRepository;
import com.mimacom.audit.core.plain.Item;
import com.mimacom.audit.core.plain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {
    final ItemRepository itemRepository;
    final HierarchyItemRepository hierarchyItemRepository;
    final CompositionItemRepository compositionItemRepository;

    public ItemService(ItemRepository itemRepository, HierarchyItemRepository hierarchyItemRepository, CompositionItemRepository compositionItemRepository) {
        this.itemRepository = itemRepository;
        this.hierarchyItemRepository = hierarchyItemRepository;
        this.compositionItemRepository = compositionItemRepository;
    }

    public void createPlain(String value) {
        itemRepository.save(new Item(value));
    }

    public List<Item> plains() {
        return itemRepository.findAll();
    }

    public void createHierarchy(String value) {
        hierarchyItemRepository.save(new HierarchyItem(value));
    }

    public List<HierarchyItem> hierarchies() {
        return hierarchyItemRepository.findAll();
    }

    public String createComposition(String value) {
        return compositionItemRepository.save(new CompositionItem(value)).getId();
    }

    public List<CompositionItem> compositions() {
        return compositionItemRepository.findAll();
    }

    public void updateComposition(String id, String value) {
        Optional<CompositionItem> byId = compositionItemRepository.findById(id);
        byId.ifPresent(item -> item.setValue(value));
    }
}
