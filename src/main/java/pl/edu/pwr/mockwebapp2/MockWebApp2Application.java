package pl.edu.pwr.mockwebapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MockWebApp2Application.class, args);
    }

}
