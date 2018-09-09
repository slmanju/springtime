package com.manjula.relationships.manytomany.linkentity.service.impl;

import com.manjula.relationships.manytomany.linkentity.domain.model.ManyToManyAddress;
import com.manjula.relationships.manytomany.linkentity.domain.model.ManyToManyPerson;
import com.manjula.relationships.manytomany.linkentity.domain.repository.ManyToManyAddressRepository;
import com.manjula.relationships.manytomany.linkentity.domain.repository.ManyToManyPersonRepository;
import com.manjula.relationships.manytomany.linkentity.service.ManyToManyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ManyToManyLinkServiceImpl implements ManyToManyLinkService {

    @Autowired
    private ManyToManyPersonRepository personRepository;
    @Autowired
    private ManyToManyAddressRepository addressRepository;

    @PostConstruct
    public void init() {
        ManyToManyPerson person1 = ManyToManyPerson.instance("Ant Man");
        ManyToManyPerson person2 = ManyToManyPerson.instance("Wasp");
        ManyToManyPerson person3 = ManyToManyPerson.instance("Black Panther");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        ManyToManyAddress address1 = ManyToManyAddress.instance("abc");
        ManyToManyAddress address2 = ManyToManyAddress.instance("Wakanda");

        addressRepository.save(address1);
        addressRepository.save(address2);
    }

    @Override
    public void link(Long personId, Long addressId) {
        ManyToManyPerson person = personRepository.findById(personId).get();
        ManyToManyAddress address = addressRepository.findById(addressId).get();

        person.addAddress(address);

        personRepository.save(person);
    }
}
