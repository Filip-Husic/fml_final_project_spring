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
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }


    @CrossOrigin
    @PostMapping("/post/{userId}")
    public ResponseEntity<Post> createPost(@PathVariable Long userId, @RequestBody Post postDetails) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postDetails.setPostedDate(new Date());
        postDetails.setUser(user);

        Post post = postService.savePost(postDetails);
        user.addPost(post);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/post")
    public ResponseEntity<List<Post>> showAllPosts(){
        try {
            List<Post> postList = postService.getAllPosts();
            if (postList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(postList,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin
    @DeleteMapping("/post/delete/{id}")
    public void deletePost(@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
    }
}
