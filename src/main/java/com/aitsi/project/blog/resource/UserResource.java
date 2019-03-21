package com.aitsi.project.blog.resource;

import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public List<User> userList() {
        List<User> allUsersList = userService.findUserList();
        List<User> userList = new ArrayList<>();

        for( User user : allUsersList) {
            if ( !user.getUsername().equals("admin") ) {
                userList.add(user);
            }
        }

        return userList;
    }

    @RequestMapping("/user/{username}/enable")
    public void enableUser(@PathVariable("username") String username) {
        userService.enableUser(username);
    }

    @RequestMapping("/user/{username}/disable")
    public void disableUser(@PathVariable("username") String username) {
        userService.disableUser(username);
    }
}
