package com.tw.Shop;

import java.util.List;

class Shop {
  private List<Item> items;

  Shop(List<Item> items) {
    this.items = items;
  }

  int price(String itemsString) {
    String itemsToBuy[] = itemsString.split("");
    int total = 0;
    for (String currentItemName : itemsToBuy) {
      total = updateTotalForItem(total, currentItemName);
    }
    return total;
  }

  private int updateTotalForItem(int total, String currentItemName) {
    for (Item item : items
        ) {
      if (item.hasName(currentItemName)) {
        total += item.getPrice();
        break;
      }
    }
    return total;
  }
}
