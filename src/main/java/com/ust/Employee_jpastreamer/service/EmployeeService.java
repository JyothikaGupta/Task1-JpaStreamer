package com.ust.Employee_jpastreamer.service;



import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.EmployeeJpastreamerApplication;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    private Employeerepo employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }


    public Map<String, Long> countOfMaleAndFemale() {
        return jpaStreamer.stream(Employee.class)
               .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }


    public List<Employee> listofemployeesjoinedinyear(int year){
        return jpaStreamer.stream(Employee.class)
                .filter(Employee->Employee.getJoiningYear()==year)
                .collect(Collectors.toList());
    }

    public List<Employee> listofemployeesbasedonfilter(String gender, int joiningyear, int experience, String education) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getGender().equals(gender)
                        && employee.getJoiningYear() == joiningyear
                        && employee.getExperienceInCurrentDomain() == experience
                        && employee.getEducation().equals(education))
                .collect(Collectors.toList());

    }

    public Map<String, List<Employee>> groupingbyeducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }


    public Map<String, Long> countmaleandfemaleinayear(int year) {
        return jpaStreamer.stream(Employee.class)
               .filter(employee -> employee.getJoiningYear() == year)
               .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

}
