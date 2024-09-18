package assignment.config;

import assignment.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SharedData {

  public static final Item TERMINATION_ITEM  =
      new Item("terminate", "terminate", -1, -1, -1);
  public static final List<Item> PROCESSED_ITEM_LIST = new ArrayList<>();
}