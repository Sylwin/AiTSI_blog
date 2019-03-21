package com.aitsi.project.blog.service.UserServiceImpl;

import com.aitsi.project.blog.dao.RoleDao;
import com.aitsi.project.blog.dao.UserDao;
import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.domain.security.UserRole;
import com.aitsi.project.blog.service.BlogService;
import com.aitsi.project.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private BlogService blogService;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByBlogTitle(String title) {
        List<User> chosenUsersList = new ArrayList<>();
        List<User> usersList = userDao.findAll();

        title = title.replaceAll("_", " ").toLowerCase();

        for(User user : usersList ) {
            String dbTitle = user.getBlogTitle().toLowerCase();
            if( dbTitle.contains(title)) {
                chosenUsersList.add(user);
            }
        }

        return chosenUsersList;
    }

    public List<User> findUserList() { return userDao.findAll(); }

    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userDao.findByUsername(user.getUsername());

        if( localUser != null ) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        }
        else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for( UserRole ur : userRoles ) {
                roleDao.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            user.setBlog(blogService.createBlog());

            localUser = userDao.save(user);
        }
        return localUser;
    }

    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(email);
    }

    public boolean checkUsernameExists(String username) {
        return findByUsername(username) != null;
    }

    public boolean checkEmailExists(String email) {
        return findByEmail(email) != null;
    }

    public boolean checkPasswordLengthNotBetween6and30(String password) {
        return password.length() < 6 || password.length() > 30;
    }

    public boolean checkEmail(String email) {
//        final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    public List<User> findNewestUsers() {
        List<User> allUsers = (List<User>) userDao.findAll();

        if (allUsers.size() > 0) {
            Collections.sort(allUsers, Comparator.comparingLong(User::getId));
        }

        List<User> fiveNewestUsers;
        if( allUsers.size() < 5 )
            fiveNewestUsers = allUsers.subList(
                    0, allUsers.size());
        else
            fiveNewestUsers = allUsers.subList(
                    allUsers.size()-5, allUsers.size());

        Collections.reverse(fiveNewestUsers);

        return fiveNewestUsers;
    }

    public List<User> findOldestUsers() {
        List<User> allUsers = (List<User>) userDao.findAll();

        if (allUsers.size() > 0) {
            Collections.sort(allUsers, Comparator.comparingLong(User::getId));
        }

        List<User> fiveOldestUsers;
        if( allUsers.size() < 5 )
            fiveOldestUsers = allUsers.subList(0, allUsers.size());
        else
            fiveOldestUsers = allUsers.subList(0, 5);

        //Collections.reverse(fiveOldestUsers);

        return fiveOldestUsers;
    }

    public List<User> findHighestRatedBlogs() {
        List<User> allUsers = (List<User>) userDao.findAll();
        List<Blog> allBlogs = new ArrayList<>();

        for( User user: allUsers) {
            allBlogs.add(user.getBlog());
        }

        if (allBlogs.size() > 0) {
            Collections.sort(allBlogs, Comparator.comparingDouble(Blog::getRate));
        }

        List<Blog> fiveHighestRatedBlogs;
        if( allUsers.size() < 5 )
            fiveHighestRatedBlogs = allBlogs.subList(0, allBlogs.size());
        else
            fiveHighestRatedBlogs = allBlogs.subList(allBlogs.size()-5, allBlogs.size());

        Collections.reverse(fiveHighestRatedBlogs);
        List<User> fiveUsers = new ArrayList<>();

        for( Blog blog : fiveHighestRatedBlogs ) {
            for( User user : allUsers ) {
                if( blog.getId() == user.getBlog().getId() ) {
                    fiveUsers.add(user);
                }
            }
        }

        return fiveUsers;
    }

    public void enableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(true);
        userDao.save(user);
    }

    public void disableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(false);
        userDao.save(user);
    }
}
