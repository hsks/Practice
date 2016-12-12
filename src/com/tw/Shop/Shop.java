package com.tw.Shop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Shop {
  private List<Item> items;

  Shop(List<Item> items) {
    this.items = items;
  }

  int price(String itemsString) {
    int total = 0;
    List<String> itemsToBuy = Arrays.asList(itemsString.split(""));
    try {
      Map<Item, Integer> itemQuantityMap = countOfItems(itemsToBuy);
      for (Item item : itemQuantityMap.keySet()) {
        total += item.priceForQuantity(itemQuantityMap.get(item));
      }
    } catch (ItemNotFoundException ex) {
      System.out.println(ex);
    }
    return total;
  }

  private Map<Item, Integer> countOfItems(List<String> itemsToBuy) throws ItemNotFoundException {
    Map<Item, Integer> itemQuantityMap = new HashMap<>();
    for (String itemName : itemsToBuy) {
      Item item = retrieveItemObjectFor(itemName);
      if (itemQuantityMap.containsKey(item)) {
        int previousCountForItem = itemQuantityMap.get(item);
        itemQuantityMap.put(item, previousCountForItem + 1);
        continue;
      }
      itemQuantityMap.put(item, 1);
    }
    return itemQuantityMap;
  }

  private Item retrieveItemObjectFor(String itemName) throws ItemNotFoundException {
    for (Item item : items) {
      if (item.hasName(itemName))
        return item;
    }
    throw new ItemNotFoundException("The requested item was not found");
  }
}