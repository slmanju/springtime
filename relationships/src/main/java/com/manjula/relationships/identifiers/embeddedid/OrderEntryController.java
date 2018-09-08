package com.manjula.relationships.identifiers.embeddedid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/identifiers/embedded")
public class OrderEntryController {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    @GetMapping("/order/{orderId}/{productId}/{quantity}")
    public void order(@PathVariable("orderId") Long orderId,
                      @PathVariable("productId") Long productId,
                      @PathVariable("quantity") int quantity) {
        OrderEntryId id = new OrderEntryId();
        id.setOrderId(orderId);
        id.setProductId(productId);

        OrderEntry entry = new OrderEntry();
        entry.setId(id);
        entry.setQuantity(quantity);

        orderEntryRepository.save(entry);
    }

    @GetMapping("/orders")
    public List<OrderEntry> findOrders() {
        return orderEntryRepository.findAll();
    }

}
