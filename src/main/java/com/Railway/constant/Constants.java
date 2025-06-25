package com.Railway.constant;

import com.Railway.untilities.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String BASE_URL = "http://saferailway.somee.com/";
    public static final String MAILBOX_URL = "https://www.guerrillamail.com/";

    public static class AccountInfo{
        public static final String USERNAME = "saveasd68@gmail.com";
        public static final String PASSWORD = "12345678";
        public static final String EMAIL_INACTIVE = "abcc12345@sharklasers.com";
        public static final String NEW_EMAIL = "abcc1234578"+ LocalDateTime.now().format(Config.HH_mm_ss) + "@sharklasers.com";
        public static final String PID = "123456789";
        public static final String RESET_PASSWORD_EMAIL = "test123456@sharklasers.com";
    }

    public static class Message {
        public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "Your password has been updated";
        public static final String LOGIN_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
        public static final String LOGIN_SEVERAL_TIME_ERROR_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        public static final String LOGIN_INVALID_USERNAME_PASSWORD_ERROR_MESSAGE = "Invalid username or password. Please try again.";
        public static final String REGISTER_SUCCESS_MESSAGE = "Thank you for registering your account";
        public static final String REGISTER_ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
        public static final String REGISTER_PASSWORD_LENGTH_ERROR_MESSAGE = "Invalid password length.";
        public static final String REGISTER_PID_LENGTH_ERROR_MESSAGE = "Invalid ID length.";
        public static final String HOME_WELCOME_MESSAGE = "Welcome " + Constants.AccountInfo.USERNAME;

        public static final String CHANGE_PASSWORD_FORM_ERROR_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        public static final String CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE = "The password reset token is invalid.";
    }


    public static class PageHeading {
        public static final String LOGIN_HEADING_TEXT = "Login page";
        public static final String MY_TICKET_HEADING_TEXT = "Manage ticket";
        public static final String CHANGE_PASSWORD_HEADING_TEXT = "Change password";
    }


    public static class TabName{
        public static final String HOME ="Home";
        public static final String LOGIN ="Login";
        public static final String REGISTER ="Register";
        public static final String BOOK_TICKET ="Book ticket";
        public static final String MY_TICKET ="My ticket";
        public static final String CHANGE_PASSWORD ="Change password";
        public static final String LOGOUT ="Log out";
    }




}
