package com.tw.Shop;

class Item {
  private String itemName;
  private int unitPrice;
  private MultiPrice multiPrice;

  Item(String itemName, int unitPrice, MultiPrice multiPrice) {
    this.itemName = itemName;
    this.unitPrice = unitPrice;
    this.multiPrice = multiPrice;
  }

  boolean hasName(String itemName) {
    return this.itemName.equalsIgnoreCase(itemName);
  }

  int getPrice() {
    return unitPrice;
  }
}
