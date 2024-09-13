package assignment.controller;

import assignment.config.SharedData;
import assignment.model.User;
import assignment.view.DisplayUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddUserTest {

  private final InputStream originalSystemIn = System.in;

//  @BeforeEach
//  void setUp() {
//    // Clear the user data before each test
//    SharedData.ROLL_NUMBER_TO_USER_MAP.clear();
//  }

  @Test
  void testAddUser() {

    String simulatedInput = "1\n1\n";  // No need for real input
    InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(in);

    try (var mockedAddUser = Mockito.mockStatic(AddUser.class)) {

      Mockito.when(AddUser.readFullName()).thenReturn("name");
      Mockito.when(AddUser.readRollNumber()).thenReturn("1243");
      Mockito.when(AddUser.readAddress()).thenReturn("address");
      Mockito.when(AddUser.readAge()).thenReturn(25);
      Mockito.when(AddUser.readCourses()).thenReturn(new HashSet<>(Arrays.asList("A", "B", "C", "D")));

      AddUser addUser = new AddUser();
      addUser.addUserDetails();

      User expectedUser = new User("name", 25, "1243", "address",
          new HashSet<>(Set.of("A", "B", "C", "D")));

      assertEquals(1, SharedData.ROLL_NUMBER_TO_USER_MAP.size(), "size should be 1");

      DisplayUser.displayAllUser();
    }
  }

}
