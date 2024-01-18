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
}