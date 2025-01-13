package com.piashraful.learning.sringboot.repository;

import com.piashraful.learning.sringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
