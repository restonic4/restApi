package me.restonic4.restapi.worldgen.ore;

import me.restonic4.restapi.util.BiomeConditions;
import me.restonic4.restapi.worldgen.ore.Versions.OreGeneratorSet3;

public class OreGenerator {
    /**
     * This makes your ore generate where you want.
     * @param ModId The mod id.
     * @param FeatureName The feature name/json name.
     * @param BiomeConditions The conditions to generate.
     */
    public static void RegisterOreGeneration(String ModId, String FeatureName, BiomeConditions BiomeConditions) {
        OreGeneratorSet3.registerOreGeneration(ModId, FeatureName, BiomeConditions);
    }
}
