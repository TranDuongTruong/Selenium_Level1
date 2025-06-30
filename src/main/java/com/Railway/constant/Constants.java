package com.Railway.constant;

import com.Railway.untilities.Config;

import java.time.LocalDateTime;

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
        public static final String EMAIL_PREFIX = "email"+LocalDateTime.now().format(Config.HH_mm_ss);
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

        public static final String CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        public static final String CHANGE_PASSWORD_FORM_TOKEN_FIELD_ERROR_MESSAGE = "The password reset token is invalid.";
        public static final String CHANGE_PASSWORD_FORM_PASSWORD_ERROR_MESSAGE = "Could not reset password. Please correct the errors and try again.";
        public static final String CHANGE_PASSWORD_FORM_CONFIRM_PASSWORD_FIELD_ERROR_MESSAGE = "The password confirmation did not match the new password.";

        public static final String BOOK_TICKET_SUCCESS_MESSAGE = "Ticket booked successfully!";


    }


    public static class PageHeading {
        public static final String LOGIN_HEADING_TEXT = "Login page";
        public static final String MY_TICKET_HEADING_TEXT = "Manage ticket";
        public static final String CHANGE_PASSWORD_HEADING_TEXT = "Change password";
        public static final String BOOK_TICKET_HEADING_TEXT = "Book ticket";
        public static final String CHANGE_PASSWORD_FORM_HEADING="Password Change Form";
    }


    public static class TabName{
        public static final String HOME ="Home";
        public static final String LOGIN ="Login";
        public static final String REGISTER ="Register";
        public static final String BOOK_TICKET ="Book ticket";
        public static final String MY_TICKET ="My ticket";
        public static final String CHANGE_PASSWORD ="Change password";
        public static final String LOGOUT ="Log out";
        public static final String TIMETABLE ="Timetable";
    }

    public static class TicketInfo{
        public static final String DEPART_DATE="7/7/2025";
        public static final String DEPART_FROM="Huế";
        public static final String ARRIVE_AT="Quảng Ngãi";
        public static final String SEAT_TYPE="Soft bed with air conditioner";
        public static final int TICKET_AMOUNT=1;


        public static final String DEPART_FROM_TIMETABLE="Huế";
        public static final String ARRIVE_AT_TIMETABLE="Sài Gòn";
    }


    public static class MaiLService{
        public static final String SYSTEM_SENDER="thanhletraining03@gmail.com";
        public static final String ACTIVE_ACCOUNT_TITLE_PREFIX="Please confirm your account";
        public static final String RESET_PASSWORD_TITLE_PREFIX="Please reset your password";
        public static final long TIME_OUT=12000l;
        public static final String API_KEY="f00f0809c12c7c7bb4041dfec5efa22412c4f078061382f110c7a4e757fcba59";

    }


    public static class DataProviderKey{
        public static final String USERNAME_KEY="username";
        public static final String PASSWORD_KEY="password";
        public static final String EMAIL_KEY="email";
        public static final String CONFIRM_PASSWORD_KEY="confirmPassword";
        public static final String REGISTER_PIP_KEY="pid";
        public static final String NEW_PASSWORD_KEY="newPassword";
        public static final String CURRENT_PASSWORD_KEY="currentPassword";

        public static final String TICKET_DEPART_STATION_KEY="departFrom";
        public static final String TICKET_ARRIVE_STATION_KEY="arriveAt";
        public static final String TICKET_DEPART_DATE_KEY="departDate";
        public static final String TICKET_SEAT_TYPE_KEY="seatType";
        public static final String TICKET_AMOUNT_KEY="amount";


        public static final String TIMETABLE_DEPART_FROM_KEY="departFrom";
        public static final String TIMETABLE_ARRIVE_AT_KEY="arriveAt";

    }



}
