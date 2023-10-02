package com.aelita.HW.Service;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;
import com.aelita.HW.Exsception.EmployeeNotFoundException;
import com.aelita.HW.Exsception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements ServiceN{
    Integer maxEmployee = 150;
    Map<String, Employee> numsEmpl = new HashMap<>();




    @Override
    public Employee add(String firstName, String secondName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, secondName);
        if (numsEmpl.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }

        if (numsEmpl.size() < maxEmployee) {
            numsEmpl.put(employee.getFullName(), employee);
            return employee;
        }else {
            throw new EmployeeStorageIsFullException("Превышенно колличество сотрудников");
        }

    }

    @Override
    public Employee delete(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (numsEmpl.containsKey(employee.getFullName())) {
            return numsEmpl.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (numsEmpl.containsKey(employee.getFullName())) {
            return numsEmpl.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public Collection<Employee> showAll(){

        return Collections.unmodifiableCollection(numsEmpl.values());
    }
}
