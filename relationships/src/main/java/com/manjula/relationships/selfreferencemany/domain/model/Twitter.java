package com.manjula.relationships.selfreferencemany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_self_twitter")
public class Twitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "many_to_many_self_twitter_following",
            joinColumns = @JoinColumn(name = "twitter_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<Twitter> followings = new HashSet<>();

    @ManyToMany(mappedBy = "followings")
    private Set<Twitter> followers = new HashSet<>();

    public static Twitter instance(String name) {
        return Twitter.builder().name(name).followings(new HashSet<>()).followers(new HashSet<>()).build();
    }

    public void addFollowing(Twitter following) {
        getFollowings().add(following);
        following.getFollowers().add(following);
    }

    public TwitterDTO toDto() {
        return TwitterDTO.builder()
                .id(id)
                .name(name).build();
    }

}
