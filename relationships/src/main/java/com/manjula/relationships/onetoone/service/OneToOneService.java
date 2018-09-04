package com.manjula.relationships.onetoone.service;

import com.manjula.relationships.onetoone.domain.model.OneToOnePostDTO;

import java.util.List;

public interface OneToOneService {

    List<OneToOnePostDTO> findAll();

    OneToOnePostDTO findById(Long id);

    OneToOnePostDTO findDetailedById(Long id);

}
