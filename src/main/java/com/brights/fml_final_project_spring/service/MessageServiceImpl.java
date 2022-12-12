package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.repository.MessageRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Getter
    @Setter
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
