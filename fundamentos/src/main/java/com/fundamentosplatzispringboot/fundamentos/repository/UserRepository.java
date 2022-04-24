package com.fundamentosplatzispringboot.fundamentos.repository;

import com.fundamentosplatzispringboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
