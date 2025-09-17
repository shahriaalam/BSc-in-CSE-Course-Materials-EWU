/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticketbookingsystem;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testRegisterUser_Success() {
        boolean result = userManager.registerUser("test_user", "password123", "User");
        assertTrue(result);
        assertEquals(1, userManager.getUsers().size());
    }

    @Test
    public void testRegisterUser_DuplicateUsername() {
        userManager.registerUser("test_user", "password123", "User");
        boolean result = userManager.registerUser("test_user", "anotherPass", "User");
        assertFalse(result);
        assertEquals(1, userManager.getUsers().size());
    }

    @Test
    public void testAddAdmin_WithAdminPrivileges() {
        User admin = new User("admin", "admin123", "Admin");
        userManager.addUserDirectly(admin);

        boolean result = userManager.addAdmin(admin, "new_admin", "pass456");
        assertTrue(result);

        User createdAdmin = userManager.getUsers().stream()
                .filter(u -> u.getUsername().equals("new_admin"))
                .findFirst()
                .orElse(null);

        assertNotNull(createdAdmin);
        assertEquals("Admin", createdAdmin.getRole());
    }

    @Test
    public void testAddAdmin_WithoutAdminPrivileges() {
        User normalUser = new User("user1", "pass123", "User");
        userManager.addUserDirectly(normalUser);

        boolean result = userManager.addAdmin(normalUser, "new_admin", "pass456");
        assertFalse(result);
    }

    @Test
    public void testLoginUser_SuccessfulLogin() {
        userManager.registerUser("test_user", "password123", "User");

        User loggedInUser = userManager.loginUser("test_user", "password123");

        assertNotNull(loggedInUser);
        assertEquals("test_user", loggedInUser.getUsername());
    }

    @Test
    public void testLoginUser_InvalidCredentials() {
        userManager.registerUser("test_user", "password123", "User");

        User result = userManager.loginUser("test_user", "wrongpass");
        assertNull(result);
    }
    
    @Test
public void testGetUserRole() {
    User user = new User("johndoe", "pass123", "User");
    assertEquals("User", user.getRole());
}

    @Test
public void testAuthenticationSuccess() {
    User user = new User("johndoe", "securePass", "User");
    assertTrue(user.authenticate("securePass")); 
}

@Test
public void testAuthenticationFailure() {
    User user = new User("johndoe", "securePass", "User");
    assertFalse(user.authenticate("wrongPass"));
}



@Test
public void testViewBookingHistory_Empty() {
    User user = new User("emptyUser", "pass", "User");
    user.viewBookingHistory();  
}


@Test
public void testRegisterUser_EmptyUsername() {
    boolean result = userManager.registerUser("", "password123", "User");
    assertTrue(result); 
}

@Test
public void testRegisterUser_NullRole() {
    boolean result = userManager.registerUser("nullRoleUser", "password123", null);
    assertTrue(result); 
    User user = userManager.getUsers().get(0);
    assertNull(user.getRole());
}

@Test
public void testLoginUser_UserDoesNotExist() {
    User result = userManager.loginUser("ghostUser", "anyPass");
    assertNull(result);
}

@Test
public void testMultipleUserRegistration() {
    userManager.registerUser("user1", "pass1", "User");
    userManager.registerUser("user2", "pass2", "User");
    userManager.registerUser("admin1", "adminpass", "Admin");

    List<User> users = userManager.getUsers();
    assertEquals(3, users.size());
}


@Test
public void testLoginUser_CaseSensitivity() {
    userManager.registerUser("JohnDoe", "Secret123", "User");

    User result = userManager.loginUser("johndoe", "Secret123");
    assertNull(result); 
}

@Test
public void testAddAdmin_NullAdminUser() {
    boolean result = userManager.addAdmin(null, "newAdmin", "adminpass");
    assertFalse(result);
}


@Test
public void testRegisterUser_DuplicateUsernameWithDifferentCase() {
    userManager.registerUser("UserOne", "pass", "User");
    boolean result = userManager.registerUser("userone", "pass", "User");
    assertTrue(result); 
}

@Test
public void testAddAdmin_DoesNotAffectExistingUser() {
    userManager.registerUser("commonUser", "pass1", "User");
    User admin = new User("admin", "adminpass", "Admin");
    userManager.addUserDirectly(admin);

    boolean result = userManager.addAdmin(admin, "commonUser", "adminpass");
    assertFalse(result); 
}


}
