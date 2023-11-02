package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomToolTier.CustomToolTierSet3;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CustomToolTier extends CustomToolTierSet3 {
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

    //EXTRA
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CustomToolTier that = (CustomToolTier) other;
        return getUses() == that.getUses() &&
                Float.compare(that.getSpeed(), getSpeed()) == 0 &&
                Float.compare(that.getAttackDamageBonus(), getAttackDamageBonus()) == 0 &&
                getLevel() == that.getLevel() &&
                getEnchantmentValue() == that.getEnchantmentValue() &&
                Objects.equals(getRepairIngredient(), that.getRepairIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUses(), getSpeed(), getAttackDamageBonus(), getLevel(), getEnchantmentValue(), getRepairIngredient());
    }
}