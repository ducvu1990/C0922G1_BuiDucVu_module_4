package com.codegym.registration_form.service;

import com.codegym.registration_form.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void save(User user);
}
