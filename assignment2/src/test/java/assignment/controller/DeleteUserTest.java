package assignment.controller;

import assignment.model.User;
import assignment.view.DisplayUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;
import static assignment.config.SharedData.SCANNER;
import static org.junit.jupiter.api.Assertions.*;

class DeleteUserTest {


  @AfterEach
  void tearDown() {
    System.setIn(System.in);
  }

  @Test
  void testDeleteUserDetails_Success() {

    ROLL_NUMBER_TO_USER_MAP.put("1243", new User());

//    String simulatedInput = "1\n1\n1243\n1\n1\n";
//    InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
//    System.setIn(in);


    try (var mockedDeleteUser = Mockito.mockStatic(DeleteUser.class)) {
//      mockedDeleteUser.when(DeleteUser::readRollNumber).thenReturn("1243");
      Mockito.when(DeleteUser.readRollNumber()).thenReturn("1243");
      mockedDeleteUser.when(DeleteUser::deleteUserDetails).thenCallRealMethod();
      DeleteUser.deleteUserDetails();

    }

    assertEquals(ROLL_NUMBER_TO_USER_MAP.size() , 0);
  }
}
