package com.wujq.pay.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularEmployeeService implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public boolean isValid(EmployeeRole employeeRole) {
        return employeeRole.equals(employeeRole.equals(EmployeeRole.WORKER));
    }

}
