package com.manjula.relationships.manytoone.service;

import com.manjula.relationships.manytoone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManyToOneDepartmentServiceImpl implements ManyToOneService {

    @Autowired
    private ManyToOneDepartmentRepository manyToOneDepartmentRepository;
    @Autowired
    private ManyToOneEmployeeRepository manyToOneEmployeeRepository;

    @PostConstruct
    public void init() {
        ManyToOneDepartment department1 = ManyToOneDepartment.instance("Development");
        ManyToOneDepartment department2 = ManyToOneDepartment.instance("QA");

        department1 = manyToOneDepartmentRepository.save(department1);
        department2 = manyToOneDepartmentRepository.save(department2);

        ManyToOneEmployee employee1 = ManyToOneEmployee.instance("Iron Man", department1);
        ManyToOneEmployee employee2 = ManyToOneEmployee.instance("Bat Man", department1);
        ManyToOneEmployee employee3 = ManyToOneEmployee.instance("Ant Man", department2);
        ManyToOneEmployee employee4 = ManyToOneEmployee.instance("Hulk", department2);
        ManyToOneEmployee employee5 = ManyToOneEmployee.instance("Thor", department2);

        manyToOneEmployeeRepository.save(employee1);
        manyToOneEmployeeRepository.save(employee2);
        manyToOneEmployeeRepository.save(employee3);
        manyToOneEmployeeRepository.save(employee4);
        manyToOneEmployeeRepository.save(employee5);
    }

    @Override
    public List<ManyToOneDepartmentDTO> findAllDepartments() {
        return manyToOneDepartmentRepository.findAll().stream().map(ManyToOneDepartment::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ManyToOneEmployeeDTO> findAllEmployees() {
        return manyToOneEmployeeRepository.findAll().stream().map(ManyToOneEmployee::toDto).collect(Collectors.toList());
    }

}
