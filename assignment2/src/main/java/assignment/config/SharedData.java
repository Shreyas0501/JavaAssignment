package assignment.config;

import assignment.controller.AddUser;
import assignment.model.User;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SharedData class provides static data structures, utilities used across the application.
 * It includes a sorted set of users, a map of roll numbers to users, and a scanner.
 */
public class SharedData {
  public static final Set<User> USER_LIST = new TreeSet<>(
      Comparator.comparing(User::getFullName).thenComparing(User::getRollNumber)
  );
  public static final Map<String, User> ROLL_NUMBER_TO_USER_MAP = new ConcurrentHashMap<>();
  public static final Scanner SCANNER = new Scanner(System.in);
  public static final AddUser ADD_USER_OBJ = new AddUser();
}