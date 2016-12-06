package com.tw.Shop;

import java.util.*;

class Shop {
  private List<Item> items;

  Shop(List<Item> items) {
    this.items = items;
  }

  int price(String itemsString) {
    int total = 0;
    Map<Item, Integer> itemQuantity = countItems(itemsString);
    for (Item item : itemQuantity.keySet()
        ) {
      total += item.priceForQuantity(itemQuantity.get(item));
    }
    return total;
  }

  private Map<Item, Integer> countItems(String itemsString) {
    List<String> itemsToBuy = Arrays.asList(itemsString.split(""));
    Map<Item, Integer> countOfItems = new HashMap<>();
    for (String itemName : itemsToBuy
        ) {
      int count = calculateCountFor(itemsToBuy, itemName);
      removeItemFromItemList(itemsToBuy, itemName);
      countOfItems.put(itemObjectFor(itemName), count);
    }
    return countOfItems;
  }

  private Item itemObjectFor(String itemName) {
    for (Item item : items
        ) {
      if (item.hasName(itemName))
        return item;
    }
    throw new IllegalArgumentException("Invalid Item Name");
  }

  private int calculateCountFor(List<String> itemsToBuy, String itemName) {
    int count = 0;
    for (String name : itemsToBuy
        ) {
      if (name.equalsIgnoreCase(itemName)) count++;
    }
    return count;
  }

  private void removeItemFromItemList(List<String> itemsToBuy, String itemName) {
    ArrayList<String> listOfItemNames = new ArrayList<>(itemsToBuy);
    while (listOfItemNames.remove(itemName));
  }

}
