package com.noobyang.injection;

public class UserAction {

    private UserService userService;

    public String execute() {
        userService.save();
        return null;
    }

}
