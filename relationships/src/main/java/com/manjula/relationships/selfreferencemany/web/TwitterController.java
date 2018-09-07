package com.manjula.relationships.selfreferencemany.web;

import com.manjula.relationships.selfreferencemany.domain.model.TwitterDTO;
import com.manjula.relationships.selfreferencemany.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("")
    public List<TwitterDTO> findAll() {
        return twitterService.findAll();
    }

    @GetMapping("/{id}")
    public TwitterDTO findById(@PathVariable("id") Long id) {
        return twitterService.findById(id);
    }

    @GetMapping("/follow/{id}/{followingId}")
    public TwitterDTO follow(@PathVariable("id") Long id, @PathVariable("followingId") Long followingId) {
        return twitterService.follow(id, followingId);
    }

    @GetMapping("/followings/{id}")
    public List<TwitterDTO> findFollowings(@PathVariable("id") Long id) {
        return twitterService.findFollowings(id);
    }

    @GetMapping("/followers/{id}")
    public List<TwitterDTO> findFollowers(@PathVariable("id") Long id) {
        return twitterService.findFollowers(id);
    }

}
