package com.hunain.loginapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long>{
    public User findByEmailAndPassword(String email, String password);
}
