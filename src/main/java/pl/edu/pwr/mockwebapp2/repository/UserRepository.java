package pl.edu.pwr.mockwebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.mockwebapp2.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}