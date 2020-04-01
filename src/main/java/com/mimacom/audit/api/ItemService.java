package com.mimacom.audit.api;

import com.mimacom.audit.core.delegate.DelItem;
import com.mimacom.audit.core.delegate.DelegateItemRepository;
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
    final DelegateItemRepository delegateItemRepository;

    public ItemService(ItemRepository itemRepository, HierarchyItemRepository hierarchyItemRepository, DelegateItemRepository delegateItemRepository) {
        this.itemRepository = itemRepository;
        this.hierarchyItemRepository = hierarchyItemRepository;
        this.delegateItemRepository = delegateItemRepository;
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

    public String createDel(String value) {
        return delegateItemRepository.save(new DelItem(value)).getId();
    }

    public List<DelItem> dels() {
        return delegateItemRepository.findAll();
    }

    public void updateDel(String id, String value) {
        Optional<DelItem> byId = delegateItemRepository.findById(id);
        byId.ifPresent(item -> item.setValue(value));
    }
}
