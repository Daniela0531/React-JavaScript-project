package edu.phystech.inspiration.data.repo;

import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
