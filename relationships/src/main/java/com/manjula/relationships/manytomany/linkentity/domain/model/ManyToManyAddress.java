package com.manjula.relationships.manytomany.linkentity.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_link_address")
public class ManyToManyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postalCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManyToManyPersonAddress> owners = new ArrayList<>();

    public static ManyToManyAddress instance(String postalCode) {
        ManyToManyAddress address = new ManyToManyAddress();
        address.setPostalCode(postalCode);
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ManyToManyAddress address = (ManyToManyAddress) o;
        return Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode);
    }

}
