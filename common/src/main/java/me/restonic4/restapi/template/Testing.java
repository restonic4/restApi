package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.AdvancedItemType;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

@SuppressWarnings("unchecked")
public class Testing {
    public static void init() {
        RestApi.Log("Testing class started");

        RegistrySupplier<Item> item = (RegistrySupplier<Item>) ItemRegistry.CreateSimple(
                RestApi.MOD_ID,
                "test_item",
                null
        );

        RegistrySupplier<Item> food_simple = (RegistrySupplier<Item>) ItemRegistry.CreateFood(
                RestApi.MOD_ID,
                "test_simple_food",
                null,
                1,
                2
        );

        MobEffectInstance effect = (MobEffectInstance) ItemRegistry.CreateExistingEffect(
                MobEffects.GLOWING,
                20*60*2,
                1
        );

        RegistrySupplier<Item> food_effect = (RegistrySupplier<Item>) ItemRegistry.CreateFoodWithEffect(
                RestApi.MOD_ID,
                "test_effect_food",
                null,
                1,
                2,
                effect,
                1
        );

        RegistrySupplier<Item> test_sword = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
                RestApi.MOD_ID,
                "test_sword",
                null,
                AdvancedItemType.Type.SWORD,
                new String[]{"IRON", "2", " -2"}
        );

        ItemRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Testing things created");
    }
}
