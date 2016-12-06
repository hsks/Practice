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
    Map<Item, Integer> itemQuantityMap = countOfItems(itemsToBuy);
    for (Item item : itemQuantityMap.keySet()) {
      total += item.priceForQuantity(itemQuantityMap.get(item));
    }
    return total;
  }

  private Map<Item, Integer> countOfItems(List<String> itemsToBuy) {
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

}