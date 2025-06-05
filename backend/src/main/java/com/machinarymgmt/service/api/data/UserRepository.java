package com.machinarymgmt.service.api.data;

import com.machinarymgmt.service.api.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username); // ✅ existing and valid

    Optional<User> findByEmail(String email);       // 🔄 optional if you support email login

    Optional<User> findByUsernameAndActiveTrue(String username); // 🔐 safer login
}
