package com.management.product.entity;

import com.management.product.enums.UserRole;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr on 08.09.2017.
 */
public class UserTest {

    @Test
    public void toStringTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        String toString = testUser.toString();
        assertTrue(toString.contains("Name")
                && toString.contains("Password")
                && toString.contains("ADMIN"));
    }

    @Test
    public void equals() throws Exception {
        User testUser1 = new User("Name", "Password", UserRole.ADMIN);
        User testUser2 = new User("Name", "Password", UserRole.ADMIN);
        assertEquals(testUser1, testUser2);
        testUser1.setUsername("NewName");
        assertNotEquals(testUser1, testUser2);
        testUser2.setUsername("NewName");
        assertEquals(testUser1, testUser2);
        testUser1.setPassword("NewPassword");
        assertNotEquals(testUser1, testUser2);
        testUser2.setPassword("NewPassword");
        assertEquals(testUser1, testUser2);
        testUser1.setRole(UserRole.USER);
        assertNotEquals(testUser1, testUser2);
        assertNotEquals(testUser1, null);
        assertNotEquals(testUser1, new String("String"));
    }

    @Test
    public void hashCodeTest() throws Exception {
        User testUser1 = new User("Name", "Password", UserRole.ADMIN);
        User testUser2 = new User("Name", "Password", UserRole.ADMIN);
        assertTrue(testUser1.hashCode() == testUser2.hashCode());
        testUser1.setPassword("NewPassword");
        assertFalse(testUser1.hashCode() == testUser2.hashCode());
    }

    @Test
    public void isAccountNonExpiredTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        testUser.setLocked(false);
        assertTrue(testUser.isAccountNonExpired());
        testUser.setLocked(true);
        assertFalse(testUser.isAccountNonExpired());
    }

    @Test
    public void isAccountNonLockedTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        testUser.setLocked(false);
        assertTrue(testUser.isAccountNonLocked());
        testUser.setLocked(true);
        assertFalse(testUser.isAccountNonLocked());
    }

    @Test
    public void isCredentialNonExpiredTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        testUser.setLocked(false);
        assertTrue(testUser.isCredentialsNonExpired());
        testUser.setLocked(true);
        assertFalse(testUser.isCredentialsNonExpired());
    }

    @Test
    public void isEnabledTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        testUser.setLocked(false);
        assertTrue(testUser.isEnabled());
        testUser.setLocked(true);
        assertFalse(testUser.isEnabled());
    }


    @Test
    public void getAuthoritiesTest() throws Exception {
        User testUser = new User("Name", "Password", UserRole.ADMIN);
        Collection<GrantedAuthority> grantedAuthorities = testUser.getAuthorities();
        assertNotNull(grantedAuthorities);
        assertTrue(grantedAuthorities.size() == 1);
    }

    @Test
    public void getAndSetNameTest() throws Exception {
        User testUser = new User();
        assertEquals(testUser.getUsername(), "");
        testUser.setUsername(null);
        assertEquals(testUser.getUsername(), "");
        testUser.setUsername(" ");
        assertEquals(testUser.getUsername(), "");
        testUser.setUsername("NewName");
        assertEquals(testUser.getUsername(), "NewName");
    }

    @Test
    public void getAndSetPasswordTest() throws Exception {
        User testUser = new User();
        assertEquals(testUser.getPassword(), "");
        testUser.setPassword(null);
        assertEquals(testUser.getPassword(), "");
        testUser.setPassword(" ");
        assertEquals(testUser.getPassword(), "");
        testUser.setPassword("NewPassword");
        assertEquals(testUser.getPassword(), "NewPassword");
    }

    @Test
    public void getAndSetRoleTest() throws Exception {
        User testUser = new User();
        assertEquals(testUser.getRole(), UserRole.USER);
        testUser.setRole(null);
        assertEquals(testUser.getRole(), UserRole.USER);
        testUser.setRole(UserRole.ADMIN);
        assertTrue(testUser.getRole().equals(UserRole.ADMIN));
    }

    @Test
    public void getAndSetLockedTest() throws Exception {
        User testUser = new User();
        testUser.setLocked(true);
        assertTrue(testUser.isLocked());
        testUser.setLocked(false);
        assertFalse(testUser.isLocked());
    }

}