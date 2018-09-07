package com.manjula.relationships.manytomany.service;

import com.manjula.relationships.manytomany.domain.model.ManyToManyPostDTO;
import com.manjula.relationships.manytomany.domain.model.ManyToManyTagDTO;

import java.util.List;

public interface ManyToManyService {

    List<ManyToManyPostDTO> findAllPosts();

    List<ManyToManyPostDTO> findAllDetailedPosts();

    List<ManyToManyTagDTO> findAllTags();

    ManyToManyPostDTO save(ManyToManyPostDTO post, Long tagId);

}
