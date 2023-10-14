package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.util.CustomItemProperties;
import me.restonic4.restapi.util.CustomToolTier;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.template.custom.CustomPickaxe;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;

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

    public static final Object custom_item = ItemRegistry.CreateCustom(
            RestApi.MOD_ID,
            "custom_item",
            () -> new CustomPickaxe(
                    new CustomToolTier(750, 7, 3, 5, 15, item),
                    1,
                    1,
                    new CustomItemProperties()
                            .tab(TestTabs.tab)
                            .food(1,1, null, 0)
                            .durability(50)
                            .fireResistant()
                            .rarity(Rarity.EPIC)
                            .build()
            )
    );

    public static final Object way = ItemRegistry.CreateCustom(
            RestApi.MOD_ID,
            "way",
            () -> new SnowballItem(
                    new CustomItemProperties().tab(TestTabs.tab).stacksTo(3).build()
            )
    );

    public static void register() {
        ItemRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Items added");
    }
}
