package com.manjula.relationships.selfreferencemany.service;

import com.manjula.relationships.selfreferencemany.domain.model.Twitter;
import com.manjula.relationships.selfreferencemany.domain.model.TwitterDTO;
import com.manjula.relationships.selfreferencemany.domain.repository.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private TwitterRepository twitterRepository;

    @PostConstruct
    public void init() {
        Twitter twitter1 = Twitter.instance("Ant Man");
        Twitter twitter2 = Twitter.instance("Thor");
        Twitter twitter3 = Twitter.instance("Wasp");
        Twitter twitter4 = Twitter.instance("Spider Man");
        Twitter twitter5 = Twitter.instance("Iron Man");

        twitterRepository.save(twitter1);
        twitterRepository.save(twitter2);
        twitterRepository.save(twitter3);
        twitterRepository.save(twitter4);
        twitterRepository.save(twitter5);
    }

    @Override
    public List<TwitterDTO> findAll() {
        return twitterRepository.findAll().stream().map(Twitter::toDto).collect(toList());
    }

    @Override
    public TwitterDTO findById(Long id) {
        return twitterRepository.findById(id).map(Twitter::toDto).orElse(null);
    }

    @Override
    public TwitterDTO follow(Long id, Long followingId) {
        Twitter twitter = twitterRepository.findById(id).get();
        Twitter twitterFollowing = twitterRepository.findById(followingId).get();
        twitter.addFollowing(twitterFollowing);
        return twitterRepository.save(twitter).toDto();
    }

    @Override
    public List<TwitterDTO> findFollowings(Long id) {
        return twitterRepository.findById(id)
                .map(twitter -> twitter.getFollowings()
                    .stream().map(Twitter::toDto)
                    .collect(toList()))
                .orElse(emptyList());
    }

    @Override
    public List<TwitterDTO> findFollowers(Long id) {
        return twitterRepository.findById(id)
                .map(twitter -> twitter.getFollowers()
                        .stream().map(Twitter::toDto)
                        .collect(toList()))
                .orElse(emptyList());
    }

}
