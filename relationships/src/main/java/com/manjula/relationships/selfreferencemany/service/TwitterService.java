package com.manjula.relationships.selfreferencemany.service;

import com.manjula.relationships.selfreferencemany.domain.model.TwitterDTO;

import java.util.List;

public interface TwitterService {

    List<TwitterDTO> findAll();

    TwitterDTO findById(Long id);

    TwitterDTO follow(Long id, Long followingId);

    List<TwitterDTO> findFollowings(Long id);

    List<TwitterDTO> findFollowers(Long id);

}
