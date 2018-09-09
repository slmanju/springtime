package com.manjula.relationships.manytomany.linkentity.web;

import com.manjula.relationships.manytomany.linkentity.service.ManyToManyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manytomany/link")
public class ManyToManyLinkController {

    @Autowired
    private ManyToManyLinkService linkService;

    @GetMapping("/link/{personId}/{addressId}")
    public void link(@PathVariable("personId") Long personId,
                     @PathVariable("addressId") Long addressId) {
        linkService.link(personId, addressId);
    }

}
