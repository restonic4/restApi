package me.restonic4.restapi.util.UtilVersions.CustomBiomeTags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CustomBiomeTagsSet1 {
    public static TagKey<Biome> create(String string) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(string));
    }
}
