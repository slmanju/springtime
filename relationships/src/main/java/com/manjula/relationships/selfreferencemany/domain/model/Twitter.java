package com.manjula.relationships.selfreferencemany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_self_twitter")
public class Twitter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "many_to_many_self_twitter_following",
            joinColumns = @JoinColumn(name = "twitter_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<Twitter> followings = new HashSet<>();

    @ManyToMany(mappedBy = "followings", fetch = FetchType.LAZY)
    private Set<Twitter> followers = new HashSet<>();

    public static Twitter instance(String name) {
        return Twitter.builder()
                .name(name)
                .followings(new HashSet<>())
                .followers(new HashSet<>())
                .build();
    }

    public void addFollowing(Twitter following) {
        followings.add(following);
        following.getFollowers().add(this);
    }

    public TwitterDTO toDto() {
        return TwitterDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twitter tag = (Twitter) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
