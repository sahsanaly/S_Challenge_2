package com.sept.challenge2.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String postcode;
    @Column
    private String age;
    @Column
    private String job;
    @Column
    private String email;
    @Column
    private String phoneNumber;

    public Person() {
    }

    public Person(Integer id, String name, String address, String postcode, String age, String job, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
