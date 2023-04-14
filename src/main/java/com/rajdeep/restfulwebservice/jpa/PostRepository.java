package com.rajdeep.restfulwebservice.jpa;

import com.rajdeep.restfulwebservice.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
