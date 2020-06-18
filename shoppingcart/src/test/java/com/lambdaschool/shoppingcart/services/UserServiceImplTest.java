package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingcartApplication;
import com.lambdaschool.shoppingcart.models.User;
import com.lambdaschool.shoppingcart.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingcartApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
        assertEquals(2, userService.findAll().size());
    }

    @Test
    public void findUserById() {
        assertEquals("barnbarn", userService.findUserById(1).getUsername());
    }

    @Test
    public void delete() {
        userService.delete(3);
        assertEquals(2, userService.findAll().size());
    }

    @Test
    public void save() {

        List<UserRoles> roles = new ArrayList<>();

        User user = new User("testusername", "testpassword", "", roles);

        User newUser = userService.save(user);

        assertEquals("testusername", newUser.getUsername());
    }

    @Test
    public void deleteUserRole() {
    }

    @Test
    public void addUserRole() {
    }
}