package com.codegym.registration_form.service.impl;

import com.codegym.registration_form.model.User;
import com.codegym.registration_form.repository.IUserRepository;
import com.codegym.registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
