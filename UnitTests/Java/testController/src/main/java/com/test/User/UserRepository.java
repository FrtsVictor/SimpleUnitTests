package com.test.User;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, u.email, u.fullName) LIKE %?1% ")
    public Page<User> findAll(String keyword, Pageable pageable);

    @Query("UPDATE User u SET u.enabled = ?2 WHERE u.id= ?1")
    @Modifying
    public void updateEnabledStatus(@Param("id") Integer id, @Param("enabled") boolean enabled);
}
