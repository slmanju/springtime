package com.slmanju.springcache.hazlecast;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;
    
    @Autowired
    private CacheManager cacheManager;
    
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/cache")
    public void cache() {
        System.out.println("---------------------->");
        cacheManager.getCacheNames().forEach(name -> {
            System.out.println(name);
            System.out.println(cacheManager.getCache(name));
            ConcurrentMapCache cache = (ConcurrentMapCache) cacheManager.getCache(name);
            for (Entry<Object, Object> value : cache.getNativeCache().entrySet()) {
                System.out.println("key " + value.getKey());
                System.out.println("Value " + value.getValue());
            }
            System.out.println("+----------------------+\n");
        });
        System.out.println("<----------------------");
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Item> save(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable("id") int id, @RequestBody Item item) {
        itemService.update(id, item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
