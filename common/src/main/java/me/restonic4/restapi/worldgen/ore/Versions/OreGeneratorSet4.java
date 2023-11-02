package me.restonic4.restapi.worldgen.ore.Versions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.util.BiomeConditions;
import net.minecraft.BlockUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Objects;


public class OreGeneratorSet4 {
    public static void registerOreGeneration(String ModId, String FeatureName, BiomeConditions biomeConditions, Object block) {
        RegistrySupplier<Block> regBlock = (RegistrySupplier<Block>) block;

        final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(ModId, Registry.PLACED_FEATURE_REGISTRY);
        final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create( ModId, Registry.CONFIGURED_FEATURE_REGISTRY);

        //Read json files from new versions
        int veinSize = getConfiguredFeatureSize(ModId, FeatureName);
        int veinAmount = getPlacedFeatureCount(ModId, FeatureName);
        int minHeight = getPlacedFeatureMinY(ModId, FeatureName);
        int maxHeight = getPlacedFeatureMaxY(ModId, FeatureName);
        float discardChanceOnAir = getConfiguratedfeatureDiscardChanceOnAir(ModId, FeatureName);

        boolean isUniform = isPlacedFeatureUniform(ModId, FeatureName);

        //Height type
        HeightRangePlacement placementType;

        if (isUniform) {
            placementType = HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
        }
        else {
            placementType = HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
        }

        BlockState blockState = regBlock.get().defaultBlockState();

        //Create the configs with code
        RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> regConfig = CONFIGURED_FEATURES.register(
                FeatureName,
                () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(
                            getConfiguratedFeatureReplaceConditions(ModId, FeatureName, blockState),
                            veinSize,
                            discardChanceOnAir
                    )
                )
        );

        RegistrySupplier<PlacedFeature> regPlaced = PLACED_FEATURES.register(
                FeatureName,
                () -> new PlacedFeature(
                        Holder.direct(BuiltinRegistries.CONFIGURED_FEATURE.get(
                                BuiltinRegistries.CONFIGURED_FEATURE.getKey(regConfig.get())
                        )),
                        List.of(
                                CountPlacement.of(veinAmount),
                                placementType,
                                InSquarePlacement.spread()

                        )
                )
        );

        CONFIGURED_FEATURES.register();
        PLACED_FEATURES.register();

        //Set the generator
        LifecycleEvent.SETUP.register(() -> {
            BiomeModifications.addProperties((ctx, mutable) -> {
                if (biomeConditions.get(ctx)) {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            BuiltinRegistries.PLACED_FEATURE.get(regPlaced.getId())
                    );
                }
            });
        });
    }

    static final String mainPath = "../../../../../../data/";

    private static String readJsonFile(String filePath) {
        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR FINDING YOUR JSON FILE: " + filePath);
        }
        return jsonContent.toString();
    }

    private static int getConfiguredFeatureSize(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/configured_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"size\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Size not found in JSON.");
        }
    }

    private static int getPlacedFeatureCount(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/placed_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"count\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Count not found in JSON.");
        }
    }

    private static int getPlacedFeatureMinY(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/placed_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"min_inclusive\":\\s*\\{\\s*\"absolute\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Min Y not found in JSON.");
        }
    }

    private static int getPlacedFeatureMaxY(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/placed_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"max_inclusive\":\\s*\\{\\s*\"absolute\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Max Y not found in JSON.");
        }
    }

    private static String getPlacedFeatureHeightType(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/placed_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"height\":\\s*\\{\\s*\"type\":\\s*\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("Height Type not found in JSON.");
        }
    }

    private static boolean isPlacedFeatureUniform(String ModId, String fileName) {
        String heightType = getPlacedFeatureHeightType(ModId, fileName);
        return "minecraft:uniform".equals(heightType);
    }

    private static float getConfiguratedfeatureDiscardChanceOnAir(String ModId, String fileName) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/configured_feature/" + fileName + ".json");
        Pattern pattern = Pattern.compile("\"discard_chance_on_air_exposure\":\\s*(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(jsonText);
        if (matcher.find()) {
            return Float.parseFloat(matcher.group(1));
        } else {
            throw new RuntimeException("Discard Chance On Air Exposure not found in JSON.");
        }
    }

    private static List<OreConfiguration.TargetBlockState> getConfiguratedFeatureReplaceConditions(String ModId, String fileName, BlockState blockState) {
        String jsonText = readJsonFile(mainPath + ModId + "/worldgen/configured_feature/" + fileName + ".json");

        List<OreConfiguration.TargetBlockState> targetBlockStates = new ArrayList<>();

        Pattern targetsPattern = Pattern.compile("\"targets\":\\s*\\[([^\\]]+)\\]");
        Matcher targetsMatcher = targetsPattern.matcher(jsonText);

        if (targetsMatcher.find()) {
            String targetsJson = targetsMatcher.group(1);

            Pattern targetPattern = Pattern.compile("\\{\\s*\"predicate_type\":\\s*\"([^\"]+)\",\\s*\"tag\":\\s*\"([^\"]+)\"\\s*\\}");
            Matcher targetMatcher = targetPattern.matcher(targetsJson);

            while (targetMatcher.find()) {
                String predicateType = targetMatcher.group(1);
                String tag = targetMatcher.group(2).replace("minecraft:", "");

                if ("minecraft:tag_match".equals(predicateType)) {
                    targetBlockStates.add(OreConfiguration.target(new TagMatchTest(getTagKeyWithTagName(tag)), blockState));
                } else if ("minecraft:block_match".equals(predicateType)) {
                    ResourceLocation rl = new ResourceLocation(tag);
                    targetBlockStates.add(OreConfiguration.target(new BlockMatchTest(Registry.BLOCK.get(rl)), blockState));
                }
            }
        }

        if (targetBlockStates.isEmpty()) {
            throw new RuntimeException("Replace Conditions not found in JSON.");
        }

        return targetBlockStates;
    }


    private static TagKey<Block> getTagKeyWithTagName(String tagName) {
        TagKey<Block> targetKey = null;

        if (Objects.equals(tagName, "wool")) {
            targetKey = BlockTags.WOOL;
        } else if (Objects.equals(tagName, "planks")) {
            targetKey = BlockTags.PLANKS;
        } else if (Objects.equals(tagName, "stone_bricks")) {
            targetKey = BlockTags.STONE_BRICKS;
        } else if (Objects.equals(tagName, "wooden_buttons")) {
            targetKey = BlockTags.WOODEN_BUTTONS;
        } else if (Objects.equals(tagName, "buttons")) {
            targetKey = BlockTags.BUTTONS;
        } else if (Objects.equals(tagName, "wool_carpets")) {
            targetKey = BlockTags.WOOL_CARPETS;
        } else if (Objects.equals(tagName, "wooden_doors")) {
            targetKey = BlockTags.WOODEN_DOORS;
        } else if (Objects.equals(tagName, "wooden_stairs")) {
            targetKey = BlockTags.WOODEN_STAIRS;
        } else if (Objects.equals(tagName, "wooden_slabs")) {
            targetKey = BlockTags.WOODEN_SLABS;
        } else if (Objects.equals(tagName, "wooden_fences")) {
            targetKey = BlockTags.WOODEN_FENCES;
        } else if (Objects.equals(tagName, "pressure_plates")) {
            targetKey = BlockTags.PRESSURE_PLATES;
        } else if (Objects.equals(tagName, "wooden_pressure_plates")) {
            targetKey = BlockTags.WOODEN_PRESSURE_PLATES;
        } else if (Objects.equals(tagName, "stone_pressure_plates")) {
            targetKey = BlockTags.STONE_PRESSURE_PLATES;
        } else if (Objects.equals(tagName, "wooden_trapdoors")) {
            targetKey = BlockTags.WOODEN_TRAPDOORS;
        } else if (Objects.equals(tagName, "doors")) {
            targetKey = BlockTags.DOORS;
        } else if (Objects.equals(tagName, "saplings")) {
            targetKey = BlockTags.SAPLINGS;
        } else if (Objects.equals(tagName, "logs_that_burn")) {
            targetKey = BlockTags.LOGS_THAT_BURN;
        } else if (Objects.equals(tagName, "overworld_natural_logs")) {
            targetKey = BlockTags.OVERWORLD_NATURAL_LOGS;
        } else if (Objects.equals(tagName, "logs")) {
            targetKey = BlockTags.LOGS;
        } else if (Objects.equals(tagName, "dark_oak_logs")) {
            targetKey = BlockTags.DARK_OAK_LOGS;
        } else if (Objects.equals(tagName, "oak_logs")) {
            targetKey = BlockTags.OAK_LOGS;
        } else if (Objects.equals(tagName, "birch_logs")) {
            targetKey = BlockTags.BIRCH_LOGS;
        } else if (Objects.equals(tagName, "acacia_logs")) {
            targetKey = BlockTags.ACACIA_LOGS;
        } else if (Objects.equals(tagName, "jungle_logs")) {
            targetKey = BlockTags.JUNGLE_LOGS;
        } else if (Objects.equals(tagName, "spruce_logs")) {
            targetKey = BlockTags.SPRUCE_LOGS;
        } else if (Objects.equals(tagName, "mangrove_logs")) {
            targetKey = BlockTags.MANGROVE_LOGS;
        } else if (Objects.equals(tagName, "crimson_stems")) {
            targetKey = BlockTags.CRIMSON_STEMS;
        } else if (Objects.equals(tagName, "warped_stems")) {
            targetKey = BlockTags.WARPED_STEMS;
        } else if (Objects.equals(tagName, "wart_blocks")) {
            targetKey = BlockTags.WART_BLOCKS;
        } else if (Objects.equals(tagName, "banners")) {
            targetKey = BlockTags.BANNERS;
        } else if (Objects.equals(tagName, "sand")) {
            targetKey = BlockTags.SAND;
        } else if (Objects.equals(tagName, "stairs")) {
            targetKey = BlockTags.STAIRS;
        } else if (Objects.equals(tagName, "slabs")) {
            targetKey = BlockTags.SLABS;
        } else if (Objects.equals(tagName, "walls")) {
            targetKey = BlockTags.WALLS;
        } else if (Objects.equals(tagName, "anvil")) {
            targetKey = BlockTags.ANVIL;
        } else if (Objects.equals(tagName, "rails")) {
            targetKey = BlockTags.RAILS;
        } else if (Objects.equals(tagName, "leaves")) {
            targetKey = BlockTags.LEAVES;
        } else if (Objects.equals(tagName, "trapdoors")) {
            targetKey = BlockTags.TRAPDOORS;
        } else if (Objects.equals(tagName, "small_flowers")) {
            targetKey = BlockTags.SMALL_FLOWERS;
        } else if (Objects.equals(tagName, "beds")) {
            targetKey = BlockTags.BEDS;
        } else if (Objects.equals(tagName, "fences")) {
            targetKey = BlockTags.FENCES;
        } else if (Objects.equals(tagName, "tall_flowers")) {
            targetKey = BlockTags.TALL_FLOWERS;
        } else if (Objects.equals(tagName, "flowers")) {
            targetKey = BlockTags.FLOWERS;
        } else if (Objects.equals(tagName, "piglin_repellents")) {
            targetKey = BlockTags.PIGLIN_REPELLENTS;
        } else if (Objects.equals(tagName, "gold_ores")) {
            targetKey = BlockTags.GOLD_ORES;
        } else if (Objects.equals(tagName, "iron_ores")) {
            targetKey = BlockTags.IRON_ORES;
        } else if (Objects.equals(tagName, "diamond_ores")) {
            targetKey = BlockTags.DIAMOND_ORES;
        } else if (Objects.equals(tagName, "redstone_ores")) {
            targetKey = BlockTags.REDSTONE_ORES;
        } else if (Objects.equals(tagName, "lapis_ores")) {
            targetKey = BlockTags.LAPIS_ORES;
        } else if (Objects.equals(tagName, "coal_ores")) {
            targetKey = BlockTags.COAL_ORES;
        } else if (Objects.equals(tagName, "emerald_ores")) {
            targetKey = BlockTags.EMERALD_ORES;
        } else if (Objects.equals(tagName, "copper_ores")) {
            targetKey = BlockTags.COPPER_ORES;
        } else if (Objects.equals(tagName, "non_flammable_wood")) {
            targetKey = BlockTags.NON_FLAMMABLE_WOOD;
        } else if (Objects.equals(tagName, "candles")) {
            targetKey = BlockTags.CANDLES;
        } else if (Objects.equals(tagName, "dirt")) {
            targetKey = BlockTags.DIRT;
        } else if (Objects.equals(tagName, "terracotta")) {
            targetKey = BlockTags.TERRACOTTA;
        } else if (Objects.equals(tagName, "completes_find_tree_tutorial")) {
            targetKey = BlockTags.COMPLETES_FIND_TREE_TUTORIAL;
        } else if (Objects.equals(tagName, "flower_pots")) {
            targetKey = BlockTags.FLOWER_POTS;
        } else if (Objects.equals(tagName, "enderman_holdable")) {
            targetKey = BlockTags.ENDERMAN_HOLDABLE;
        } else if (Objects.equals(tagName, "ice")) {
            targetKey = BlockTags.ICE;
        } else if (Objects.equals(tagName, "valid_spawn")) {
            targetKey = BlockTags.VALID_SPAWN;
        } else if (Objects.equals(tagName, "impermeable")) {
            targetKey = BlockTags.IMPERMEABLE;
        } else if (Objects.equals(tagName, "underwater_bonemeals")) {
            targetKey = BlockTags.UNDERWATER_BONEMEALS;
        } else if (Objects.equals(tagName, "coral_blocks")) {
            targetKey = BlockTags.CORAL_BLOCKS;
        } else if (Objects.equals(tagName, "wall_corals")) {
            targetKey = BlockTags.WALL_CORALS;
        } else if (Objects.equals(tagName, "coral_plants")) {
            targetKey = BlockTags.CORAL_PLANTS;
        } else if (Objects.equals(tagName, "corals")) {
            targetKey = BlockTags.CORALS;
        } else if (Objects.equals(tagName, "bamboo_plantable_on")) {
            targetKey = BlockTags.BAMBOO_PLANTABLE_ON;
        } else if (Objects.equals(tagName, "standing_signs")) {
            targetKey = BlockTags.STANDING_SIGNS;
        } else if (Objects.equals(tagName, "wall_signs")) {
            targetKey = BlockTags.WALL_SIGNS;
        } else if (Objects.equals(tagName, "signs")) {
            targetKey = BlockTags.SIGNS;
        } else if (Objects.equals(tagName, "dragon_immune")) {
            targetKey = BlockTags.DRAGON_IMMUNE;
        } else if (Objects.equals(tagName, "dragon_transparent")) {
            targetKey = BlockTags.DRAGON_TRANSPARENT;
        } else if (Objects.equals(tagName, "wither_immune")) {
            targetKey = BlockTags.WITHER_IMMUNE;
        } else if (Objects.equals(tagName, "wither_summon_base_blocks")) {
            targetKey = BlockTags.WITHER_SUMMON_BASE_BLOCKS;
        } else if (Objects.equals(tagName, "beehives")) {
            targetKey = BlockTags.BEEHIVES;
        } else if (Objects.equals(tagName, "crops")) {
            targetKey = BlockTags.CROPS;
        } else if (Objects.equals(tagName, "bee_growables")) {
            targetKey = BlockTags.BEE_GROWABLES;
        } else if (Objects.equals(tagName, "portals")) {
            targetKey = BlockTags.PORTALS;
        } else if (Objects.equals(tagName, "fire")) {
            targetKey = BlockTags.FIRE;
        } else if (Objects.equals(tagName, "nylium")) {
            targetKey = BlockTags.NYLIUM;
        } else if (Objects.equals(tagName, "beacon_base_blocks")) {
            targetKey = BlockTags.BEACON_BASE_BLOCKS;
        } else if (Objects.equals(tagName, "soul_speed_blocks")) {
            targetKey = BlockTags.SOUL_SPEED_BLOCKS;
        } else if (Objects.equals(tagName, "wall_post_override")) {
            targetKey = BlockTags.WALL_POST_OVERRIDE;
        } else if (Objects.equals(tagName, "climbable")) {
            targetKey = BlockTags.CLIMBABLE;
        } else if (Objects.equals(tagName, "fall_damage_resetting")) {
            targetKey = BlockTags.FALL_DAMAGE_RESETTING;
        } else if (Objects.equals(tagName, "shulker_boxes")) {
            targetKey = BlockTags.SHULKER_BOXES;
        } else if (Objects.equals(tagName, "hoglin_repellents")) {
            targetKey = BlockTags.HOGLIN_REPELLENTS;
        } else if (Objects.equals(tagName, "soul_fire_base_blocks")) {
            targetKey = BlockTags.SOUL_FIRE_BASE_BLOCKS;
        } else if (Objects.equals(tagName, "strider_warm_blocks")) {
            targetKey = BlockTags.STRIDER_WARM_BLOCKS;
        } else if (Objects.equals(tagName, "campfires")) {
            targetKey = BlockTags.CAMPFIRES;
        } else if (Objects.equals(tagName, "guarded_by_piglins")) {
            targetKey = BlockTags.GUARDED_BY_PIGLINS;
        } else if (Objects.equals(tagName, "prevent_mob_spawning_inside")) {
            targetKey = BlockTags.PREVENT_MOB_SPAWNING_INSIDE;
        } else if (Objects.equals(tagName, "fence_gates")) {
            targetKey = BlockTags.FENCE_GATES;
        } else if (Objects.equals(tagName, "unstable_bottom_center")) {
            targetKey = BlockTags.UNSTABLE_BOTTOM_CENTER;
        } else if (Objects.equals(tagName, "mushroom_grow_block")) {
            targetKey = BlockTags.MUSHROOM_GROW_BLOCK;
        } else if (Objects.equals(tagName, "infiniburn_overworld")) {
            targetKey = BlockTags.INFINIBURN_OVERWORLD;
        } else if (Objects.equals(tagName, "infiniburn_nether")) {
            targetKey = BlockTags.INFINIBURN_NETHER;
        } else if (Objects.equals(tagName, "infiniburn_end")) {
            targetKey = BlockTags.INFINIBURN_END;
        } else if (Objects.equals(tagName, "base_stone_overworld")) {
            targetKey = BlockTags.BASE_STONE_OVERWORLD;
        } else if (Objects.equals(tagName, "stone_ore_replaceables")) {
            targetKey = BlockTags.STONE_ORE_REPLACEABLES;
        } else if (Objects.equals(tagName, "deepslate_ore_replaceables")) {
            targetKey = BlockTags.DEEPSLATE_ORE_REPLACEABLES;
        } else if (Objects.equals(tagName, "base_stone_nether")) {
            targetKey = BlockTags.BASE_STONE_NETHER;
        } else if (Objects.equals(tagName, "overworld_carver_replaceables")) {
            targetKey = BlockTags.OVERWORLD_CARVER_REPLACEABLES;
        } else if (Objects.equals(tagName, "nether_carver_replaceables")) {
            targetKey = BlockTags.NETHER_CARVER_REPLACEABLES;
        } else if (Objects.equals(tagName, "candle_cakes")) {
            targetKey = BlockTags.CANDLE_CAKES;
        } else if (Objects.equals(tagName, "cauldrons")) {
            targetKey = BlockTags.CAULDRONS;
        } else if (Objects.equals(tagName, "crystal_sound_blocks")) {
            targetKey = BlockTags.CRYSTAL_SOUND_BLOCKS;
        } else if (Objects.equals(tagName, "inside_step_sound_blocks")) {
            targetKey = BlockTags.INSIDE_STEP_SOUND_BLOCKS;
        } else if (Objects.equals(tagName, "occludes_vibration_signals")) {
            targetKey = BlockTags.OCCLUDES_VIBRATION_SIGNALS;
        } else if (Objects.equals(tagName, "dampens_vibrations")) {
            targetKey = BlockTags.DAMPENS_VIBRATIONS;
        } else if (Objects.equals(tagName, "dripstone_replaceable_blocks")) {
            targetKey = BlockTags.DRIPSTONE_REPLACEABLE;
        } else if (Objects.equals(tagName, "cave_vines")) {
            targetKey = BlockTags.CAVE_VINES;
        } else if (Objects.equals(tagName, "moss_replaceable")) {
            targetKey = BlockTags.MOSS_REPLACEABLE;
        } else if (Objects.equals(tagName, "lush_ground_replaceable")) {
            targetKey = BlockTags.LUSH_GROUND_REPLACEABLE;
        } else if (Objects.equals(tagName, "azalea_root_replaceable")) {
            targetKey = BlockTags.AZALEA_ROOT_REPLACEABLE;
        } else if (Objects.equals(tagName, "small_dripleaf_placeable")) {
            targetKey = BlockTags.SMALL_DRIPLEAF_PLACEABLE;
        } else if (Objects.equals(tagName, "big_dripleaf_placeable")) {
            targetKey = BlockTags.BIG_DRIPLEAF_PLACEABLE;
        } else if (Objects.equals(tagName, "snow")) {
            targetKey = BlockTags.SNOW;
        } else if (Objects.equals(tagName, "mineable/axe")) {
            targetKey = BlockTags.MINEABLE_WITH_AXE;
        } else if (Objects.equals(tagName, "mineable/hoe")) {
            targetKey = BlockTags.MINEABLE_WITH_HOE;
        } else if (Objects.equals(tagName, "mineable/pickaxe")) {
            targetKey = BlockTags.MINEABLE_WITH_PICKAXE;
        } else if (Objects.equals(tagName, "mineable/shovel")) {
            targetKey = BlockTags.MINEABLE_WITH_SHOVEL;
        } else if (Objects.equals(tagName, "needs_diamond_tool")) {
            targetKey = BlockTags.NEEDS_DIAMOND_TOOL;
        } else if (Objects.equals(tagName, "needs_iron_tool")) {
            targetKey = BlockTags.NEEDS_IRON_TOOL;
        } else if (Objects.equals(tagName, "needs_stone_tool")) {
            targetKey = BlockTags.NEEDS_STONE_TOOL;
        } else if (Objects.equals(tagName, "features_cannot_replace")) {
            targetKey = BlockTags.FEATURES_CANNOT_REPLACE;
        } else if (Objects.equals(tagName, "lava_pool_stone_cannot_replace")) {
            targetKey = BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE;
        } else if (Objects.equals(tagName, "geode_invalid_blocks")) {
            targetKey = BlockTags.GEODE_INVALID_BLOCKS;
        } else if (Objects.equals(tagName, "frog_prefer_jump_to")) {
            targetKey = BlockTags.FROG_PREFER_JUMP_TO;
        } else if (Objects.equals(tagName, "sculk_replaceable")) {
            targetKey = BlockTags.SCULK_REPLACEABLE;
        } else if (Objects.equals(tagName, "sculk_replaceable_world_gen")) {
            targetKey = BlockTags.SCULK_REPLACEABLE_WORLD_GEN;
        } else if (Objects.equals(tagName, "ancient_city_replaceable")) {
            targetKey = BlockTags.ANCIENT_CITY_REPLACEABLE;
        } else if (Objects.equals(tagName, "animals_spawnable_on")) {
            targetKey = BlockTags.ANIMALS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "axolotls_spawnable_on")) {
            targetKey = BlockTags.AXOLOTLS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "goats_spawnable_on")) {
            targetKey = BlockTags.GOATS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "mooshrooms_spawnable_on")) {
            targetKey = BlockTags.MOOSHROOMS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "parrots_spawnable_on")) {
            targetKey = BlockTags.PARROTS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "polar_bears_spawnable_on_alternate")) {
            targetKey = BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE;
        } else if (Objects.equals(tagName, "rabbits_spawnable_on")) {
            targetKey = BlockTags.RABBITS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "foxes_spawnable_on")) {
            targetKey = BlockTags.FOXES_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "wolves_spawnable_on")) {
            targetKey = BlockTags.WOLVES_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "frogs_spawnable_on")) {
            targetKey = BlockTags.FROGS_SPAWNABLE_ON;
        } else if (Objects.equals(tagName, "azalea_grows_on")) {
            targetKey = BlockTags.AZALEA_GROWS_ON;
        } else if (Objects.equals(tagName, "replaceable_plants")) {
            targetKey = BlockTags.REPLACEABLE_PLANTS;
        } else if (Objects.equals(tagName, "convertable_to_mud")) {
            targetKey = BlockTags.CONVERTABLE_TO_MUD;
        } else if (Objects.equals(tagName, "mangrove_logs_can_grow_through")) {
            targetKey = BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH;
        } else if (Objects.equals(tagName, "mangrove_roots_can_grow_through")) {
            targetKey = BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH;
        } else if (Objects.equals(tagName, "dead_bush_may_place_on")) {
            targetKey = BlockTags.DEAD_BUSH_MAY_PLACE_ON;
        } else if (Objects.equals(tagName, "snaps_goat_horn")) {
            targetKey = BlockTags.SNAPS_GOAT_HORN;
        } else if (Objects.equals(tagName, "snow_layer_cannot_survive_on")) {
            targetKey = BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON;
        } else if (Objects.equals(tagName, "snow_layer_can_survive_on")) {
            targetKey = BlockTags.SNOW_LAYER_CAN_SURVIVE_ON;
        }

        return targetKey;
    }
}
