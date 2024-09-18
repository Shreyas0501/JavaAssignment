package assignment.controller;

import static assignment.config.Constants.NUMBER_OF_COMMAND_LINE_INPUTS;

/**
 * Validator class for checking the number of command line input arguments.
 */
public final class NumberOfInputValidator {

  private NumberOfInputValidator() {
    throw new UnsupportedOperationException(
        "NumberOfInputValidator is a utility class and cannot be instantiated");
  }

  /**
   * Validates the number of input details provided.
   *
   * @param listOfItemDetails Array of command line arguments.
   * @return true if the number of inputs matches the expected number; false otherwise.
   */
  public static boolean isValidNumberOfInputItemDetails(final String... listOfItemDetails) {
    return listOfItemDetails.length == NUMBER_OF_COMMAND_LINE_INPUTS;
  }
}