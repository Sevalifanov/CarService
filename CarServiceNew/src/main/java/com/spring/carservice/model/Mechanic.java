package com.spring.carservice.model;

import java.util.Objects;

/**
 * механик - id айди, firstName - имя, lastName - фамилия
 */
public class Mechanic {
    private Long id;
    private String firstName;
    private String lastName;


    public Mechanic(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Mechanic() {
    }

    public Mechanic(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(getId(), mechanic.getId()) &&
                Objects.equals(getFirstName(), mechanic.getFirstName()) &&
                Objects.equals(getLastName(), mechanic.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}
