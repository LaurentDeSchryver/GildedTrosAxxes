package com.gildedtros;

public class GoodWineUpdater extends SpeedCalculator implements Updater {

    @Override
    public void update(Item item) {
        int increaseSpeed = calculateSpeed(item);
        item.quality += increaseSpeed;
        //if quality with increase of 2 goes over bounderies of 50, set it to 50
        if (item.quality > 50) {
            item.quality = 50;
        }
        item.sellIn--;
    }
}
