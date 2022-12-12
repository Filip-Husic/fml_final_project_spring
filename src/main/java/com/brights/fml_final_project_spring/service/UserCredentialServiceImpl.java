package com.brights.fml_final_project_spring.service;

import com.brights.fml_final_project_spring.model.DTORegistration;
import com.brights.fml_final_project_spring.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {
    private final UserCredentialRepository userCredentialRepository;

    public UserCredentialServiceImpl(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public void saveUserCredential(DTORegistration dtoRegistration) {
        userCredentialRepository.save(dtoRegistration);
    }
}
