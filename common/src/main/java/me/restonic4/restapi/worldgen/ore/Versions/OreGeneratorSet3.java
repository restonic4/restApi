package me.restonic4.restapi.worldgen.ore.Versions;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.level.biome.BiomeModifications;
import me.restonic4.restapi.util.BiomeConditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class OreGeneratorSet3 {
    public static void registerOreGeneration(String ModId, String FeatureName, BiomeConditions biomeConditions) {
        LifecycleEvent.SETUP.register(() -> {
            BiomeModifications.addProperties((ctx, mutable) -> {
                if (biomeConditions.get(ctx)) {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ModId, FeatureName))
                    );
                }
            });
        });
    }
}
