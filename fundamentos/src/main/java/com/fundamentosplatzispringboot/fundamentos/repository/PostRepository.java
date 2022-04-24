package com.fundamentosplatzispringboot.fundamentos.repository;

import com.fundamentosplatzispringboot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
