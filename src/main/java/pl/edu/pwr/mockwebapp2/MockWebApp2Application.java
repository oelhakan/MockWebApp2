package pl.edu.pwr.mockwebapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.mockwebapp2.model.Employee;
import pl.edu.pwr.mockwebapp2.repository.EmployeeRepository;

import java.util.List;

@SpringBootApplication
@RestController
public class MockWebApp2Application {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/remove/{employeeId}")
    public int removeEmployee(@PathVariable(value="employeeId") int employeeId){
        employeeRepository.deleteById(employeeId);
        return employeeId;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(value="employeeId") int employeeId){
        return employeeRepository.findById(employeeId).isPresent() ? employeeRepository.findById(employeeId).get() : null;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MockWebApp2Application.class, args);
    }

}
