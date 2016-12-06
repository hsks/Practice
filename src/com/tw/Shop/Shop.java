package com.tw.Shop;

import java.util.*;

class Shop {
  private List<Item> items;

  Shop(List<Item> items) {
    this.items = items;
  }

  int price(String itemsString) {
    int total = 0;
    Map<Item, Integer> itemQuantityMap = countOfItems(itemsString);
    for (Item item : itemQuantityMap.keySet()
        ) {
      total += item.priceForQuantity(itemQuantityMap.get(item));
    }
    return total;
  }

  private Map<Item, Integer> countOfItems(String itemsString) {
    List<String> itemsToBuy = Arrays.asList(itemsString.split(""));
    Map<Item, Integer> countOfItems = new HashMap<>();
    calculateItemCountAndRemoveItem(itemsToBuy, countOfItems);
    return countOfItems;
  }

  private void calculateItemCountAndRemoveItem(List<String> itemsToBuy, Map<Item, Integer> countOfItems) {
    for (String itemName : itemsToBuy
        ) {
      int count = calculateCountFor(itemName, itemsToBuy);
      removeItemFromItemList(itemsToBuy, itemName);
      countOfItems.put(retrieveItemObjectFor(itemName), count);
    }
  }

  private Item retrieveItemObjectFor(String itemName) {
    for (Item item : items
        ) {
      if (item.hasName(itemName))
        return item;
    }
    return dummyItemWithZeroPrice();
  }

  private Item dummyItemWithZeroPrice() {
    return new Item("", 0, new MultiPrice(0, 0));
  }

  private int calculateCountFor(String itemName, List<String> itemsToBuy) {
    int count = 0;
    for (String name : itemsToBuy
        ) {
      if (name.equalsIgnoreCase(itemName)) count++;
    }
    return count;
  }

  private void removeItemFromItemList(List<String> itemsToBuy, String itemName) {
    ArrayList<String> listOfItemNames = new ArrayList<>(itemsToBuy);
    while (listOfItemNames.remove(itemName)) ;
  }

}
