package assignment.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Represents a user with basic details such as
 * name, age, roll number, address, and enrolled courses.
 * This class is immutable once constructed.
 */
public class User implements Serializable {

  private String fullName;
  private int age;
  private String address;
  private String rollNumber;
  private Set<String> courses;

  /**
   * Constructs a new User with the specified details.
   *
   * @param fullName The full name of the user.
   * @param age The age of the user.
   * @param rollNumber The roll number of the user.
   * @param address The address of the user.
   * @param courses A set of courses the user is enrolled in.
   */
  public User(final String fullName, final int age,
              final String rollNumber, final String address, final Set<String> courses) {
    this.fullName = fullName;
    this.age = age;
    this.address = address;
    this.rollNumber = rollNumber;
    this.courses = courses;
  }

  /**
   * Default constructor for creating an empty User object.
   */
  public User() {
    // Default constructor
  }

  /**
   * Sets the full name of the user.
   * @param fullName The new full name of the user.
   */
  public void setFullName(final String fullName) {
    this.fullName = fullName;
  }

  /**
   * Sets the age of the user.
   * @param age The new age of the user.
   */
  public void setAge(final int age) {
    this.age = age;
  }

  /**
   * Sets the roll number of the user.
   * @param rollNumber The new roll number of the user.
   */
  public void setRollNumber(final String rollNumber) {
    this.rollNumber = rollNumber;
  }

  /**
   * Sets the address of the user.
   * @param address The new address of the user.
   */
  public void setAddress(final String address) {
    this.address = address;
  }

  /**
   * Sets the courses the user is enrolled in.
   * @param courses The new set of courses the user is enrolled in.
   */
  public void setCourses(final Set<String> courses) {
    this.courses = courses;
  }

  /**
   * Gets the full name of the user.
   * @return The user's full name.
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Gets the age of the user.
   *
   * @return The user's age.
   */
  public int getAge() {
    return age;
  }

  /**
   * Gets the address of the user.
   * @return The user's address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets the roll number of the user.
   * @return The user's roll number.
   */
  public String getRollNumber() {
    return rollNumber;
  }

  /**
   * Gets the set of courses the user is enrolled in.
   * @return A set of courses.
   */
  public Set<String> getCourses() {
    return courses;
  }

}
