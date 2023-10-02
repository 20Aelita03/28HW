package com.aelita.HW.Service;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;

import java.util.Collection;

public interface ServiceN {
    Employee add(String firstName, String secondName) throws EmployeeAlreadyAddedException;
    Employee delete(String firstName, String secondName);




    Employee find(String firstName, String secondName);

    Collection<Employee> showAll();
}
