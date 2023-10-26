package com.aelita.HW.Controller;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;
import com.aelita.HW.Service.ServiceN;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employee")
public class controller {
    private final ServiceN serviceN;

    public controller(ServiceN serviceN) {
        this.serviceN = serviceN;

    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName,
                         @RequestParam("salary")Integer salary, @RequestParam("department")Integer department) {
        return serviceN.find(firstname,secondName,salary, department);

    }
    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName,
                        @RequestParam("salary")Integer salary, @RequestParam("department")Integer department) throws EmployeeAlreadyAddedException {
        return serviceN.add(firstname,secondName, salary,department);
        //add?firstName=cbbjvgjkhbc&secondName=jhvgcvgv&salary=500000&department=2
    }
    @GetMapping(path = "/delete")
    public Employee delete(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName,
                           @RequestParam("salary")Integer salary, @RequestParam("department")Integer department) {
        return serviceN.delete(firstname,secondName, salary,department);
    }
    @GetMapping(path = "/showAll")
    public Collection<Employee> showAll(){
        return serviceN.showAll();
    }
    @GetMapping(path="/departments/max-salary")
    public Optional<Employee> getMaxSalaryByDepartment(@RequestParam() int department){
        return serviceN.getMaxSalaryByDepartment(department);
        //http://localhost:8080/employee/departments/max-salary?department=2
    }
    @GetMapping(path="/departments/min-salary")
    public Optional<Employee> getMinSalaryByDepartment(@RequestParam() int department){
        return serviceN.getMinSalaryByDepartment(department);
        //http://localhost:8080/employee/departments/mix-salary?department=2
    }
    @GetMapping(path="/departments/all")
    public Stream<Employee> getAllEmployeesByDepartment(@RequestParam() int department){
        return serviceN.getAllEmployeesByDepartment(department);
        //http://localhost:8080/employee/departments/all?department=2
    }
    @GetMapping(path="/departments/all2")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments(){
        return serviceN.getAllEmployeesByDepartments();
        //http://localhost:8080/employee/departments/all
    }

}
