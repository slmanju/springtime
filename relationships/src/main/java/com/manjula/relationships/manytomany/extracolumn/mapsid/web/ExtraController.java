package com.manjula.relationships.manytomany.extracolumn.mapsid.web;

import com.manjula.relationships.manytomany.extracolumn.mapsid.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extra2")
public class ExtraController {

    @Autowired
    private ExtraService extraService;

    @GetMapping("/assign/{postId}/{tagId}")
    public void assign(@PathVariable("postId") Long postId,
                       @PathVariable("tagId") Long tagId) {
        extraService.assign(postId, tagId);
    }

}
