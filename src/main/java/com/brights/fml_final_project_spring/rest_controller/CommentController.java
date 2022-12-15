package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.model.Comment;
import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.service.CommentService;
import com.brights.fml_final_project_spring.service.PostService;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final UserService userService;
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/user/{userId}/comment/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody Comment commentDetails, @PathVariable Long userId){
        Post post = postService.getPostById(postId);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentDetails.setUser(user);
        commentDetails.setPost(post);

        Comment comment = commentService.saveComment(commentDetails);
        user.addComment(comment);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);

    }

    @PutMapping("/comment/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment comment) {
        Comment comment1 = commentService.updateCommentById(id, comment);
        if(comment1 != null ) {
            return new ResponseEntity<>(commentService.saveComment(comment1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
