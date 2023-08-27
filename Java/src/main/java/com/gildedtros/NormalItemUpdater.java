package com.gildedtros;

public class NormalItemUpdater extends SpeedCalculator implements Updater{
    @Override
    public void update(Item item) {
        int decreaseSpeed = calculateSpeed(item);
        item.quality -= decreaseSpeed;
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
