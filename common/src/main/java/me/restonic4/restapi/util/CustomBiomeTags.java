package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomBiomeTags.CustomBiomeTagsSet4;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CustomBiomeTags {
    public static Object createFixed(String tag) {
        return create(tag);
    }

    public static TagKey<Biome> create(String tag) {
        return CustomBiomeTagsSet4.create(tag);
    }
}

