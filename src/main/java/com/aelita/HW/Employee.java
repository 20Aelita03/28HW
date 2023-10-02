package com.aelita.HW;

import java.util.Objects;

public class Employee {
    private final String firstName;

    public String getFullName(){
        return firstName + " " + secondName;}
    private final String secondName;




    public Employee(String firstName, String secondName) {
        this.secondName = secondName ;

        this.firstName = firstName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return
                "Фамилия: " + secondName + " Имя: " + firstName ;
    }
}
