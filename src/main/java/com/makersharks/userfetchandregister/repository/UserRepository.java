package com.makersharks.userfetchandregister.repository;

import com.makersharks.userfetchandregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
