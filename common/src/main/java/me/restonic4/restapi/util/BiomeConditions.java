package me.restonic4.restapi.util;

import dev.architectury.registry.level.biome.BiomeModifications;
import me.restonic4.restapi.util.UtilVersions.BiomeConditions.BiomeConditionsSet1;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeConditions extends BiomeConditionsSet1 {
    //Custom
    public BiomeConditions addCustomBiomeTagKey(TagKey<Biome> tagKey) {
        super.addCustomBiomeTagKey(tagKey);
        return this;
    }

    //Dims
    public BiomeConditions isOverworld() {
        super.isOverworld();
        return this;
    }

    public BiomeConditions isNether() {
        super.isNether();
        return this;
    }

    public BiomeConditions isEnd() {
        super.isEnd();
        return this;
    }

    //Biomes
    public BiomeConditions isDeepOcean() {
        super.isDeepOcean();
        return this;
    }

    public BiomeConditions isOcean() {
        super.isOcean();
        return this;
    }

    public BiomeConditions isBeach() {
        super.isBeach();
        return this;
    }

    public BiomeConditions isRiver() {
        super.isRiver();
        return this;
    }

    public BiomeConditions isMountain() {
        super.isMountain();
        return this;
    }

    public BiomeConditions isBadlands() {
        super.isBadlands();
        return this;
    }

    public BiomeConditions isHill() {
        super.isHill();
        return this;
    }

    public BiomeConditions isTaiga() {
        super.isTaiga();
        return this;
    }

    public BiomeConditions isJungle() {
        super.isJungle();
        return this;
    }

    public BiomeConditions isForest() {
        super.isForest();
        return this;
    }

    public BiomeConditions isSavanna() {
        super.isSavanna();
        return this;
    }

    //Structures
    public BiomeConditions strongholdBiasedTo() {
        super.strongholdBiasedTo();
        return this;
    }

    public BiomeConditions hasBuriedTreasure() {
        super.hasBuriedTreasure();
        return this;
    }

    public BiomeConditions hasDesertPyramid() {
        super.hasDesertPyramid();
        return this;
    }

    public BiomeConditions hasIgloo() {
        super.hasIgloo();
        return this;
    }

    public BiomeConditions hasJungleTemple() {
        super.hasJungleTemple();
        return this;
    }

    public BiomeConditions hasMineshaft() {
        super.hasMineshaft();
        return this;
    }

    public BiomeConditions hasMineshaftMesa() {
        super.hasMineshaftMesa();
        return this;
    }

    public BiomeConditions hasOceanMonument() {
        super.hasOceanMonument();
        return this;
    }

    public BiomeConditions hasOceanRuinCold() {
        super.hasOceanRuinCold();
        return this;
    }

    public BiomeConditions hasOceanRuinWarm() {
        super.hasOceanRuinWarm();
        return this;
    }

    public BiomeConditions hasPillagerOutpost() {
        super.hasPillagerOutpost();
        return this;
    }

    public BiomeConditions hasRuinedPortalDesert() {
        super.hasRuinedPortalDesert();
        return this;
    }

    public BiomeConditions hasRuinedPortalJungle() {
        super.hasRuinedPortalJungle();
        return this;
    }

    public BiomeConditions hasRuinedPortalOcean() {
        super.playsUnderwaterMusic();
        return this;
    }

    public BiomeConditions hasRuinedPortalSwamp() {
        super.hasRuinedPortalSwamp();
        return this;
    }

    public BiomeConditions hasRuinedPortalMountain() {
        super.hasRuinedPortalMountain();
        return this;
    }

    public BiomeConditions hasRuinedPortalStandard() {
        super.hasRuinedPortalStandard();
        return this;
    }

    public BiomeConditions hasShipwreckBeached() {
        super.hasShipwreckBeached();
        return this;
    }

    public BiomeConditions hasShipwreck() {
        super.hasShipwreck();
        return this;
    }

    public BiomeConditions hasStronghold() {
        super.hasStronghold();
        return this;
    }

    public BiomeConditions hasSwampHut() {
        super.hasSwampHut();
        return this;
    }

    public BiomeConditions hasVillageDesert() {
        super.hasVillageDesert();
        return this;
    }

    public BiomeConditions hasVillagePlains() {
        super.hasVillagePlains();
        return this;
    }

    public BiomeConditions hasVillageSavanna() {
        super.hasVillageSavanna();
        return this;
    }

    public BiomeConditions hasVillageSnowy() {
        super.hasVillageSnowy();
        return this;
    }

    public BiomeConditions hasVillageTaiga() {
        super.hasVillageTaiga();
        return this;
    }

    public BiomeConditions hasTrailRuins() {
        super.hasTrailRuins();
        return this;
    }

    public BiomeConditions hasWoodlandMansion() {
        super.hasWoodlandMansion();
        return this;
    }

    public BiomeConditions hasNetherFortress() {
        super.hasNetherFortress();
        return this;
    }

    public BiomeConditions hasNetherFossil() {
        super.hasNetherFossil();
        return this;
    }

    public BiomeConditions hasBastionRemnant() {
        super.hasBastionRemnant();
        return this;
    }

    public BiomeConditions hasAncientCity() {
        super.hasAncientCity();
        return this;
    }

    public BiomeConditions hasRuinedPortalNether() {
        super.hasRuinedPortalNether();
        return this;
    }

    public BiomeConditions hasEndCity() {
        super.hasEndCity();
        return this;
    }

    public BiomeConditions requiredOceanMonumentSurrounding() {
        super.requiredOceanMonumentSurrounding();
        return this;
    }

    public BiomeConditions mineshaftBlocking() {
        super.mineshaftBlocking();
        return this;
    }

    //Other
    public BiomeConditions playsUnderwaterMusic() {
        super.playsUnderwaterMusic();
        return this;
    }

    public BiomeConditions hasCloserWaterFog() {
        super.hasCloserWaterFog();
        return this;
    }

    public BiomeConditions waterOnMapOutlines() {
        super.waterOnMapOutlines();
        return this;
    }

    public BiomeConditions producesCoralsFromBonemeal() {
        super.producesCoralsFromBonemeal();
        return this;
    }

    public BiomeConditions increasedFireBurnout() {
        super.increasedFireBurnout();
        return this;
    }

    public BiomeConditions snowGolemMelts() {
        super.snowGolemMelts();
        return this;
    }

    public BiomeConditions withoutZombieSieges() {
        super.withoutZombieSieges();
        return this;
    }

    public BiomeConditions withoutPatrolSpawns() {
        super.withoutPatrolSpawns();
        return this;
    }

    public BiomeConditions withoutWanderingTraderSpawns() {
        super.withoutWanderingTraderSpawns();
        return this;
    }

    public BiomeConditions spawnsColdVariantFrogs() {
        super.spawnsColdVariantFrogs();
        return this;
    }

    public BiomeConditions spawnsWarmVariantFrogs() {
        super.spawnsWarmVariantFrogs();
        return this;
    }

    public BiomeConditions spawnsGoldRabbits() {
        super.spawnsGoldRabbits();
        return this;
    }

    public BiomeConditions spawnsWhiteRabbits() {
        super.spawnsWhiteRabbits();
        return this;
    }

    public BiomeConditions reducedWaterAmbientSpawns() {
        super.reducedWaterAmbientSpawns();
        return this;
    }

    public BiomeConditions allowsTropicalFishSpawnsAtAnyHeight() {
        super.allowsTropicalFishSpawnsAtAnyHeight();
        return this;
    }

    public BiomeConditions polarBearsSpawnOnAlternateBlocks() {
        super.polarBearsSpawnOnAlternateBlocks();
        return this;
    }

    public BiomeConditions moreFrequentDrownedSpawns() {
        super.moreFrequentDrownedSpawns();
        return this;
    }

    public BiomeConditions allowsSurfaceSlimeSpawns() {
        super.allowsSurfaceSlimeSpawns();
        return this;
    }

    public BiomeConditions spawnsSnowFoxes() {
        super.spawnsSnowFoxes();
        return this;
    }

    public boolean get(BiomeModifications.BiomeContext ctx) {
        return super.get(ctx);
    }
}
