package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.util.CustomItemProperties;
import me.restonic4.restapi.util.CustomToolTier;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.template.custom.CustomPickaxe;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

@SuppressWarnings("unchecked")
public class TestItems {
    public static final Object item = ItemRegistry.CreateSimple(
            MOD_ID,
            "test_item",
            TestTabs.tab
    );

    public static final Object food_simple = ItemRegistry.CreateFood(
            MOD_ID,
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
            MOD_ID,
            "test_effect_food",
            TestTabs.tab,
            1,
            2,
            effect,
            1
    );

    public static final Object custom_item = ItemRegistry.CreateCustom(
            MOD_ID,
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
            MOD_ID,
            "way",
            () -> new SnowballItem(
                    new CustomItemProperties().tab(TestTabs.tab).stacksTo(3).build()
            )
    );

    public static final CustomToolTier AMETHYST_TIER = new CustomToolTier(750, 7, 3, 5, 15, Items.AMETHYST_SHARD);
    public static final CustomToolTier AZURE_TIER = new CustomToolTier(1500, 20, 3, 6, 18, Items.DIAMOND_ORE);

    public static final CustomItemProperties DEFAULT_PROPERTIES = new CustomItemProperties().tab(TestTabs.tab);

    public static final Object AZURE = ItemRegistry.CreateSimple(MOD_ID, "azure", TestTabs.tab);

    public static final Object AMETHYST_PICKAXE = ItemRegistry.CreateCustom(
            MOD_ID,
            "amethyst_pickaxe",
            () -> new PickaxeItem(
                    AMETHYST_TIER,
                    1, -2.8f,
                    DEFAULT_PROPERTIES.build()
            )
    );

    public static final Object AZURE_PICKAXE = ItemRegistry.CreateCustom(
            MOD_ID,
            "azure_pickaxe",
            () -> new PickaxeItem(
                    AZURE_TIER,
                    1, -2.8f,
                    DEFAULT_PROPERTIES.build()
            )
    );

    public static void register() {
        ItemRegistry.Register(MOD_ID);

        if (AMETHYST_TIER.equals(AZURE_TIER)) {
            RestApi.Log("SAME TOOL TIER");
            Minecraft.crash(new CrashReport("pito", new Throwable("ñam")));
        }
        else {
            RestApi.Log("NOT THE SAME TOOL TIER");
        }

        RestApi.Log("Items added");
    }
}
