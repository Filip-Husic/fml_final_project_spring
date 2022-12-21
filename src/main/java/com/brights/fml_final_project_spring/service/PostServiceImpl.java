package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Getter
    @Setter
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post updatePostById(long id, Post post) {
        Post postData = getPostById(id);
        if(postData != null) {
            postData.setTitle(post.getTitle());
            postData.setUrl(post.getUrl());
            postData.setAlbumId(postData.getAlbumId());
            postData.setThumbnailUrl(post.getThumbnailUrl());
            postData.setPostedDate(new Date());
            return postData;
        }
        return null;
    }


    @Override
    public void deletePostById(long id) {
        boolean exists = this.postRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Post with id " + id + " was not found.");
        }
        this.postRepository.deleteById(id);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }


}


