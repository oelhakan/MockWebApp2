package pl.edu.pwr.mockwebapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.mockwebapp2.model.User;
import pl.edu.pwr.mockwebapp2.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@RestController
public class MockWebApp2Application {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/add")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users/remove/{userId}")
    public int removeUser(@PathVariable(value="userId") int userId){
        userRepository.deleteById(userId);
        return userId;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable(value="userId") int userId){
        return userRepository.findById(userId).isPresent() ? userRepository.findById(userId).get() : null;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MockWebApp2Application.class, args);
    }

}
