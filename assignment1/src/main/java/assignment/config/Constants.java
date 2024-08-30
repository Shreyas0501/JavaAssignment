package assignment.config;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The Constants class holds various constant values used throughout the application.
 * These include tax rates, thresholds, and other configuration settings that
 * do not change during runtime.
 * The purpose of this class is to centralize all constant values to
 * maintain ease of updates and clarity in the application code.
 */
public class Constants {
  public static final int NUMBER_OF_COMMAND_LINE_INPUTS = 8;
  public static final double TAX_RATE_ON_RAW_ITEM = 0.125;
  public static final double TAX_RATE_ON_MANUFACTURED_ITEM = 0.125;
  public static final double TAX_RATE_ON_IMPORTED_ITEM = 0.1;
  public static final double ADDITIONAL_TAX_ON_IMPORTED_ITEM_BELOW_100 = 10;
  public static final double ADDITIONAL_TAX_ON_IMPORTED_ITEM_BETWEEN_100_TO_200 = 10;
  public static final double ADDITIONAL_TAX_RATE_ON_IMPORTED_ITEM_ABOVE_200 = 0.05;
  public static final double IMPORTED_TAX_THRESHOLD_100 = 100;
  public static final double IMPORTED_TAX_THRESHOLD_200 = 200;
  public static final double ADDITIONAL_MANUFACTURED_TAX_RATE = 0.02;
  public static Scanner SCANNER = new Scanner(System.in);
  public static final Set<String> RESTRICTED_NAMES =
      new HashSet<>(Set.of("name", "type", "price", "quantity"));
}