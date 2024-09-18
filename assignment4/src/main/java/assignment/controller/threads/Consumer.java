package assignment.controller.threads;

import static assignment.config.DataBaseConstants.BLOCKING_QUEUE;
import static assignment.config.SharedData.PROCESSED_ITEM_LIST;
import static assignment.config.SharedData.TERMINATION_ITEM;

import assignment.controller.TaxCalculator;
import assignment.controller.TaxCalculatorFactory;
import assignment.model.Item;

public class Consumer implements Runnable {

  @Override
  public void run() {

    try {
      while (true) {
        Item item  = BLOCKING_QUEUE.take();

        if (item == TERMINATION_ITEM) {
          break;
        }

        final TaxCalculator taxCalculator =
            TaxCalculatorFactory.getTaxCalculator(item.getItemType());
        final double itemTax =
            taxCalculator.calculateItemTax(item.getItemPrice());

        item.setItemTax(itemTax);

        PROCESSED_ITEM_LIST.add(item);
      }
    } catch (Exception e) {
      System.out.println("CONSUMER SIDE ERROR:"
          + " in reading item from blocking queue!\n");
    }

  }

}