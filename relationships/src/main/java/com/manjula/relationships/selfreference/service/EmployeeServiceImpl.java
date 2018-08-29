package com.manjula.relationships.selfreference.service;

import com.manjula.relationships.selfreference.domain.Employee;
import com.manjula.relationships.selfreference.domain.EmployeeDTO;
import com.manjula.relationships.selfreference.domain.EmployeeRepository;
import com.manjula.relationships.selfreference.domain.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init() {
        Employee manager = Employee.instance("Iron Man", EmployeeType.MANAGER);
        manager = employeeRepository.save(manager);

        Employee lead1 = Employee.instance("Thor", EmployeeType.LEAD);
        Employee lead2 = Employee.instance("Spider Man", EmployeeType.LEAD);

        lead1.setManager(manager);
        lead2.setManager(manager);

        lead1 = employeeRepository.save(lead1);
        lead2 = employeeRepository.save(lead2);

        Employee developer1 = Employee.instance("Hulk", EmployeeType.DEVELOPER);
        Employee developer2 = Employee.instance("Groot", EmployeeType.DEVELOPER);

        developer1.setManager(lead1);
        developer2.setManager(lead1);

        employeeRepository.save(developer1);
        employeeRepository.save(developer2);

        Employee developer3 = Employee.instance("Ant Man", EmployeeType.DEVELOPER);
        developer3.setManager(lead2);

        employeeRepository.save(developer3);

        Employee manager2 = Employee.instance("Bat Man", EmployeeType.MANAGER);
        manager2 = employeeRepository.save(manager2);

        Employee lead21 = Employee.instance("Super Man", EmployeeType.LEAD);
        Employee lead22 = Employee.instance("Wonder Women", EmployeeType.LEAD);

        lead21.setManager(manager2);
        lead22.setManager(manager2);

        employeeRepository.save(lead21);
        employeeRepository.save(lead22);
    }

    @Override
    public List<EmployeeDTO> findAllManagers() {
        return employeeRepository.findAllManagers()
                .stream()
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }

}
