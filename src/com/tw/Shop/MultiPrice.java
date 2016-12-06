package com.tw.Shop;

class MultiPrice {
  private int price;
  private int quantity;

  MultiPrice(int quantity, int price) {
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