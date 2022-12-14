package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.model.Comment;
import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.service.CommentService;
import com.brights.fml_final_project_spring.service.PostService;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }
}
