package com.manjula.relationships.manytomany.web;

import com.manjula.relationships.manytomany.domain.model.ManyToManyPostDTO;
import com.manjula.relationships.manytomany.domain.model.ManyToManyTagDTO;
import com.manjula.relationships.manytomany.service.ManyToManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manytomany")
public class ManyToManyController {

    @Autowired
    private ManyToManyService manyToManyService;

    @GetMapping("/posts")
    public List<ManyToManyPostDTO> all() {
        return manyToManyService.findAllPosts();
    }

    @GetMapping("/posts/detailed")
    public List<ManyToManyPostDTO> allDetailed() {
        return manyToManyService.findAllDetailedPosts();
    }

    @GetMapping("/tags")
    public List<ManyToManyTagDTO> allTags() {
        return manyToManyService.findAllTags();
    }

    @GetMapping("/save/{title}/{id}")
    public ManyToManyPostDTO save(@PathVariable("title") String title, @PathVariable("id") Long id) {
        return manyToManyService.save(ManyToManyPostDTO.builder().title(title).build(), id);
    }

}
