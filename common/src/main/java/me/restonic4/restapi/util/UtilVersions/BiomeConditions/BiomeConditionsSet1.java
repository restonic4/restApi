package me.restonic4.restapi.util.UtilVersions.BiomeConditions;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.tags.BiomeTags;

import java.util.ArrayList;
import java.util.List;

public class BiomeConditionsSet1 {
    private List<String> biomes = new ArrayList<>();

    //Dims
    public BiomeConditionsSet1 isOverworld() {
        if (!biomes.contains("Overworld")) {
            biomes.add("Overworld");
        }
        return this;
    }

    public BiomeConditionsSet1 isNether() {
        if (!biomes.contains("Nether")) {
            biomes.add("Nether");
        }
        return this;
    }

    public BiomeConditionsSet1 isEnd() {
        if (!biomes.contains("End")) {
            biomes.add("End");
        }
        return this;
    }

    //Biomes
    public BiomeConditionsSet1 isDeepOcean() {
        if (!biomes.contains("DeepOcean")) {
            biomes.add("DeepOcean");
        }
        return this;
    }

    public BiomeConditionsSet1 isOcean() {
        if (!biomes.contains("Ocean")) {
            biomes.add("Ocean");
        }
        return this;
    }

    public BiomeConditionsSet1 isBeach() {
        if (!biomes.contains("Beach")) {
            biomes.add("Beach");
        }
        return this;
    }

    public BiomeConditionsSet1 isRiver() {
        if (!biomes.contains("River")) {
            biomes.add("River");
        }
        return this;
    }

    public BiomeConditionsSet1 isMountain() {
        if (!biomes.contains("Mountain")) {
            biomes.add("Mountain");
        }
        return this;
    }

    public BiomeConditionsSet1 isBadlands() {
        if (!biomes.contains("Badlands")) {
            biomes.add("Badlands");
        }
        return this;
    }

    public BiomeConditionsSet1 isHill() {
        if (!biomes.contains("Hill")) {
            biomes.add("Hill");
        }
        return this;
    }

    public BiomeConditionsSet1 isTaiga() {
        if (!biomes.contains("Taiga")) {
            biomes.add("Taiga");
        }
        return this;
    }

    public BiomeConditionsSet1 isJungle() {
        if (!biomes.contains("Jungle")) {
            biomes.add("Jungle");
        }
        return this;
    }

    public BiomeConditionsSet1 isForest() {
        if (!biomes.contains("Forest")) {
            biomes.add("Forest");
        }
        return this;
    }

    public BiomeConditionsSet1 isSavanna() {
        if (!biomes.contains("Savanna")) {
            biomes.add("Savanna");
        }
        return this;
    }

    //Structures
    public BiomeConditionsSet1 strongholdBiasedTo() {
        if (!biomes.contains("StrongholdBiasedTo")) {
            biomes.add("StrongholdBiasedTo");
        }
        return this;
    }

    public BiomeConditionsSet1 hasBuriedTreasure() {
        if (!biomes.contains("HasBuriedTreasure")) {
            biomes.add("HasBuriedTreasure");
        }
        return this;
    }

    public BiomeConditionsSet1 hasDesertPyramid() {
        if (!biomes.contains("HasDesertPyramid")) {
            biomes.add("HasDesertPyramid");
        }
        return this;
    }

    public BiomeConditionsSet1 hasIgloo() {
        if (!biomes.contains("HasIgloo")) {
            biomes.add("HasIgloo");
        }
        return this;
    }

    public BiomeConditionsSet1 hasJungleTemple() {
        if (!biomes.contains("HasJungleTemple")) {
            biomes.add("HasJungleTemple");
        }
        return this;
    }

    public BiomeConditionsSet1 hasMineshaft() {
        if (!biomes.contains("HasMineshaft")) {
            biomes.add("HasMineshaft");
        }
        return this;
    }

    public BiomeConditionsSet1 hasMineshaftMesa() {
        if (!biomes.contains("HasMineshaftMesa")) {
            biomes.add("HasMineshaftMesa");
        }
        return this;
    }

    public BiomeConditionsSet1 hasOceanMonument() {
        if (!biomes.contains("OceanMonument")) {
            biomes.add("OceanMonument");
        }
        return this;
    }

    public BiomeConditionsSet1 hasOceanRuinCold() {
        if (!biomes.contains("OceanRuinCold")) {
            biomes.add("OceanRuinCold");
        }
        return this;
    }

    public BiomeConditionsSet1 hasOceanRuinWarm() {
        if (!biomes.contains("OceanRuinWarm")) {
            biomes.add("OceanRuinWarm");
        }
        return this;
    }

    public BiomeConditionsSet1 hasPillagerOutpost() {
        if (!biomes.contains("PillagerOutpost")) {
            biomes.add("PillagerOutpost");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalDesert() {
        if (!biomes.contains("RuinedPortalDesert")) {
            biomes.add("RuinedPortalDesert");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalJungle() {
        if (!biomes.contains("RuinedPortalJungle")) {
            biomes.add("RuinedPortalJungle");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalOcean() {
        if (!biomes.contains("RuinedPortalOcean")) {
            biomes.add("RuinedPortalOcean");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalSwamp() {
        if (!biomes.contains("RuinedPortalSwamp")) {
            biomes.add("RuinedPortalSwamp");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalMountain() {
        if (!biomes.contains("RuinedPortalMountain")) {
            biomes.add("RuinedPortalMountain");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalStandard() {
        if (!biomes.contains("RuinedPortalStandard")) {
            biomes.add("RuinedPortalStandard");
        }
        return this;
    }

    public BiomeConditionsSet1 hasShipwreckBeached() {
        if (!biomes.contains("ShipwreckBeached")) {
            biomes.add("ShipwreckBeached");
        }
        return this;
    }

    public BiomeConditionsSet1 hasShipwreck() {
        if (!biomes.contains("Shipwreck")) {
            biomes.add("Shipwreck");
        }
        return this;
    }

    public BiomeConditionsSet1 hasStronghold() {
        if (!biomes.contains("Stronghold")) {
            biomes.add("Stronghold");
        }
        return this;
    }

    public BiomeConditionsSet1 hasSwampHut() {
        if (!biomes.contains("SwampHut")) {
            biomes.add("SwampHut");
        }
        return this;
    }

    public BiomeConditionsSet1 hasVillageDesert() {
        if (!biomes.contains("VillageDesert")) {
            biomes.add("VillageDesert");
        }
        return this;
    }

    public BiomeConditionsSet1 hasVillagePlains() {
        if (!biomes.contains("VillagePlains")) {
            biomes.add("VillagePlains");
        }
        return this;
    }

    public BiomeConditionsSet1 hasVillageSavanna() {
        if (!biomes.contains("VillageSavanna")) {
            biomes.add("VillageSavanna");
        }
        return this;
    }

    public BiomeConditionsSet1 hasVillageSnowy() {
        if (!biomes.contains("VillageSnowy")) {
            biomes.add("VillageSnowy");
        }
        return this;
    }

    public BiomeConditionsSet1 hasVillageTaiga() {
        if (!biomes.contains("VillageTaiga")) {
            biomes.add("VillageTaiga");
        }
        return this;
    }

    public BiomeConditionsSet1 hasTrailRuins() {
        if (!biomes.contains("TrailRuins")) {
            biomes.add("TrailRuins");
        }
        return this;
    }

    public BiomeConditionsSet1 hasWoodlandMansion() {
        if (!biomes.contains("WoodlandMansion")) {
            biomes.add("WoodlandMansion");
        }
        return this;
    }

    public BiomeConditionsSet1 hasNetherFortress() {
        if (!biomes.contains("NetherFortress")) {
            biomes.add("NetherFortress");
        }
        return this;
    }

    public BiomeConditionsSet1 hasNetherFossil() {
        if (!biomes.contains("NetherFossil")) {
            biomes.add("NetherFossil");
        }
        return this;
    }

    public BiomeConditionsSet1 hasBastionRemnant() {
        if (!biomes.contains("BastionRemnant")) {
            biomes.add("BastionRemnant");
        }
        return this;
    }

    public BiomeConditionsSet1 hasAncientCity() {
        if (!biomes.contains("AncientCity")) {
            biomes.add("AncientCity");
        }
        return this;
    }

    public BiomeConditionsSet1 hasRuinedPortalNether() {
        if (!biomes.contains("RuinedPortalNether")) {
            biomes.add("RuinedPortalNether");
        }
        return this;
    }

    public BiomeConditionsSet1 hasEndCity() {
        if (!biomes.contains("EndCity")) {
            biomes.add("EndCity");
        }
        return this;
    }

    public BiomeConditionsSet1 requiredOceanMonumentSurrounding() {
        if (!biomes.contains("RequiredOceanMonumentSurrounding")) {
            biomes.add("RequiredOceanMonumentSurrounding");
        }
        return this;
    }

    public BiomeConditionsSet1 mineshaftBlocking() {
        if (!biomes.contains("MineshaftBlocking")) {
            biomes.add("MineshaftBlocking");
        }
        return this;
    }

    //Other
    public BiomeConditionsSet1 playsUnderwaterMusic() {
        if (!biomes.contains("PlaysUnderwaterMusic")) {
            biomes.add("PlaysUnderwaterMusic");
        }
        return this;
    }

    public BiomeConditionsSet1 hasCloserWaterFog() {
        if (!biomes.contains("HasCloserWaterFog")) {
            biomes.add("HasCloserWaterFog");
        }
        return this;
    }

    public BiomeConditionsSet1 waterOnMapOutlines() {
        if (!biomes.contains("WaterOnMapOutlines")) {
            biomes.add("WaterOnMapOutlines");
        }
        return this;
    }

    public BiomeConditionsSet1 producesCoralsFromBonemeal() {
        if (!biomes.contains("ProducesCoralsFromBonemeal")) {
            biomes.add("ProducesCoralsFromBonemeal");
        }
        return this;
    }

    public BiomeConditionsSet1 increasedFireBurnout() {
        if (!biomes.contains("IncreasedFireBurnout")) {
            biomes.add("IncreasedFireBurnout");
        }
        return this;
    }

    public BiomeConditionsSet1 snowGolemMelts() {
        if (!biomes.contains("SnowGolemMelts")) {
            biomes.add("SnowGolemMelts");
        }
        return this;
    }

    public BiomeConditionsSet1 withoutZombieSieges() {
        if (!biomes.contains("WithoutZombieSieges")) {
            biomes.add("WithoutZombieSieges");
        }
        return this;
    }

    public BiomeConditionsSet1 withoutPatrolSpawns() {
        if (!biomes.contains("WithoutPatrolSpawns")) {
            biomes.add("WithoutPatrolSpawns");
        }
        return this;
    }

    public BiomeConditionsSet1 withoutWanderingTraderSpawns() {
        if (!biomes.contains("WithoutWanderingTraderSpawns")) {
            biomes.add("WithoutWanderingTraderSpawns");
        }
        return this;
    }

    public BiomeConditionsSet1 spawnsColdVariantFrogs() {
        if (!biomes.contains("SpawnsColdVariantFrogs")) {
            biomes.add("SpawnsColdVariantFrogs");
        }
        return this;
    }

    public BiomeConditionsSet1 spawnsWarmVariantFrogs() {
        if (!biomes.contains("SpawnsWarmVariantFrogs")) {
            biomes.add("SpawnsWarmVariantFrogs");
        }
        return this;
    }

    public BiomeConditionsSet1 spawnsGoldRabbits() {
        if (!biomes.contains("SpawnsGoldRabbits")) {
            biomes.add("SpawnsGoldRabbits");
        }
        return this;
    }

    public BiomeConditionsSet1 spawnsWhiteRabbits() {
        if (!biomes.contains("SpawnsWhiteRabbits")) {
            biomes.add("SpawnsWhiteRabbits");
        }
        return this;
    }

    public BiomeConditionsSet1 reducedWaterAmbientSpawns() {
        if (!biomes.contains("ReducedWaterAmbientSpawns")) {
            biomes.add("ReducedWaterAmbientSpawns");
        }
        return this;
    }

    public BiomeConditionsSet1 allowsTropicalFishSpawnsAtAnyHeight() {
        if (!biomes.contains("AllowsTropicalFishSpawnsAtAnyHeight")) {
            biomes.add("AllowsTropicalFishSpawnsAtAnyHeight");
        }
        return this;
    }

    public BiomeConditionsSet1 polarBearsSpawnOnAlternateBlocks() {
        if (!biomes.contains("PolarBearsSpawnOnAlternateBlocks")) {
            biomes.add("PolarBearsSpawnOnAlternateBlocks");
        }
        return this;
    }

    public BiomeConditionsSet1 moreFrequentDrownedSpawns() {
        if (!biomes.contains("MoreFrequentDrownedSpawns")) {
            biomes.add("MoreFrequentDrownedSpawns");
        }
        return this;
    }

    public BiomeConditionsSet1 allowsSurfaceSlimeSpawns() {
        if (!biomes.contains("AllowsSurfaceSlimeSpawns")) {
            biomes.add("AllowsSurfaceSlimeSpawns");
        }
        return this;
    }

    public BiomeConditionsSet1 spawnsSnowFoxes() {
        if (!biomes.contains("SpawnsSnowFoxes")) {
            biomes.add("SpawnsSnowFoxes");
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
        boolean hasTrailRuins = biomes.contains("TrailRuins") && ctx.hasTag(BiomeTags.HAS_TRAIL_RUINS);
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
        boolean increasedFireBurnout = biomes.contains("IncreasedFireBurnout") && ctx.hasTag(BiomeTags.INCREASED_FIRE_BURNOUT);
        boolean snowGolemMelts = biomes.contains("SnowGolemMelts") && ctx.hasTag(BiomeTags.SNOW_GOLEM_MELTS);
        boolean withoutZombieSieges = biomes.contains("WithoutZombieSieges") && ctx.hasTag(BiomeTags.WITHOUT_ZOMBIE_SIEGES);
        boolean withoutPatrolSpawns = biomes.contains("WithoutPatrolSpawns") && ctx.hasTag(BiomeTags.WITHOUT_PATROL_SPAWNS);
        boolean withoutWanderingTraderSpawns = biomes.contains("WithoutWanderingTraderSpawns") && ctx.hasTag(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS);
        boolean spawnsColdVariantFrogs = biomes.contains("SpawnsColdVariantFrogs") && ctx.hasTag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS);
        boolean spawnsWarmVariantFrogs = biomes.contains("SpawnsWarmVariantFrogs") && ctx.hasTag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS);
        boolean spawnsGoldRabbits = biomes.contains("SpawnsGoldRabbits") && ctx.hasTag(BiomeTags.SPAWNS_GOLD_RABBITS);
        boolean spawnsWhiteRabbits = biomes.contains("SpawnsWhiteRabbits") && ctx.hasTag(BiomeTags.SPAWNS_WHITE_RABBITS);
        boolean reducedWaterAmbientSpawns = biomes.contains("ReducedWaterAmbientSpawns") && ctx.hasTag(BiomeTags.REDUCED_WATER_AMBIENT_SPAWNS);
        boolean allowsTropicalFishSpawnsAtAnyHeight = biomes.contains("AllowsTropicalFishSpawnsAtAnyHeight") && ctx.hasTag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT);
        boolean polarBearsSpawnOnAlternateBlocks = biomes.contains("PolarBearsSpawnOnAlternateBlocks") && ctx.hasTag(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS);
        boolean moreFrequentDrownedSpawns = biomes.contains("MoreFrequentDrownedSpawns") && ctx.hasTag(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS);
        boolean allowsSurfaceSlimeSpawns = biomes.contains("AllowsSurfaceSlimeSpawns") && ctx.hasTag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS);
        boolean spawnsSnowFoxes = biomes.contains("SpawnsSnowFoxes") && ctx.hasTag(BiomeTags.SPAWNS_SNOW_FOXES);

        return inOverworldBiome || inNetherBiome || inEndBiome || inDeepOcean || inOcean || inBeach
                || inRiver || inMountain || inBadlands || inHill || inTaiga || inJungle || inForest
                || inSavanna || strongholdBiasedTo || hasBuriedTreasure || hasDesertPyramid || hasIgloo
                || hasJungleTemple || hasMineshaft || hasMineshaftMesa || hasOceanMonument || hasOceanRuinCold
                ||  hasOceanRuinWarm || hasPillagerOutpost || hasRuinedPortalDesert || hasRuinedPortalJungle
                || hasRuinedPortalOcean || hasRuinedPortalSwamp || hasRuinedPortalMountain || hasRuinedPortalStandard
                || hasShipwreckBeached || hasShipwreck || hasStronghold || hasSwampHut || hasVillageDesert
                || hasVillagePlains || hasVillageSavanna || hasVillageSnowy || hasVillageTaiga || hasTrailRuins
                || hasWoodlandMansion || hasNetherFortress || hasNetherFossil || hasBastionRemnant || hasAncientCity
                || hasRuinedPortalNether || hasEndCity || requiredOceanMonumentSurrounding || mineshaftBlocking
                || playsUnderwaterMusic || hasCloserWaterFog || waterOnMapOutlines || producesCoralsFromBonemeal
                || increasedFireBurnout || snowGolemMelts || withoutZombieSieges || withoutPatrolSpawns
                || withoutWanderingTraderSpawns || spawnsColdVariantFrogs || spawnsWarmVariantFrogs || spawnsGoldRabbits
                || spawnsWhiteRabbits || reducedWaterAmbientSpawns || allowsTropicalFishSpawnsAtAnyHeight
                || polarBearsSpawnOnAlternateBlocks || moreFrequentDrownedSpawns || allowsSurfaceSlimeSpawns || spawnsSnowFoxes;
    }
}
