package me.restonic4.restapi.util.UtilVersions.CustomItemProperties;

import dev.architectury.registry.registries.DeferredSupplier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomItemPropertiesSet2 {
    private Item.Properties properties = new Item.Properties();

    public CustomItemPropertiesSet2 tab(Object creativeTab) {
        if (creativeTab != null) {
            properties = properties.arch$tab((DeferredSupplier<CreativeModeTab>) creativeTab);
        }

        return this;
    }

    public CustomItemPropertiesSet2 food(int Nutrition, float SaturationMod, Object Effect, float EffectChance) {
        FoodProperties.Builder foodBuilder = new FoodProperties.Builder();

        if (Effect != null) {
            foodBuilder = foodBuilder.effect((MobEffectInstance) Effect, EffectChance);
        }

        properties = properties.food(foodBuilder.nutrition(Nutrition).saturationMod(SaturationMod).build());

        return this;
    }

    public CustomItemPropertiesSet2 durability(int durability) {
        properties = properties.durability(durability);

        return this;
    }

    public CustomItemPropertiesSet2 defaultDurability(int defaultDurability) {
        properties = properties.defaultDurability(defaultDurability);

        return this;
    }

    public CustomItemPropertiesSet2 stacksTo(int stackLimit) {
        properties = properties.stacksTo(stackLimit);

        return this;
    }

    public CustomItemPropertiesSet2 craftRemainder(Object item) {
        properties = properties.craftRemainder(
                ((DeferredSupplier<Item>)item).get()
        );

        return this;
    }

    public CustomItemPropertiesSet2 rarity(Object rarity) {
        properties = properties.rarity((Rarity) rarity);

        return this;
    }

    public CustomItemPropertiesSet2 fireResistant() {
        properties = properties.fireResistant();

        return this;
    }

    public Item.Properties build() {
        return properties;
    }
}