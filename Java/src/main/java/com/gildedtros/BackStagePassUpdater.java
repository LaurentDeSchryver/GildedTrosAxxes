package com.gildedtros;

public class BackStagePassUpdater implements Updater{
    @Override
    public void update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            updateQualityBackstagePasses(item);
        }
        item.sellIn--;
    }

    private void updateQualityBackstagePasses(Item item) {
        //if concert is within 5 days, increase quality by 3, within 10 by 2, otherwise just by 1
        if (item.sellIn <= 5) {
            item.quality += 3;
        } else if (item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality++;
        }
    }
}
