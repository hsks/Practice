package com.tw.Shop;

class Item {
  private String itemName;
  private int unitPrice;
  private DiscountedPrice discountedPrice;

  Item(String itemName, int unitPrice, DiscountedPrice discountedPrice) {
    this.itemName = itemName;
    this.unitPrice = unitPrice;
    this.discountedPrice = discountedPrice;
  }

  Item(String name, int unitPrice) {
    itemName = name;
    this.unitPrice = unitPrice;
    discountedPrice = new DiscountedPrice(0, 0);
  }

  boolean hasName(String itemName) {
    return this.itemName.equalsIgnoreCase(itemName);
  }

  int priceForQuantity(Integer quantity) {
    return discountedPrice.getPrice() != 0 ?
        (quantity / discountedPrice.getQuantity()) * discountedPrice.getPrice() +
            (quantity % discountedPrice.getQuantity()) * unitPrice
        : unitPrice * quantity;
  }
}