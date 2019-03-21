package com.aitsi.project.blog.service;

import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.domain.security.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {


    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findByBlogTitle(String title);

    List<User> findUserList();

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);

    boolean checkPasswordLengthNotBetween6and30(String password);

    boolean checkEmail(String email);

    List<User> findNewestUsers();

    List<User> findOldestUsers();

    List<User> findHighestRatedBlogs();

    void enableUser(String username);

    void disableUser(String username);
}
