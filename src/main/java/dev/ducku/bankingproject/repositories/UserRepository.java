package dev.ducku.bankingproject.repositories;

import dev.ducku.bankingproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
}
