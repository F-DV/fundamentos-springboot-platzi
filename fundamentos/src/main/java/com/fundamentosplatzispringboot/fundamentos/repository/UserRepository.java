package com.fundamentosplatzispringboot.fundamentos.repository;

import com.fundamentosplatzispringboot.fundamentos.dto.UserDto;
import com.fundamentosplatzispringboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    @Query("select u from User u where u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByname(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findBybirthdayBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.fundamentosplatzispringboot.fundamentos.dto.UserDto(u.id,u.name,u.birthday)"
            + " FROM User u"
            + " where u.birthday=:parametroFecha"
            + " and u.email=:parametroEmail")
    Optional<UserDto> getAllBybirthdayAndEmail(@Param("parametroFecha") LocalDate date,
                                               @Param("parametroEmail") String email);

    List<User> findAll();
}
