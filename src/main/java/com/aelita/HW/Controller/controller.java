package com.aelita.HW.Controller;

import com.aelita.HW.Employee;
import com.aelita.HW.Exsception.EmployeeAlreadyAddedException;
import com.aelita.HW.Service.ServiceN;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class controller {
    private final ServiceN serviceN;

    public controller(ServiceN serviceN) {
        this.serviceN = serviceN;

    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName) {
        return serviceN.find(firstname,secondName);

    }
    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName) throws EmployeeAlreadyAddedException {
        return serviceN.add(firstname,secondName);
    }
    @GetMapping(path = "/delete")
    public Employee delete(@RequestParam("firstName") String firstname, @RequestParam("secondName") String secondName) {
        return serviceN.delete(firstname,secondName);
    }
    @GetMapping(path = "/showAll")
    public Collection<Employee> showAll(){
        return serviceN.showAll();
    }
}
