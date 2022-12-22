package com.brights.fml_final_project_spring.rest_controller;

import com.brights.fml_final_project_spring.dto.PostDto;
import com.brights.fml_final_project_spring.model.Picture;
import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.model.User;
import com.brights.fml_final_project_spring.repository.PictureRepository;
import com.brights.fml_final_project_spring.service.PostService;
import com.brights.fml_final_project_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private final PictureRepository pictureRepository;

    @Autowired
    public PostController(PostService postService, UserService userService, PictureRepository pictureRepository) {
        this.postService = postService;
        this.userService = userService;
        this.pictureRepository = pictureRepository;
    }

    @PostMapping("/{postId}/picture")
    public PostDto uploadProfilePhoto(@RequestParam("file") MultipartFile file, @PathVariable Long postId) {
        Post post = this.postService.getPostById(postId);

        try {
            Picture picture = new Picture();
            picture.setPictureData(file.getBytes());
            picture.setFilename(file.getOriginalFilename());
            picture.setMimeType(file.getContentType());
            picture = pictureRepository.save(picture);
            post.setPicture(picture);
            post = postService.savePost(post);
        } catch (IOException e) {
//            logger.error("Error while reading file", e);
        }
        PostDto postDto = PostDto.toDto(post);
        postDto.setPath("/api/post/" + post.getId() + "/picture");
        if (post.getPicture() != null) {
            postDto.setFilename(post.getPicture().getFilename());
        }
        return postDto;
    }

    @GetMapping("/{postId}/picture")
    public ResponseEntity<byte[]> getPicture(@PathVariable Long postId) {
        Post post = this.postService.getPostById(postId);
        Picture picture = post.getPicture();

        assert picture != null;
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(picture.getMimeType()))
                .contentLength(picture.getPictureData().length)
                .body(picture.getPictureData());
    }


    @CrossOrigin
    @PostMapping("/{userId}")
    public ResponseEntity<PostDto> createPost(@PathVariable Long userId, Principal principal, @RequestBody PostDto postDetails) {
        User user = userService.getUserById(userId);
        //TODO check user by principal username and find it in repository

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Post post = PostDto.toEntity(postDetails);
        post.setUser(user);

        post = postService.savePost(post);
        user.addPost(post);
        postDetails = PostDto.toDto(post);

        return new ResponseEntity<>(postDetails, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<Post>> showAllPosts() {
        try {
            List<Post> postList = postService.getAllPosts();
            if (postList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(postList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Post post = postService.getPostById(id);

        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
        Post post1 = postService.updatePostById(id, post);
        if (post1 != null) {
            return new ResponseEntity<>(postService.savePost(post1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
    }
}
