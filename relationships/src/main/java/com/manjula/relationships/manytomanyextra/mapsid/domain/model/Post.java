package com.manjula.relationships.manytomanyextra.mapsid.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity(name = "Post")
@Table(name = "many_to_many_extra_mapsid_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostTag> tags = new ArrayList<>();

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public void addTag(Tag tag) {
        PostTag postTag = new PostTag(this, tag);
        tags.add(postTag);
    }

//    public void removeTag(Tag tag) {
//        for (Iterator<PostTag> iterator = tags.iterator();
//             iterator.hasNext(); ) {
//            PostTag postTag = iterator.next();
//
//            if (postTag.getPost().equals(this) &&
//                    postTag.getTag().equals(tag)) {
//                iterator.remove();
//                postTag.getTag().getPosts().remove(postTag);
//                postTag.setPost(null);
//                postTag.setTag(null);
//            }
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
