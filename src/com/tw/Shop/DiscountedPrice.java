package com.tw.Shop;

class DiscountedPrice {
  private int price;
  private int quantity;

  DiscountedPrice(int quantity, int price) {
    this.price = price;
    this.quantity = quantity;
  }

  int getQuantity() {
    return quantity;
  }

  int getPrice() {
    return price;
  }
}