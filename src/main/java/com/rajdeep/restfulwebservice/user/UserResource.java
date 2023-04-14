package com.rajdeep.restfulwebservice.user;

import com.rajdeep.restfulwebservice.jpa.PostRepository;
import com.rajdeep.restfulwebservice.jpa.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    private UserRepository service;
    private PostRepository post;

    public UserResource(UserRepository service, PostRepository post) {
        this.service = service;
        this.post = post;
    }
    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
    @GetMapping(value = "/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = service.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id + " Not Found");
        }
        return  user;
    }
    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@Validated  @RequestBody User user) {
        User savedUser = service.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
    @GetMapping(value = "/users/{id}/posts")
    public List<Post> retrieveAllPosts (@PathVariable int id) {
        Optional<User> user = service.findById(id);
        return user.get().getPosts();
    }

    @PostMapping(value = "/users/{id}/posts")
    public List<Post> createPostForUser (@PathVariable int id, @Validated @RequestBody Post postPayLoad) {
        Optional<User> user = service.findById(id);
        if(user.isEmpty() ){
            throw new UserNotFoundException("id " + id + " Not Found");
        }
        postPayLoad.setUser(user.get());
        Post savedPost = post.save(postPayLoad);
        return user.get().getPosts();
    }

}
