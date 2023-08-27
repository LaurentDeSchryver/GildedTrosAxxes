package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void test_GoodWine_Increase_quality() {
        Item[] items = new Item[] { new Item("Good Wine", 2, 0) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 9; i++) {
            app.updateQuality();
        }
        assertEquals(16, app.items[0].quality);
        assertEquals(-7, app.items[0].sellIn);
    }

    @Test
    void test_GoodWine_Increase_quality_max_50() {
        Item[] items = new Item[] { new Item("Good Wine", 2, 49) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 9; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);
        assertEquals(-7, app.items[0].sellIn);
    }

    @Test
    void test_legendary_keeps_quality() {
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 2, 80) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 9; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void test_backStagePasses_sold_under_10() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 15, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 7; i++) {
            app.updateQuality();
        }
        assertEquals(29, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    void test_backStagePasses_sold_under_5() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 15, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 12; i++) {
            app.updateQuality();
        }
        assertEquals(41, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void test_backStagePasses_sold_above_10() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 15, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 3; i++) {
            app.updateQuality();
        }
        assertEquals(23, app.items[0].quality);
        assertEquals(12, app.items[0].sellIn);

    }

    @Test
    void test_backStagePasses_drop_to_0() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 3, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 7; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
        assertEquals(-4, app.items[0].sellIn);

    }
    @Test
    void test_normalItem_decreases_positive_selling() {
        Item[] items = new Item[] { new Item("pasta", 15, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 3; i++) {
            app.updateQuality();
        }
        assertEquals(17, app.items[0].quality);
        assertEquals(12, app.items[0].sellIn);

    }

    @Test
    void test_normalItem_decreases_negative_selling() {
        Item[] items = new Item[] { new Item("pasta", 3, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 7; i++) {
            app.updateQuality();
        }
        assertEquals(9, app.items[0].quality);
        assertEquals(-4, app.items[0].sellIn);

    }

    @Test
    void test_smellyItem_decreases_negative_selling_to_0() {
        Item[] items = new Item[] { new Item("Duplicate Code", 3, 20) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 7; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
        assertEquals(-4, app.items[0].sellIn);

    }

    @Test
    void test_normalItem_decreases_negative_quality() {
        Item[] items = new Item[] { new Item("pasta", 3, 2) };
        GildedTros app = new GildedTros(items);
        for(int i = 0; i < 7; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
        assertEquals(-4, app.items[0].sellIn);

    }
}
