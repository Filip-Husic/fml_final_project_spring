package com.brights.fml_final_project_spring.dto;

import com.brights.fml_final_project_spring.model.Post;
import lombok.Getter;
import lombok.Setter;

public class PostDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    private String path;
    @Getter
    @Setter
    private String filename;

    @Getter
    @Setter
    private String author;



    public static Post toEntity(PostDto postDto){
        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setPrice(postDto.getPrice());

        return post;
    }

    public static PostDto toDto(Post post){
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setPrice(post.getPrice());
        postDto.setAuthor(post.getUser().getUsername());

        return postDto;
    }
}
