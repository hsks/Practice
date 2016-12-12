package com.tw.Shop;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShopTest {
  private Shop shop;

  @Before
  public void setup() {
    shop = aShop();
  }

  private Shop aShop() {
    return new Shop(Arrays.asList(
        item("A", 50, new DiscountedPrice(3, 130)),
        item("B", 30, new DiscountedPrice(2, 45)),
        item("C", 20),
        item("D", 15)));
  }

  @Test
  public void shouldCalculateCorrectPriceOfItemA() {
    assertEquals(50, shop.price("A"));
  }

  @Test
  public void shoudlCalculateCorrectPriceOfItemB() {
    assertEquals(30, shop.price("B"));
  }

  @Test
  public void shouldCalculatePriceForMultipleItems() {
    assertEquals(100, shop.price("BAC"));
  }

  @Test
  public void shouldCalculateTotalBasedOnSpecialPricingForSomeItem() {
    assertEquals(45, shop.price("BB"));
  }

  @Test
  public void shouldCalculateTotalBasedOnSpecialPricingForMultipleItems() {
    assertEquals(130, shop.price("AAA"));
  }

  @Test
  public void shouldCalculateTotalUsingBothSpecialAndNormalPrices() {
    assertEquals(1350, shop.price("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
  }


  private Item item(String name, int unitPrice) {
    return new Item(name, unitPrice);
  }

  private Item item(String itemName, int unitPrice, DiscountedPrice discountedPrice) {
    return new Item(itemName, unitPrice, discountedPrice);
  }
}