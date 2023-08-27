package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    public void updateItem(Item item) {
        if ("Good Wine".equals(item.name)) {
            updateGoodWine(item);
        } else if (isBackStagePass(item)) {
            updateBackStagePass(item);
        } else if ("B-DAWG Keychain".equals(item.name)) {
            updateLegendary(item);
        } else if (isSmellyItem(item)) {
            updateSmellyItem(item);
        } else {
            updateNormalItem(item);
        }
    }

    private void updateNormalItem(Item item) {
        int decreaseSpeed = calculateSpeed(item);
        item.quality -= decreaseSpeed;
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void updateSmellyItem(Item item) {
        int decreaseSpeed = calculateSpeed(item);

        item.quality -= 2 * decreaseSpeed;
        //if decreasespeed is 2 and quality goes to -1, reset to 0 because quality never can get lower than 0
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private int calculateSpeed(Item item) {
        return item.sellIn <= 0 ? 2 : 1;
    }

    private void updateLegendary(Item item) {
        //do nothing, as legendary items never get sold or increased/decreased in value
    }

    private void updateBackStagePass(Item item) {
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

    private void updateGoodWine(Item item) {
        int increaseSpeed = calculateSpeed(item);
        item.quality += increaseSpeed;
        //if quality with increase of 2 goes over bounderies of 50, set it to 50
        if (item.quality > 50) {
            item.quality = 50;
        }
        item.sellIn--;
    }

    private boolean isSmellyItem(Item item) {
        switch (item.name) {
            case "Duplicate Code":
                return true;
            case "Long Methods":
                return true;
            case "Ugly Variable Names":
                return true;
            default:
                return false;
        }
    }

    private boolean isBackStagePass(Item item) {
        return item.name.contains("Backstage passes");
    }
}