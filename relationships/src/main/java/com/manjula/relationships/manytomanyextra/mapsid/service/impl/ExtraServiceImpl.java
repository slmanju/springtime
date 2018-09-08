package com.manjula.relationships.manytomanyextra.mapsid.service.impl;

import com.manjula.relationships.manytomanyextra.mapsid.domain.model.Post;
import com.manjula.relationships.manytomanyextra.mapsid.domain.model.Tag;
import com.manjula.relationships.manytomanyextra.mapsid.domain.repository.PostRepository;
import com.manjula.relationships.manytomanyextra.mapsid.domain.repository.TagRepository;
import com.manjula.relationships.manytomanyextra.mapsid.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class ExtraServiceImpl implements ExtraService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;

    @PostConstruct
    public void init() {
        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Spring");
        Tag tag3 = new Tag("Hibernate");

        tagRepository.save(tag1);
        tagRepository.save(tag2);
        tagRepository.save(tag3);

        Post post1 = new Post("Hibernate in action");
        Post post2 = new Post("Spring in action");

        postRepository.save(post1);
        postRepository.save(post2);
    }

    @Override
    public void assign(Long postId, Long tagId) {
        Post post = postRepository.findById(postId).get();
        Tag tag = tagRepository.findById(tagId).get();

        post.addTag(tag);

        postRepository.save(post);
    }

}
