package me.restonic4.restapi.util.UtilVersions.CustomToolTier;

import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.util.Lazy;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class CustomToolTierSet3 implements Tier {


    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;

    public CustomToolTierSet3(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Object repairIngredient) {
        RestApi.Log(uses + " " + speed + " " + attackDamageBonus + " " + level + " " + enchantmentValue + " " + repairIngredient);
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;

        if (repairIngredient instanceof Item) {
            this.repairIngredient = Lazy.of(() -> Ingredient.of((Item) repairIngredient));
        }
        else if (repairIngredient instanceof RegistrySupplier<?>) {
            this.repairIngredient = Lazy.of(() -> Ingredient.of(
                    ((RegistrySupplier<Item>)repairIngredient).get()
            ));
        }
        else {
            this.repairIngredient = null;
        }
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
