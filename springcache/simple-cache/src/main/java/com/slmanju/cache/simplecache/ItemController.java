package com.slmanju.cache.simplecache;

import java.util.List;

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
    
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
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
