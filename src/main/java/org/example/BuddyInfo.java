package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String number;


  protected BuddyInfo(){

  }

    public BuddyInfo(String firstName, String lastName, String address, String number, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[id=%d, firstName='%s', lastName='%s', address='%s', age='%s', number='%s']",
                id, firstName, lastName, address, age, number);
    }

    public String getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }


    public int getAge() {
        return age;
    }






}
