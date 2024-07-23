package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }

    @GetMapping("/countofmaleamdfemale")
    public Map<String, Long> countOfMaleAndFemale(){
        return employeeService.countOfMaleAndFemale();
    }
    @GetMapping("/listofemployeesjoinedin/{year}")
    public List<Employee> listofemployeesjoinedinyear(@PathVariable int year){
        return employeeService.listofemployeesjoinedinyear(year);
    }

    @GetMapping("/listofemployeesbasedonfilter/{gender}/{joiningyear}/{experience}/{education}")
    public List<Employee> listofemployeesbasedonfilter(@PathVariable String gender, @PathVariable int joiningyear, @PathVariable int experience, @PathVariable String education){
        return employeeService.listofemployeesbasedonfilter(gender, joiningyear, experience,education);
    }
    @GetMapping("/groupingbyeducation")
    public Map<String, List<Employee>> groupingbyeducation(){
        return employeeService.groupingbyeducation();
    }
    @GetMapping("/countmaleandfemaleinayear/{year}")
    public Map<String, Long> countmaleandfemaleinayear(@PathVariable int year){
        return employeeService.countmaleandfemaleinayear(year);
    }



}
