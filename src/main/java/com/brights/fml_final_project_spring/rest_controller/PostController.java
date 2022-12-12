package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.service.PostService;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/post/{userId}")
    public ResponseEntity<Post> createPost(@PathVariable Long userId, @RequestBody Post postDetails) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postDetails.setPostedDate(new Date());
        postDetails.setPostedBy(user);

        Post post = postService.savePost(postDetails);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/post/delete/{id}")
    public void deletePost(@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
    }
}
