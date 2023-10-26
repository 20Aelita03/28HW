package com.aelita.HW.Service;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;
import com.aelita.HW.Exsception.EmployeeNotFoundException;
import com.aelita.HW.Exsception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@Service
public class EmployeeService implements ServiceN{
    Integer maxEmployee = 150;
    Map<String, Employee> numsEmpl = new HashMap<>();


    @Override
    public Employee add(String firstName, String secondName, Integer salary, Integer department) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, salary, department, secondName);
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
    public Employee delete(String firstName, String secondName, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, salary, department, secondName);
        if (numsEmpl.containsKey(employee.getFullName())) {
            return numsEmpl.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String secondName, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, salary, department, secondName);
        if (numsEmpl.containsKey(employee.getFullName())) {
            return numsEmpl.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public Collection<Employee> showAll(){

        return Collections.unmodifiableCollection(numsEmpl.values());
    }

    @Override
    public Optional<Employee> getMaxSalaryByDepartment(int department) {
        return showAll().stream()
                .filter(e->e.getDepartment()==department )
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getMinSalaryByDepartment(int department) {
        return showAll().stream()
                .filter(e->e.getDepartment()==department )
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Stream<Employee> getAllEmployeesByDepartment(int department) {
        return showAll().stream()
                .filter(e->e.getDepartment()==department);
    }
    @Override
    public Map<Integer,List<Employee>> getAllEmployeesByDepartments() {
        return showAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
