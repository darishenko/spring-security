package com.example.security.jwt.repository;

import com.example.security.jwt.model.User;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User> findUsersByUsername(String username);
}
