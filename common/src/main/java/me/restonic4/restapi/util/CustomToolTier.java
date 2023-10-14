package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomToolTier.CustomToolTierSet3;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class CustomToolTier extends CustomToolTierSet3 implements Tier {
    public CustomToolTier(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Object repairIngredient) {
        super(uses, speed, attackDamageBonus, level, enchantmentValue, repairIngredient);
    }

    public int getUses() {
        return super.getUses();
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public float getAttackDamageBonus() {
        return super.getAttackDamageBonus();
    }

    public int getLevel() {
        return super.getLevel();
    }

    public int getEnchantmentValue() {
        return super.getEnchantmentValue();
    }

    @NotNull
    public Ingredient getRepairIngredient() {
        return super.getRepairIngredient();
    }
}