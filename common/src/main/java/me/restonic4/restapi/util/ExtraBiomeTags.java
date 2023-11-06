package me.restonic4.restapi.util;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ExtraBiomeTags {
    public static final TagKey<Biome> IS_CAVE_BIOME = CustomBiomeTags.create("is_cave_biome");
    public static final TagKey<Biome> IS_MUSHROOM_FIELDS = CustomBiomeTags.create("is_mushroom_fields");
    public static final TagKey<Biome> IS_ARID_LAND = CustomBiomeTags.create("is_arid_land");
    public static final TagKey<Biome> IS_FLATLAND = CustomBiomeTags.create("is_flatland");
    public static final TagKey<Biome> IS_HIGHLAND = CustomBiomeTags.create("is_highland");
    public static final TagKey<Biome> IS_NONLAND = CustomBiomeTags.create("is_nonland");
    public static final TagKey<Biome> IS_VOID = CustomBiomeTags.create("is_void");
    public static final TagKey<Biome> IS_WETLAND = CustomBiomeTags.create("is_wetland");
    public static final TagKey<Biome> IS_WOODLAND = CustomBiomeTags.create("is_woodland");
}
