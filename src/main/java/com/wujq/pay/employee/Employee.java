package com.wujq.pay.employee;


import com.wujq.pay.employee.validators.AgeConstraint;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    @AgeConstraint(message = "Employee need to be an adult")
    private Integer age;

    @Column()
    private String PESEL;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	@JoinColumn(name = "employee_id")
    private List<Address> addressList = new ArrayList<>();

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

//-> pracownik musi zawierać PESEL
//-> pracownik musi zawierać adres (pracownik może mieć wiele adresów np: zamieszkania, zameldowania)
//-> pracownik musi zawierać role (PRACOWNIK,MENADŻER,CEO,DYREKTOR)
//-> wszystkie pola muszą być zwalidowane (imie,nazwisko,wiek,PESEL,adres)
//-> wszystkie pola mogą być updateowane

    public Employee() {
        super();
    }

    public Employee(Long id, String name, String lastName, Integer age, String PESEL, List<Address> addressList, EmployeeRole employeeRole) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.PESEL = PESEL;
        this.addressList = addressList;
        this.employeeRole = employeeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
