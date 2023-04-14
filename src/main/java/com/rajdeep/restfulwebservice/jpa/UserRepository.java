package com.rajdeep.restfulwebservice.jpa;

import com.rajdeep.restfulwebservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
