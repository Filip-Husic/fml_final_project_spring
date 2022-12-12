package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.repository.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Getter
    @Setter
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
