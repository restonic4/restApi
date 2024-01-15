package me.restonic4.restapi.util.UtilVersions.BiomeConditions;

import dev.architectury.registry.level.biome.BiomeModifications;
import me.restonic4.restapi.RestApi;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;
import static me.restonic4.restapi.RestApiVariables.NOT_IMPLEMENTED_MC;

public class BiomeConditionsSet4 {
    private List<String> biomes = new ArrayList<>();
    private List<TagKey<Biome>> customBiomes = new ArrayList<>();

    //Dims
    public BiomeConditionsSet4 isOverworld() {
        if (!biomes.contains("Overworld")) {
            biomes.add("Overworld");
        }
        return this;
    }

    public BiomeConditionsSet4 isNether() {
        if (!biomes.contains("Nether")) {
            biomes.add("Nether");
        }
        return this;
    }

    public BiomeConditionsSet4 isEnd() {
        if (!biomes.contains("End")) {
            biomes.add("End");
        }
        return this;
    }

    //Biomes
    public BiomeConditionsSet4 isDeepOcean() {
        if (!biomes.contains("DeepOcean")) {
            biomes.add("DeepOcean");
        }
        return this;
    }

    public BiomeConditionsSet4 isOcean() {
        if (!biomes.contains("Ocean")) {
            biomes.add("Ocean");
        }
        return this;
    }

    public BiomeConditionsSet4 isBeach() {
        if (!biomes.contains("Beach")) {
            biomes.add("Beach");
        }
        return this;
    }

    public BiomeConditionsSet4 isRiver() {
        if (!biomes.contains("River")) {
            biomes.add("River");
        }
        return this;
    }

    public BiomeConditionsSet4 isMountain() {
        if (!biomes.contains("Mountain")) {
            biomes.add("Mountain");
        }
        return this;
    }

    public BiomeConditionsSet4 isBadlands() {
        if (!biomes.contains("Badlands")) {
            biomes.add("Badlands");
        }
        return this;
    }

    public BiomeConditionsSet4 isHill() {
        if (!biomes.contains("Hill")) {
            biomes.add("Hill");
        }
        return this;
    }

    public BiomeConditionsSet4 isTaiga() {
        if (!biomes.contains("Taiga")) {
            biomes.add("Taiga");
        }
        return this;
    }

    public BiomeConditionsSet4 isJungle() {
        if (!biomes.contains("Jungle")) {
            biomes.add("Jungle");
        }
        return this;
    }

    public BiomeConditionsSet4 isForest() {
        if (!biomes.contains("Forest")) {
            biomes.add("Forest");
        }
        return this;
    }

    public BiomeConditionsSet4 isSavanna() {
        if (!biomes.contains("Savanna")) {
            biomes.add("Savanna");
        }
        return this;
    }

    //Structures
    public BiomeConditionsSet4 strongholdBiasedTo() {
        if (!biomes.contains("StrongholdBiasedTo")) {
            biomes.add("StrongholdBiasedTo");
        }
        return this;
    }

    public BiomeConditionsSet4 hasBuriedTreasure() {
        if (!biomes.contains("HasBuriedTreasure")) {
            biomes.add("HasBuriedTreasure");
        }
        return this;
    }

    public BiomeConditionsSet4 hasDesertPyramid() {
        if (!biomes.contains("HasDesertPyramid")) {
            biomes.add("HasDesertPyramid");
        }
        return this;
    }

    public BiomeConditionsSet4 hasIgloo() {
        if (!biomes.contains("HasIgloo")) {
            biomes.add("HasIgloo");
        }
        return this;
    }

    public BiomeConditionsSet4 hasJungleTemple() {
        if (!biomes.contains("HasJungleTemple")) {
            biomes.add("HasJungleTemple");
        }
        return this;
    }

    public BiomeConditionsSet4 hasMineshaft() {
        if (!biomes.contains("HasMineshaft")) {
            biomes.add("HasMineshaft");
        }
        return this;
    }

    public BiomeConditionsSet4 hasMineshaftMesa() {
        if (!biomes.contains("HasMineshaftMesa")) {
            biomes.add("HasMineshaftMesa");
        }
        return this;
    }

    public BiomeConditionsSet4 hasOceanMonument() {
        if (!biomes.contains("OceanMonument")) {
            biomes.add("OceanMonument");
        }
        return this;
    }

    public BiomeConditionsSet4 hasOceanRuinCold() {
        if (!biomes.contains("OceanRuinCold")) {
            biomes.add("OceanRuinCold");
        }
        return this;
    }

    public BiomeConditionsSet4 hasOceanRuinWarm() {
        if (!biomes.contains("OceanRuinWarm")) {
            biomes.add("OceanRuinWarm");
        }
        return this;
    }

    public BiomeConditionsSet4 hasPillagerOutpost() {
        if (!biomes.contains("PillagerOutpost")) {
            biomes.add("PillagerOutpost");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalDesert() {
        if (!biomes.contains("RuinedPortalDesert")) {
            biomes.add("RuinedPortalDesert");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalJungle() {
        if (!biomes.contains("RuinedPortalJungle")) {
            biomes.add("RuinedPortalJungle");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalOcean() {
        if (!biomes.contains("RuinedPortalOcean")) {
            biomes.add("RuinedPortalOcean");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalSwamp() {
        if (!biomes.contains("RuinedPortalSwamp")) {
            biomes.add("RuinedPortalSwamp");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalMountain() {
        if (!biomes.contains("RuinedPortalMountain")) {
            biomes.add("RuinedPortalMountain");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalStandard() {
        if (!biomes.contains("RuinedPortalStandard")) {
            biomes.add("RuinedPortalStandard");
        }
        return this;
    }

    public BiomeConditionsSet4 hasShipwreckBeached() {
        if (!biomes.contains("ShipwreckBeached")) {
            biomes.add("ShipwreckBeached");
        }
        return this;
    }

    public BiomeConditionsSet4 hasShipwreck() {
        if (!biomes.contains("Shipwreck")) {
            biomes.add("Shipwreck");
        }
        return this;
    }

    public BiomeConditionsSet4 hasStronghold() {
        if (!biomes.contains("Stronghold")) {
            biomes.add("Stronghold");
        }
        return this;
    }

    public BiomeConditionsSet4 hasSwampHut() {
        if (!biomes.contains("SwampHut")) {
            biomes.add("SwampHut");
        }
        return this;
    }

    public BiomeConditionsSet4 hasVillageDesert() {
        if (!biomes.contains("VillageDesert")) {
            biomes.add("VillageDesert");
        }
        return this;
    }

    public BiomeConditionsSet4 hasVillagePlains() {
        if (!biomes.contains("VillagePlains")) {
            biomes.add("VillagePlains");
        }
        return this;
    }

    public BiomeConditionsSet4 hasVillageSavanna() {
        if (!biomes.contains("VillageSavanna")) {
            biomes.add("VillageSavanna");
        }
        return this;
    }

    public BiomeConditionsSet4 hasVillageSnowy() {
        if (!biomes.contains("VillageSnowy")) {
            biomes.add("VillageSnowy");
        }
        return this;
    }

    public BiomeConditionsSet4 hasVillageTaiga() {
        if (!biomes.contains("VillageTaiga")) {
            biomes.add("VillageTaiga");
        }
        return this;
    }

    public BiomeConditionsSet4 hasTrailRuins() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    public BiomeConditionsSet4 hasWoodlandMansion() {
        if (!biomes.contains("WoodlandMansion")) {
            biomes.add("WoodlandMansion");
        }
        return this;
    }

    public BiomeConditionsSet4 hasNetherFortress() {
        if (!biomes.contains("NetherFortress")) {
            biomes.add("NetherFortress");
        }
        return this;
    }

    public BiomeConditionsSet4 hasNetherFossil() {
        if (!biomes.contains("NetherFossil")) {
            biomes.add("NetherFossil");
        }
        return this;
    }

    public BiomeConditionsSet4 hasBastionRemnant() {
        if (!biomes.contains("BastionRemnant")) {
            biomes.add("BastionRemnant");
        }
        return this;
    }

    public BiomeConditionsSet4 hasAncientCity() {
        if (!biomes.contains("AncientCity")) {
            biomes.add("AncientCity");
        }
        return this;
    }

    public BiomeConditionsSet4 hasRuinedPortalNether() {
        if (!biomes.contains("RuinedPortalNether")) {
            biomes.add("RuinedPortalNether");
        }
        return this;
    }

    public BiomeConditionsSet4 hasEndCity() {
        if (!biomes.contains("EndCity")) {
            biomes.add("EndCity");
        }
        return this;
    }

    public BiomeConditionsSet4 requiredOceanMonumentSurrounding() {
        if (!biomes.contains("RequiredOceanMonumentSurrounding")) {
            biomes.add("RequiredOceanMonumentSurrounding");
        }
        return this;
    }

    public BiomeConditionsSet4 mineshaftBlocking() {
        if (!biomes.contains("MineshaftBlocking")) {
            biomes.add("MineshaftBlocking");
        }
        return this;
    }

    //Other
    public BiomeConditionsSet4 playsUnderwaterMusic() {
        if (!biomes.contains("PlaysUnderwaterMusic")) {
            biomes.add("PlaysUnderwaterMusic");
        }
        return this;
    }

    public BiomeConditionsSet4 hasCloserWaterFog() {
        if (!biomes.contains("HasCloserWaterFog")) {
            biomes.add("HasCloserWaterFog");
        }
        return this;
    }

    public BiomeConditionsSet4 waterOnMapOutlines() {
        if (!biomes.contains("WaterOnMapOutlines")) {
            biomes.add("WaterOnMapOutlines");
        }
        return this;
    }

    public BiomeConditionsSet4 producesCoralsFromBonemeal() {
        if (!biomes.contains("ProducesCoralsFromBonemeal")) {
            biomes.add("ProducesCoralsFromBonemeal");
        }
        return this;
    }

    public BiomeConditionsSet4 increasedFireBurnout() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    public BiomeConditionsSet4 snowGolemMelts() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    public BiomeConditionsSet4 withoutZombieSieges() {
        if (!biomes.contains("WithoutZombieSieges")) {
            biomes.add("WithoutZombieSieges");
        }
        return this;
    }

    public BiomeConditionsSet4 withoutPatrolSpawns() {
        if (!biomes.contains("WithoutPatrolSpawns")) {
            biomes.add("WithoutPatrolSpawns");
        }
        return this;
    }

    public BiomeConditionsSet4 withoutWanderingTraderSpawns() {
        if (!biomes.contains("WithoutWanderingTraderSpawns")) {
            biomes.add("WithoutWanderingTraderSpawns");
        }
        return this;
    }

    public BiomeConditionsSet4 spawnsColdVariantFrogs() {
        if (!biomes.contains("SpawnsColdVariantFrogs")) {
            biomes.add("SpawnsColdVariantFrogs");
        }
        return this;
    }

    public BiomeConditionsSet4 spawnsWarmVariantFrogs() {
        if (!biomes.contains("SpawnsWarmVariantFrogs")) {
            biomes.add("SpawnsWarmVariantFrogs");
        }
        return this;
    }

    public BiomeConditionsSet4 spawnsGoldRabbits() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    public BiomeConditionsSet4 spawnsWhiteRabbits() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    public BiomeConditionsSet4 reducedWaterAmbientSpawns() {
        if (!biomes.contains("ReducedWaterAmbientSpawns")) {
            biomes.add("ReducedWaterAmbientSpawns");
        }
        return this;
    }

    public BiomeConditionsSet4 allowsTropicalFishSpawnsAtAnyHeight() {
        if (!biomes.contains("AllowsTropicalFishSpawnsAtAnyHeight")) {
            biomes.add("AllowsTropicalFishSpawnsAtAnyHeight");
        }
        return this;
    }

    public BiomeConditionsSet4 polarBearsSpawnOnAlternateBlocks() {
        if (!biomes.contains("PolarBearsSpawnOnAlternateBlocks")) {
            biomes.add("PolarBearsSpawnOnAlternateBlocks");
        }
        return this;
    }

    public BiomeConditionsSet4 moreFrequentDrownedSpawns() {
        if (!biomes.contains("MoreFrequentDrownedSpawns")) {
            biomes.add("MoreFrequentDrownedSpawns");
        }
        return this;
    }

    public BiomeConditionsSet4 allowsSurfaceSlimeSpawns() {
        if (!biomes.contains("AllowsSurfaceSlimeSpawns")) {
            biomes.add("AllowsSurfaceSlimeSpawns");
        }
        return this;
    }

    public BiomeConditionsSet4 spawnsSnowFoxes() {
        API_LOGGER.log(NOT_IMPLEMENTED_MC);
        return this;
    }

    //Custom
    public BiomeConditionsSet4 addCustomBiomeTagKey(TagKey<Biome> tagKey) {
        if (!customBiomes.contains(tagKey)) {
            customBiomes.add(tagKey);
        }
        return this;
    }

    public boolean get(BiomeModifications.BiomeContext ctx) {
        //Dims
        boolean inOverworldBiome = biomes.contains("Overworld") && ctx.hasTag(BiomeTags.IS_OVERWORLD);
        boolean inNetherBiome = biomes.contains("Nether") && ctx.hasTag(BiomeTags.IS_NETHER);
        boolean inEndBiome = biomes.contains("End") && ctx.hasTag(BiomeTags.IS_END);

        //Biomes
        boolean inDeepOcean = biomes.contains("DeepOcean") && ctx.hasTag(BiomeTags.IS_DEEP_OCEAN);
        boolean inOcean = biomes.contains("Ocean") && ctx.hasTag(BiomeTags.IS_OCEAN);
        boolean inBeach = biomes.contains("Beach") && ctx.hasTag(BiomeTags.IS_BEACH);
        boolean inRiver = biomes.contains("River") && ctx.hasTag(BiomeTags.IS_RIVER);
        boolean inMountain = biomes.contains("Mountain") && ctx.hasTag(BiomeTags.IS_MOUNTAIN);
        boolean inBadlands = biomes.contains("Badlands") && ctx.hasTag(BiomeTags.IS_BADLANDS);
        boolean inHill = biomes.contains("Hill") && ctx.hasTag(BiomeTags.IS_HILL);
        boolean inTaiga = biomes.contains("Taiga") && ctx.hasTag(BiomeTags.IS_TAIGA);
        boolean inJungle = biomes.contains("Jungle") && ctx.hasTag(BiomeTags.IS_JUNGLE);
        boolean inForest = biomes.contains("Forest") && ctx.hasTag(BiomeTags.IS_FOREST);
        boolean inSavanna = biomes.contains("Savanna") && ctx.hasTag(BiomeTags.IS_SAVANNA);

        //Structures
        boolean strongholdBiasedTo = biomes.contains("StrongholdBiasedTo") && ctx.hasTag(BiomeTags.STRONGHOLD_BIASED_TO);
        boolean hasBuriedTreasure = biomes.contains("HasBuriedTreasure") && ctx.hasTag(BiomeTags.HAS_BURIED_TREASURE);
        boolean hasDesertPyramid = biomes.contains("HasDesertPyramid") && ctx.hasTag(BiomeTags.HAS_DESERT_PYRAMID);
        boolean hasIgloo = biomes.contains("HasIgloo") && ctx.hasTag(BiomeTags.HAS_IGLOO);
        boolean hasJungleTemple = biomes.contains("HasJungleTemple") && ctx.hasTag(BiomeTags.HAS_JUNGLE_TEMPLE);
        boolean hasMineshaft = biomes.contains("HasMineshaft") && ctx.hasTag(BiomeTags.HAS_MINESHAFT);
        boolean hasMineshaftMesa = biomes.contains("HasMineshaftMesa") && ctx.hasTag(BiomeTags.HAS_MINESHAFT_MESA);
        boolean hasOceanMonument = biomes.contains("OceanMonument") && ctx.hasTag(BiomeTags.HAS_OCEAN_MONUMENT);
        boolean hasOceanRuinCold = biomes.contains("OceanRuinCold") && ctx.hasTag(BiomeTags.HAS_OCEAN_RUIN_COLD);
        boolean hasOceanRuinWarm = biomes.contains("OceanRuinWarm") && ctx.hasTag(BiomeTags.HAS_OCEAN_RUIN_WARM);
        boolean hasPillagerOutpost = biomes.contains("PillagerOutpost") && ctx.hasTag(BiomeTags.HAS_PILLAGER_OUTPOST);
        boolean hasRuinedPortalDesert = biomes.contains("RuinedPortalDesert") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_DESERT);
        boolean hasRuinedPortalJungle = biomes.contains("RuinedPortalJungle") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_JUNGLE);
        boolean hasRuinedPortalOcean = biomes.contains("RuinedPortalOcean") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_OCEAN);
        boolean hasRuinedPortalSwamp = biomes.contains("RuinedPortalSwamp") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_SWAMP);
        boolean hasRuinedPortalMountain = biomes.contains("RuinedPortalMountain") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN);
        boolean hasRuinedPortalStandard = biomes.contains("RuinedPortalStandard") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_STANDARD);
        boolean hasShipwreckBeached = biomes.contains("ShipwreckBeached") && ctx.hasTag(BiomeTags.HAS_SHIPWRECK_BEACHED);
        boolean hasShipwreck = biomes.contains("Shipwreck") && ctx.hasTag(BiomeTags.HAS_SHIPWRECK);
        boolean hasStronghold = biomes.contains("Stronghold") && ctx.hasTag(BiomeTags.HAS_STRONGHOLD);
        boolean hasSwampHut = biomes.contains("SwampHut") && ctx.hasTag(BiomeTags.HAS_SWAMP_HUT);
        boolean hasVillageDesert = biomes.contains("VillageDesert") && ctx.hasTag(BiomeTags.HAS_VILLAGE_DESERT);
        boolean hasVillagePlains = biomes.contains("VillagePlains") && ctx.hasTag(BiomeTags.HAS_VILLAGE_PLAINS);
        boolean hasVillageSavanna = biomes.contains("VillageSavanna") && ctx.hasTag(BiomeTags.HAS_VILLAGE_SAVANNA);
        boolean hasVillageSnowy = biomes.contains("VillageSnowy") && ctx.hasTag(BiomeTags.HAS_VILLAGE_SNOWY);
        boolean hasVillageTaiga = biomes.contains("VillageTaiga") && ctx.hasTag(BiomeTags.HAS_VILLAGE_TAIGA);
        //boolean hasTrailRuins = biomes.contains("TrailRuins") && ctx.hasTag(BiomeTags.HAS_TRAIL_RUINS);
        boolean hasWoodlandMansion = biomes.contains("WoodlandMansion") && ctx.hasTag(BiomeTags.HAS_WOODLAND_MANSION);
        boolean hasNetherFortress = biomes.contains("NetherFortress") && ctx.hasTag(BiomeTags.HAS_NETHER_FORTRESS);
        boolean hasNetherFossil = biomes.contains("NetherFossil") && ctx.hasTag(BiomeTags.HAS_NETHER_FOSSIL);
        boolean hasBastionRemnant = biomes.contains("BastionRemnant") && ctx.hasTag(BiomeTags.HAS_BASTION_REMNANT);
        boolean hasAncientCity = biomes.contains("AncientCity") && ctx.hasTag(BiomeTags.HAS_ANCIENT_CITY);
        boolean hasRuinedPortalNether = biomes.contains("RuinedPortalNether") && ctx.hasTag(BiomeTags.HAS_RUINED_PORTAL_NETHER);
        boolean hasEndCity = biomes.contains("EndCity") && ctx.hasTag(BiomeTags.HAS_END_CITY);
        boolean requiredOceanMonumentSurrounding = biomes.contains("RequiredOceanMonumentSurrounding") && ctx.hasTag(BiomeTags.REQUIRED_OCEAN_MONUMENT_SURROUNDING);
        boolean mineshaftBlocking = biomes.contains("MineshaftBlocking") && ctx.hasTag(BiomeTags.MINESHAFT_BLOCKING);

        //Other
        boolean playsUnderwaterMusic = biomes.contains("PlaysUnderwaterMusic") && ctx.hasTag(BiomeTags.PLAYS_UNDERWATER_MUSIC);
        boolean hasCloserWaterFog = biomes.contains("HasCloserWaterFog") && ctx.hasTag(BiomeTags.HAS_CLOSER_WATER_FOG);
        boolean waterOnMapOutlines = biomes.contains("WaterOnMapOutlines") && ctx.hasTag(BiomeTags.WATER_ON_MAP_OUTLINES);
        boolean producesCoralsFromBonemeal = biomes.contains("ProducesCoralsFromBonemeal") && ctx.hasTag(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL);
        //boolean increasedFireBurnout = biomes.contains("IncreasedFireBurnout") && ctx.hasTag(BiomeTags.INCREASED_FIRE_BURNOUT);
        //boolean snowGolemMelts = biomes.contains("SnowGolemMelts") && ctx.hasTag(BiomeTags.SNOW_GOLEM_MELTS);
        boolean withoutZombieSieges = biomes.contains("WithoutZombieSieges") && ctx.hasTag(BiomeTags.WITHOUT_ZOMBIE_SIEGES);
        boolean withoutPatrolSpawns = biomes.contains("WithoutPatrolSpawns") && ctx.hasTag(BiomeTags.WITHOUT_PATROL_SPAWNS);
        boolean withoutWanderingTraderSpawns = biomes.contains("WithoutWanderingTraderSpawns") && ctx.hasTag(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS);
        boolean spawnsColdVariantFrogs = biomes.contains("SpawnsColdVariantFrogs") && ctx.hasTag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS);
        boolean spawnsWarmVariantFrogs = biomes.contains("SpawnsWarmVariantFrogs") && ctx.hasTag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS);
        //boolean spawnsGoldRabbits = biomes.contains("SpawnsGoldRabbits") && ctx.hasTag(BiomeTags.SPAWNS_GOLD_RABBITS);
        //boolean spawnsWhiteRabbits = biomes.contains("SpawnsWhiteRabbits") && ctx.hasTag(BiomeTags.SPAWNS_WHITE_RABBITS);
        boolean reducedWaterAmbientSpawns = biomes.contains("ReducedWaterAmbientSpawns") && ctx.hasTag(BiomeTags.REDUCED_WATER_AMBIENT_SPAWNS);
        boolean allowsTropicalFishSpawnsAtAnyHeight = biomes.contains("AllowsTropicalFishSpawnsAtAnyHeight") && ctx.hasTag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT);
        boolean polarBearsSpawnOnAlternateBlocks = biomes.contains("PolarBearsSpawnOnAlternateBlocks") && ctx.hasTag(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS);
        boolean moreFrequentDrownedSpawns = biomes.contains("MoreFrequentDrownedSpawns") && ctx.hasTag(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS);
        boolean allowsSurfaceSlimeSpawns = biomes.contains("AllowsSurfaceSlimeSpawns") && ctx.hasTag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS);
        //boolean spawnsSnowFoxes = biomes.contains("SpawnsSnowFoxes") && ctx.hasTag(BiomeTags.SPAWNS_SNOW_FOXES);

        //Custom
        boolean isCustomBiome = false;

        for (TagKey<Biome> customBiome : customBiomes) {
            if (ctx.hasTag(customBiome)) {//Tag found, so the biome is one of the custom ones
                isCustomBiome = true;
                break;
            }
        }

        return inOverworldBiome || inNetherBiome || inEndBiome || inDeepOcean || inOcean || inBeach
                || inRiver || inMountain || inBadlands || inHill || inTaiga || inJungle || inForest
                || inSavanna || strongholdBiasedTo || hasBuriedTreasure || hasDesertPyramid || hasIgloo
                || hasJungleTemple || hasMineshaft || hasMineshaftMesa || hasOceanMonument || hasOceanRuinCold
                ||  hasOceanRuinWarm || hasPillagerOutpost || hasRuinedPortalDesert || hasRuinedPortalJungle
                || hasRuinedPortalOcean || hasRuinedPortalSwamp || hasRuinedPortalMountain || hasRuinedPortalStandard
                || hasShipwreckBeached || hasShipwreck || hasStronghold || hasSwampHut || hasVillageDesert
                || hasVillagePlains || hasVillageSavanna || hasVillageSnowy || hasVillageTaiga
                || hasWoodlandMansion || hasNetherFortress || hasNetherFossil || hasBastionRemnant || hasAncientCity
                || hasRuinedPortalNether || hasEndCity || requiredOceanMonumentSurrounding || mineshaftBlocking
                || playsUnderwaterMusic || hasCloserWaterFog || waterOnMapOutlines || producesCoralsFromBonemeal
                || withoutZombieSieges || withoutPatrolSpawns
                || withoutWanderingTraderSpawns || spawnsColdVariantFrogs || spawnsWarmVariantFrogs
                || reducedWaterAmbientSpawns || allowsTropicalFishSpawnsAtAnyHeight
                || polarBearsSpawnOnAlternateBlocks || moreFrequentDrownedSpawns || allowsSurfaceSlimeSpawns;
    }
}
