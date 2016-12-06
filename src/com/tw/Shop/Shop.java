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
    for (Item item : itemQuantityMap.keySet()) {
      total += item.priceForQuantity(itemQuantityMap.get(item));
    }
    return total;
  }

  private Map<Item, Integer> countOfItems(String itemsString) {
    List<String> itemsToBuy = Arrays.asList(itemsString.split(""));
    return countOfItems(itemsToBuy);
  }

  private Map<Item, Integer> countOfItems(List<String> itemsToBuy) {
    Map<Item, Integer> countOfItems = new HashMap<>();
    List<String> processedItems = new ArrayList<>();
    for (String itemName : itemsToBuy) {
      addCountToMapIfNotYetAdded(itemsToBuy, countOfItems, processedItems, itemName);
    }
    return countOfItems;
  }

  private void addCountToMapIfNotYetAdded(List<String> itemsToBuy, Map<Item, Integer> countOfItems,
                                          List<String> processedItems, String itemName) {
    int count = calculateCountFor(itemName, itemsToBuy);
    if (processedItems.contains(itemName))
      return;
    processedItems.add(itemName);
    countOfItems.put(retrieveItemObjectFor(itemName), count);
  }

  private Item retrieveItemObjectFor(String itemName) {
    for (Item item : items) {
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
    for (String name : itemsToBuy) {
      if (name.equalsIgnoreCase(itemName)) count++;
    }
    return count;
  }

}