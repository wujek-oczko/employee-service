package com.wujq.pay.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public boolean isValid(EmployeeRole employeeRole) {
        return (employeeRole.equals(EmployeeRole.CEO) || employeeRole.equals(EmployeeRole.DIRECTOR) || employeeRole.equals(EmployeeRole.MANAGER));
    }




}
