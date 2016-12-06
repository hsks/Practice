package com.tw.Shop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShopTest {
  @Test
  public void shouldCalculateCorrectPriceOfItemA() {
    Shop shop = new Shop(Arrays.asList(
        item("A", 50, new MultiPrice(3, 130)),
        item("B", 30, new MultiPrice(2, 45)),
        item("C", 20, new MultiPrice(0, 0))));
    assertEquals(50, shop.price("A"));
  }

  @Test
  public void shoudlCalculateCorrectPriceOfItemB() {
    Shop shop = new Shop(Arrays.asList(
        item("A", 50, new MultiPrice(3, 130)),
        item("B", 30, new MultiPrice(2, 45)),
        item("C", 20, new MultiPrice(0, 0))));
    assertEquals(30, shop.price("B"));
  }

  @Test
  public void shouldCalculatePriceForMultipleItems() {
    Shop shop = new Shop(Arrays.asList(
        item("A", 50, new MultiPrice(3, 130)),
        item("B", 30, new MultiPrice(2, 45)),
        item("C", 20, new MultiPrice(0, 0))));
    assertEquals(100, shop.price("BAC"));
  }


  private Item item(String a, int unitPrice, MultiPrice multiPrice) {
    return new Item(a, unitPrice, multiPrice);
  }
}
