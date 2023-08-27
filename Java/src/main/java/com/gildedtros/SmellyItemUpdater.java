package com.gildedtros;

public class SmellyItemUpdater extends SpeedCalculator implements Updater{
    @Override
    public void update(Item item) {
        int decreaseSpeed = calculateSpeed(item);

        item.quality -= 2 * decreaseSpeed;
        //if decreasespeed is 2 and quality goes to -1, reset to 0 because quality never can get lower than 0
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
