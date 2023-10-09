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
    public static final Object item = ItemRegistry.CreateSimple(
            RestApi.MOD_ID,
            "test_item",
            TestTabs.tab
    );

    public static final Object food_simple = ItemRegistry.CreateFood(
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

    public static final Object food_effect = ItemRegistry.CreateFoodWithEffect(
            RestApi.MOD_ID,
            "test_effect_food",
            TestTabs.tab,
            1,
            2,
            effect,
            1
    );

    public static final Object test_sword = ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_sword",
            TestTabs.tab,
            AdvancedItemType.SWORD,
            new String[]{"IRON", "2", " -2"}
    );

    public static final Object test_axe = ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_axe",
            TestTabs.tab,
            AdvancedItemType.AXE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final Object test_pickaxe = ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_pickaxe",
            TestTabs.tab,
            AdvancedItemType.PICKAXE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final Object test_hoe = ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_hoe",
            TestTabs.tab,
            AdvancedItemType.HOE,
            new String[]{"IRON", "2", " -2"}
    );

    public static final Object test_shovel = ItemRegistry.CreateAdvanced(
            RestApi.MOD_ID,
            "test_shovel",
            TestTabs.tab,
            AdvancedItemType.SHOVEL,
            new String[]{"IRON", "2", " -2"}
    );

    public static final Object test_flint= ItemRegistry.CreateAdvanced(
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
