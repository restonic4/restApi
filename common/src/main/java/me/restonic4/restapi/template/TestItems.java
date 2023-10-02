package me.restonic4.restapi.template;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.AdvancedItemType;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

@SuppressWarnings("unchecked")
public class TestItems {
    public static final RegistrySupplier<Item> item = (RegistrySupplier<Item>) ItemRegistry.CreateSimple(
            RestApi.MOD_ID,
            "test_item",
            TestTabs.tab
    );

    public static final RegistrySupplier<Item> food_simple = (RegistrySupplier<Item>) ItemRegistry.CreateFood(
            RestApi.MOD_ID,
            "test_simple_food",
            TestTabs.tab,
            1,
            2
    );

    public static final MobEffectInstance effect = (MobEffectInstance) ItemRegistry.CreateExistingEffect(
            MobEffects.GLOWING,
            20*60*2,
            1
    );

    public static final RegistrySupplier<Item> food_effect = (RegistrySupplier<Item>) ItemRegistry.CreateFoodWithEffect(
            RestApi.MOD_ID,
            "test_effect_food",
            TestTabs.tab,
            1,
            2,
            effect,
            1
    );

    public static final RegistrySupplier<Item> test_sword = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_sword",
            TestTabs.tab,
            AdvancedItemType.SWORD,
            new String[]{"IRON", "2", " -2"}
    );

    public static final RegistrySupplier<Item> test_axe = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_axe",
            TestTabs.tab,
            AdvancedItemType.AXE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final RegistrySupplier<Item> test_pickaxe = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_pickaxe",
            TestTabs.tab,
            AdvancedItemType.PICKAXE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final RegistrySupplier<Item> test_hoe = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_hoe",
            TestTabs.tab,
            AdvancedItemType.HOE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final RegistrySupplier<Item> test_shovel = (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_shovel",
            TestTabs.tab,
            AdvancedItemType.SHOVEL,
            new String[]{"IRON", "2", " -2"}
    );

    public static final RegistrySupplier<Item> test_flint= (RegistrySupplier<Item>) ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_flint",
            TestTabs.tab,
            AdvancedItemType.FLINT_AND_STEEL,
            new String[]{"IRON", "2", " -2"}
    );

    public static void register() {
        ItemRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Items added");
    }
}
