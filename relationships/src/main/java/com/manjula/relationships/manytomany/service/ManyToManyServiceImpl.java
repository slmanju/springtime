package com.manjula.relationships.manytomany.service;

import com.manjula.relationships.manytomany.domain.model.ManyToManyPost;
import com.manjula.relationships.manytomany.domain.model.ManyToManyPostDTO;
import com.manjula.relationships.manytomany.domain.model.ManyToManyTag;
import com.manjula.relationships.manytomany.domain.model.ManyToManyTagDTO;
import com.manjula.relationships.manytomany.domain.repository.ManyToManyPostRepository;
import com.manjula.relationships.manytomany.domain.repository.ManyToManyTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ManyToManyServiceImpl implements ManyToManyService {

    @Autowired
    private ManyToManyPostRepository manyToManyPostRepository;
    @Autowired
    private ManyToManyTagRepository manyToManyTagRepository;

    @Transactional
    @PostConstruct
    public void init() {
        ManyToManyPost post1 = ManyToManyPost.instance("Hibernate for idiots");
        ManyToManyPost post2 = ManyToManyPost.instance("Spring met Hibernate");

        ManyToManyTag tag1 = ManyToManyTag.instance("Java");
        ManyToManyTag tag2 = ManyToManyTag.instance("Hibernate");
        ManyToManyTag tag3 = ManyToManyTag.instance("Spring");

//        tag1 = manyToManyTagRepository.save(tag1);
//        tag2 = manyToManyTagRepository.save(tag2);
//        tag3 = manyToManyTagRepository.save(tag3);

        post1.addTag(tag1);
        post1.addTag(tag2);

        post2.addTag(tag3);

        manyToManyPostRepository.save(post1);
        manyToManyPostRepository.save(post2);
    }

    @Override
    public List<ManyToManyPostDTO> findAllPosts() {
        return manyToManyPostRepository.findAll().stream().map(ManyToManyPost::toDto).collect(toList());
    }

    @Override
    public List<ManyToManyPostDTO> findAllDetailedPosts() {
        return manyToManyPostRepository.findAll().stream().map(ManyToManyPost::toDetailedDto).collect(toList());
    }

    @Override
    public List<ManyToManyTagDTO> findAllTags() {
        return manyToManyTagRepository.findAll().stream().map(ManyToManyTag::toDto).collect(toList());
    }

    @Override
    public ManyToManyPostDTO save(ManyToManyPostDTO postDTO, Long tagId) {
        ManyToManyTag tag = manyToManyTagRepository.findById(tagId).get();
        ManyToManyPost post = ManyToManyPost.instance(postDTO.getTitle());
        post.addTag(tag);
        post = manyToManyPostRepository.save(post);
        return post.toDetailedDto();
    }

}
