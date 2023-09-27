package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.item.AdvancedItemType;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

public class Testing {
    public static void init() {
        RestApi.Log("Testing class started");

        TestItems.register();
        TestTabs.register();

        RestApi.Log("Testing things created");
    }
}
