package com.manjula.relationships.manytomany.linkentity.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "many_to_many_link_person_address")
@IdClass(ManyToManyPersonAddressId.class)
public class ManyToManyPersonAddress {

    @Id
    @ManyToOne
    private ManyToManyPerson person;

    @Id
    @ManyToOne
    private ManyToManyAddress address;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ManyToManyPersonAddress that = (ManyToManyPersonAddress) o;
        return Objects.equals(person, that.person) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, address);
    }

}
