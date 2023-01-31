package com.java.maven.UserValidationLambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserValidatorTest
{
    @Test
    public void givenAllDetails_WhenAllProper_ShouldReturnTrue() {
        try {
            boolean isValid = UserValidator.validate("Rahul","Das","rahul123@gmail.com","91 9374939953","Rahul@1324");
            assertEquals(true,isValid);
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FirstNameInCorrect() {
        try {
            UserValidator.validate("Rahul$","Das","rahul123@gmail.com","91 9374939953","rahul@1324");
        } catch (InvalidUserException e) {
            assertEquals(InvalidUserException.ExceptionType.INVALID_FIRST_NAME, e.type);
        }
    }

    @Test
    public void LastNameInCorrect() {
        try {
            UserValidator.validate("Rahul","Ds","rahul123@gmail.com","91 9374939953","Mohan@1324");
        } catch (InvalidUserException e) {
            assertEquals(InvalidUserException.ExceptionType.INVALID_LAST_NAME, e.type);
        }
    }

    @Test
    public void EmailInvalid() {
        try {
            UserValidator.validate("Rahul","Das","rahul123@","91 9374939953","Rahul@1324");
        } catch (InvalidUserException e) {
            assertEquals(InvalidUserException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }

    @Test
    public void MobileInvalid() {
        try {
            UserValidator.validate("Rahul","Das","rahul123@gmail.com","91 93749","Rahul@1324");
        } catch (InvalidUserException e) {
            assertEquals(InvalidUserException.ExceptionType.INVALID_MOBILE, e.type);
        }
    }

    @Test
    public void PasswordInvalid() {
        try {
            UserValidator.validate("Rahul","Das","rahul123@gmail.com","91 9374939953","Rahul");
        } catch (InvalidUserException e) {
            assertEquals(InvalidUserException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }
}