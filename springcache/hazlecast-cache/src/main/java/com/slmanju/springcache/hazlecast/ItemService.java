package com.slmanju.springcache.hazlecast;

import java.util.List;

public interface ItemService {
    
    List<Item> findAll();

    Item findById(int id);
    
    Item update(int id, Item item);
    
    void delete(int id);

    Item save(Item item);

}
