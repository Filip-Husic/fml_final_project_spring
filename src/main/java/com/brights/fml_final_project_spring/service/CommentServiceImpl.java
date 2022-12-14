package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.Comment;
import com.brights.fml_final_project_spring.model.Post;
import com.brights.fml_final_project_spring.repository.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Getter
    @Setter
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}
