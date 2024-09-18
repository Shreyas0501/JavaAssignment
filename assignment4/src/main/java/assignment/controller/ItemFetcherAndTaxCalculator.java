package assignment.controller;

import assignment.controller.threads.Consumer;
import assignment.controller.threads.Producer;

/**
 * The ItemFetcherAndTaxCalculator class is responsible for managing the
 * execution of producer and consumer threads. The producer fetches items from
 * the database, while the consumer processes these items to calculate taxes.
 */
public class ItemFetcherAndTaxCalculator {

  /**
   * Starts producer and consumer threads to fetch items from the database
   * and calculate taxes. Waits for both threads to finish.
   */
  public static void fetchItemFromDataBaseAndCalculateTax() {
    Thread producerThread = new Thread(new Producer());
    Thread consumerThread = new Thread(new Consumer());

    producerThread.start();
    consumerThread.start();

    try {
      producerThread.join();
      consumerThread.join();
    } catch (InterruptedException e) {
      System.out.println("Error in thread join " + e);
    }
  }
}