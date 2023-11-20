package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomItemProperties.CustomItemPropertiesSet3;
import net.minecraft.world.item.Item;

public class CustomItemProperties extends CustomItemPropertiesSet3 {
    public CustomItemProperties tab(Object creativeTab) {
        super.tab(creativeTab);
        return this;
    }

    public CustomItemProperties food(int Nutrition, float SaturationMod, Object Effect, float EffectChance) {
        super.food(Nutrition, SaturationMod, Effect, EffectChance);
        return this;
    }

    public CustomItemProperties durability(int durability) {
        super.durability(durability);
        return this;
    }

    public CustomItemProperties defaultDurability(int defaultDurability) {
        super.defaultDurability(defaultDurability);
        return this;
    }

    public CustomItemProperties stacksTo(int stackLimit) {
        super.stacksTo(stackLimit);
        return this;
    }

    public CustomItemProperties craftRemainder(Object item) {
        super.craftRemainder(item);
        return this;
    }

    public CustomItemProperties rarity(Object rarity) {
        super.rarity(rarity);
        return this;
    }

    public CustomItemProperties fireResistant() {
        super.fireResistant();
        return this;
    }

    public Item.Properties build() {
        return super.build();
    }
}
