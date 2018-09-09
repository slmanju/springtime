package com.manjula.relationships.manytomany.linkentity.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Embeddable
public class ManyToManyPersonAddressId implements Serializable {

    private Long person;
    private Long address;

}
