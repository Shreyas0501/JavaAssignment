package assignment.controller;

import assignment.model.User;
import org.junit.jupiter.api.Test;

import static assignment.config.Constants.MINIMUM_NUMBER_OF_COURSES;
import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;
import static org.junit.jupiter.api.Assertions.*;

class ValidateUserTest {

  @Test
  void testValidateFullName_Valid() {
    assertDoesNotThrow(() -> ValidateUser.validateFullName("John Doe"));
  }

  @Test
  void testValidateFullName_Empty() {
    Exception exception = assertThrows(CustomException.class, () -> ValidateUser.validateFullName(""));
    assertEquals("User full name cannot be empty.", exception.getMessage());
  }

  @Test
  void testValidateAge_Negative() {
    Exception exception = assertThrows(CustomException.class, () -> ValidateUser.validateAge("-1"));
    assertEquals("Age should be a non-negative number.", exception.getMessage());
  }

  @Test
  void testValidateRollNumber_Duplicate() {
    ROLL_NUMBER_TO_USER_MAP.clear();
    ROLL_NUMBER_TO_USER_MAP.put("1245", new User());  // Adding a roll number to simulate a duplicate
    Exception exception = assertThrows(CustomException.class, () -> ValidateUser.validateRollNumber("1245"));
    assertEquals("Duplicate roll number not allowed.", exception.getMessage());
  }

  @Test
  void testValidateCourses_InsufficientCourses() {
    String[] insufficientCourses = {"A", "B", "C"};
    Exception exception = assertThrows(CustomException.class, () -> ValidateUser.validateCourses(insufficientCourses));
    assertEquals("At least " + MINIMUM_NUMBER_OF_COURSES + " courses must be chosen.", exception.getMessage());
  }

}