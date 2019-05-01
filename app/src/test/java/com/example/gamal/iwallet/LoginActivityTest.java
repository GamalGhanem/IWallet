package com.example.gamal.iwallet;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Test
    public void login() {

        LoginActivity obj = new LoginActivity();

        //not registered email
        String email = "Gaber@me.com";
        String password = "Any_password";
        boolean res[] = {obj.login(email, password)};
        boolean expected[] = {false};
        assertArrayEquals(expected, res);

        //registered email but wrong password
        String fEmail = "fady@me.com";
        String fPassword = "karim";
        boolean fRes[] = {obj.login(fEmail, fPassword)};
        boolean fExpected[] = {false};
        assertArrayEquals(fExpected, fRes);

        //registered email but correct password
        String gEmail = "gamal@me.com";
        String gPassword = "gamal";
        boolean gRes[] = {obj.login(gEmail, gPassword)};
        boolean gExpected[] = {false};
        assertArrayEquals(gExpected, gRes);

    }
}