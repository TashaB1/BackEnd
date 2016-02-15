package ru.mail.tasha2k7;

import administrate.db.HibernateUtil;
import administrate.entity.Phone;
import administrate.entity.User;
import administrate.service.UserService;
import administrate.service.impl.UserServiceImpl;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by USER on 15.02.2016.
 */
public class UserServiceImplTest {
   private UserService userService = new UserServiceImpl();

    @Test
    public void phoneUser() {
        System.out.println(userService.setUsers());
    }
}
