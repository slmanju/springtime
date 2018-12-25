package com.slmanju.cache.simplecache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);
    
    private List<Item> items = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        items.add(new Item(1, "PC_1"));
        items.add(new Item(2, "PC_2"));
        items.add(new Item(3, "PC_3"));
        items.add(new Item(4, "PC_4"));
        items.add(new Item(5, "PC_5"));
    }
    
    @Cacheable(cacheNames = "allItemsCache")
    public List<Item> findAll() {
        LOGGER.info("Fetching all items");
        simulateTime();
        return items;
    }

    @Cacheable(cacheNames = "itemCache", key = "#id")
    public Item findById(int id) {
        LOGGER.info("Fetching item from repository");
        simulateTime();
        return items.stream().filter(item -> id == item.getId()).findAny().get();
    }
    
    @CachePut(cacheNames = "itemCache", key = "#id")
    public void update(int id, Item item) {
        items.stream()
            .filter(element -> id == element.getId())
            .forEach(selected -> selected.setCode(item.getCode()));
    }
    
    @CacheEvict(cacheNames = "itemCache", key = "#id")
    public void delete(int id) {
        items.removeIf(item -> id == item.getId());
    }

    @CachePut(cacheNames = "itemCache", key = "#item.id")
    public void save(Item item) {
        items.add(item);
    }
    
    private void simulateTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
