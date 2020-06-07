package com.wujq.pay.employee;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface EmployeeService {

    EmployeeRepository getEmployeeRepository();

    boolean isValid(EmployeeRole employeeRole);

    default Employee save(Employee employee) {
        return getEmployeeRepository().save(employee);
    }

    default Iterable<Employee> saveAll(Iterable<Employee> var1){
        return getEmployeeRepository().saveAll(var1);
    }

    default Optional<Employee> findById(Long var1){
        return getEmployeeRepository().findById(var1);
    }

    default boolean existsById(Long var1) {
        return getEmployeeRepository().existsById(var1);
    }

    default Iterable<Employee> findAll(){
        return getEmployeeRepository().findAll();
    }

    default Iterable<Employee> findAllById(Iterable<Long> var1){
        return getEmployeeRepository().findAllById(var1);
    }

    default long count(){
        return getEmployeeRepository().count();
    }

    default void deleteById(Long var1){
        getEmployeeRepository().deleteById(var1);
    }

    default void delete(Long var1){
        getEmployeeRepository().deleteById(var1);
    }

    default void deleteAll(Iterable<Employee> var1){
        getEmployeeRepository().deleteAll();
    }

    default void deleteAll(){
        getEmployeeRepository().deleteAll();
    }
}
