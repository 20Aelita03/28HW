package com.aelita.HW.Service;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public interface ServiceN {
    Employee add(String firstName, String secondName, Integer salary, Integer department) throws EmployeeAlreadyAddedException;
    Employee delete(String firstName, String secondName, Integer salary, Integer department);




    Employee find(String firstName, String secondName, Integer salary, Integer department);

    Collection<Employee> showAll();
    Optional<Employee> getMaxSalaryByDepartment(int department);
    Optional<Employee> getMinSalaryByDepartment(int department);
    Stream<Employee> getAllEmployeesByDepartment(int department);
    Map<Integer,List<Employee>> getAllEmployeesByDepartments();


}
