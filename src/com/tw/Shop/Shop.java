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
    List<String> processedItems = new ArrayList<>();
    Map<Item, Integer> itemQuantityMap = new HashMap<>();
    for (String itemName : itemsToBuy) {
      if (!processedItems.contains(itemName)) {
        updateItemQuantityMap(itemsToBuy, itemName, itemQuantityMap);
        processedItems.add(itemName);
      }
    }
    return itemQuantityMap;
  }

  private void updateItemQuantityMap(List<String> itemsToBuy, String itemName,
                                     Map<Item, Integer> itemQuantityMap) {
    int count = calculateCountFor(itemName, itemsToBuy);
    itemQuantityMap.put(retrieveItemObjectFor(itemName), count);
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