package com.example.login.ripository;

import com.example.login.model.Login;
import com.example.login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRipository {
    static List<User> users = new ArrayList<>();
    static {
        User user1 = new User("john","123456","John","john@codegym.vn",10);
        User user2 = new User("bill","123456","Bill","john@codegym.vn",15);
        User user3 = new User("mike","123456","Mike","john@codegym.vn",16);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    public static User checkLogin(Login login){
        for (User u : users) {
            if (login.getAccount().equals(u.getAccount()) && login.getPassword().equals(u.getPassword())){
                return u;
            }
        }
        return null;
    }
}
