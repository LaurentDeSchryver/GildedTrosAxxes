package com.gildedtros;

public class UpdaterFactory {
    private static final Updater goodWineUpdater = new GoodWineUpdater();
    private static final Updater backstagePassUpdater = new BackStagePassUpdater();
    private static final Updater normalItemUpdater = new NormalItemUpdater();
    private static final Updater smellyItemUpdater = new SmellyItemUpdater();
    private static final Updater legendaryItemUpdater = new LegendaryItemUpdater();

    public static Updater getYourUpdater(Item item){
        if ("Good Wine".equals(item.name)) {
            return goodWineUpdater;
        } else if (isBackStagePass(item)) {
            return backstagePassUpdater;
        } else if ("B-DAWG Keychain".equals(item.name)) {
            return legendaryItemUpdater;
        } else if (isSmellyItem(item)) {
            return smellyItemUpdater;
        } else {
            return normalItemUpdater;
        }
    }

    private static boolean isBackStagePass(Item item) {
        return item.name.contains("Backstage passes");
    }

    private static boolean isSmellyItem(Item item) {
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
}
