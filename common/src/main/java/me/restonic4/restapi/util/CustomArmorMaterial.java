package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomArmorMaterial.CustomArmorMaterialSet1;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class CustomArmorMaterial extends CustomArmorMaterialSet1 {
    public CustomArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        super(name, durabilityMultiplier, protectionAmounts, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient);
    }
}
