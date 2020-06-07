package com.wujq.pay.employee;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column
    private int homeNumber;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String zip;

    @Column
    private String country;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int number) {
        this.homeNumber = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
