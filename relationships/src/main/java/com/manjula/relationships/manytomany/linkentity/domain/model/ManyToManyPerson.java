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
@Table(name = "many_to_many_link_person")
public class ManyToManyPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManyToManyPersonAddress> addresses = new ArrayList<>();

    public static ManyToManyPerson instance(String name) {
        ManyToManyPerson person = new ManyToManyPerson();
        person.setName(name);
        return person;
    }

    public void addAddress(ManyToManyAddress address) {
        ManyToManyPersonAddress personAddress = new ManyToManyPersonAddress(this, address);
        addresses.add(personAddress);
//        address.getOwners().add(personAddress); // this is not working even though it is in the documentation
    }

    public void removeAddress(ManyToManyAddress address) {
        ManyToManyPersonAddress personAddress = new ManyToManyPersonAddress(this, address);
        address.getOwners().remove(personAddress);
        addresses.remove(personAddress);
        personAddress.setPerson(null);
        personAddress.setAddress(null);
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ManyToManyPerson person = (ManyToManyPerson) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
