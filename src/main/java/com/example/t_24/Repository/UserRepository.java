package com.example.t_24.Repository;

import com.example.t_24.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUser_name(String user_name);
}
