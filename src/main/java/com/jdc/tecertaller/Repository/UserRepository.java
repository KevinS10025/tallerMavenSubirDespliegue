package com.jdc.tecertaller.Repository;

import com.jdc.tecertaller.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}