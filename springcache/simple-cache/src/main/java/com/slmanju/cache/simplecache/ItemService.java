package com.slmanju.cache.simplecache;

import java.util.List;

public interface ItemService {
    
    List<Item> findAll();

    Item findById(int id);
    
    void update(int id, Item item);
    
    void delete(int id);

    void save(Item item);

}
