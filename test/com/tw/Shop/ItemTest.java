package com.tw.Shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
  @Test
  public void shouldReturnCorrectPriceForItemWithoutSpecialDiscount() {
    Item anItem = new Item("SomeName", 10, new DiscountedPrice(0, 0));
    assertEquals(10, anItem.priceForQuantity(1));
  }

  @Test
  public void shouldReturnCorrectPriceForItemWithSpecialDiscount() {
    Item anItem = new Item("SomeName", 10, new DiscountedPrice(10, 5));
    assertEquals(10, anItem.priceForQuantity(20));
  }
}
