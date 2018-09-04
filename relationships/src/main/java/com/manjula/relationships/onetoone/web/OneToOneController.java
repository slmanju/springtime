package com.manjula.relationships.onetoone.web;

import com.manjula.relationships.onetoone.domain.model.OneToOnePostDTO;
import com.manjula.relationships.onetoone.service.OneToOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onetoone")
public class OneToOneController {

    @Autowired
    private OneToOneService oneToOneService;

    @GetMapping("/posts")
    public List<OneToOnePostDTO> all() {
        return oneToOneService.findAll();
    }

    @GetMapping("/posts/{id}")
    public OneToOnePostDTO find(@PathVariable("id") Long id) {
        return oneToOneService.findById(id);
    }

    @GetMapping("/posts/details/{id}")
    public OneToOnePostDTO findDetails(@PathVariable("id") Long id) {
        return oneToOneService.findDetailedById(id);
    }

}
