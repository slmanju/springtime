package com.manjula.relationships.onetoone.service;

import com.manjula.relationships.onetoone.domain.model.OneToOnePost;
import com.manjula.relationships.onetoone.domain.model.OneToOnePostDTO;
import com.manjula.relationships.onetoone.domain.model.OneToOnePostDetails;
import com.manjula.relationships.onetoone.domain.repository.OneToOnePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OneToOneServiceImpl implements OneToOneService {

    @Autowired
    private OneToOnePostRepository oneToOnePostRepository;

    @PostConstruct
    public void init() {
        OneToOnePost post1 = OneToOnePost.instance("First Post");
        OneToOnePostDetails details = OneToOnePostDetails.instance("first post description", post1);
        post1.setDetails(details);

        oneToOnePostRepository.save(post1);

        OneToOnePost post2 = OneToOnePost.instance("Second Post");
        OneToOnePostDetails details2 = OneToOnePostDetails.instance("second post description", post2);
        post2.setDetails(details2);

        oneToOnePostRepository.save(post2);
    }

    @Override
    public List<OneToOnePostDTO> findAll() {
        return oneToOnePostRepository.findAllEagerly().stream()
                .map(OneToOnePost::toDetailedDto).collect(toList());
    }

    @Override
    public OneToOnePostDTO findById(Long id) {
        return oneToOnePostRepository.findById(id).map(OneToOnePost::toDto).orElse(null);
    }

    @Override
    public OneToOnePostDTO findDetailedById(Long id) {
        return oneToOnePostRepository.findByIdEagerly(id).map(OneToOnePost::toDetailedDto).orElse(null);
    }

}
