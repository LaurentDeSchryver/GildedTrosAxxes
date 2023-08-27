package com.gildedtros;

public  abstract class SpeedCalculator {

    protected int calculateSpeed(Item item) {
        return item.sellIn <= 0 ? 2 : 1;
    }
}
