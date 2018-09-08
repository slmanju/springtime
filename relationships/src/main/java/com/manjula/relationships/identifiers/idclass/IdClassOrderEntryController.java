package com.manjula.relationships.identifiers.idclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/identifiers/idclass")
public class IdClassOrderEntryController {

    @Autowired
    private IdClassOrderEntryRepository repository;

    @GetMapping("/order/{orderId}/{productId}/{quantity}")
    public void order(@PathVariable("orderId") Long orderId,
                      @PathVariable("productId") Long productId,
                      @PathVariable("quantity") int quantity) {
        IdClassOrderEntry entry = new IdClassOrderEntry();
        entry.setOrderId(orderId);
        entry.setProductId(productId);
        entry.setQuantity(quantity);

        repository.save(entry);
    }

    @GetMapping("/orders")
    public List<IdClassOrderEntry> findOrders() {
        return repository.findAll();
    }

}
