package me.restonic4.restapi.util.UtilVersions.CustomBlockProperties;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomBlockPropertiesSet3 {
    private BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.STONE);

    public CustomBlockPropertiesSet3 copy(Block base) {
        properties = BlockBehaviour.Properties.copy(base);

        return this;
    }

    public CustomBlockPropertiesSet3 strength(float hardness, float blastResistance) {
        properties = properties.strength(hardness, blastResistance);

        return this;
    }

    public CustomBlockPropertiesSet3 strength(float soundsStrength) {
        properties = properties.strength(soundsStrength);

        return this;
    }

    public CustomBlockPropertiesSet3 sound(Object soundType) {
        properties = properties.sound((SoundType) soundType);

        return this;
    }

    public CustomBlockPropertiesSet3 requiresCorrectToolForDrops() {
        properties = properties.requiresCorrectToolForDrops();

        return this;
    }

    public CustomBlockPropertiesSet3 ignitedByLava() {
        properties = properties.ignitedByLava();

        return this;
    }

    public CustomBlockPropertiesSet3 destroyTime(float destroyTime) {
        properties = properties.destroyTime(destroyTime);

        return this;
    }

    public CustomBlockPropertiesSet3 dropsLike(Block block) {
        properties = properties.dropsLike(block);

        return this;
    }

    public CustomBlockPropertiesSet3 dynamicShape() {
        properties = properties.dynamicShape();

        return this;
    }

    public CustomBlockPropertiesSet3 explosionResistance(float explosionResistance) {
        properties = properties.explosionResistance(explosionResistance);

        return this;
    }

    public CustomBlockPropertiesSet3 instabreak() {
        properties = properties.instabreak();

        return this;
    }

    public CustomBlockPropertiesSet3 forceSolidOn() {
        properties = properties.forceSolidOn();

        return this;
    }

    public CustomBlockPropertiesSet3 friction(float friction) {
        properties = properties.friction(friction);

        return this;
    }

    public CustomBlockPropertiesSet3 jumpFactor(float jumpFactor) {
        properties = properties.jumpFactor(jumpFactor);

        return this;
    }

    public CustomBlockPropertiesSet3 liquid() {
        properties = properties.liquid();

        return this;
    }

    public CustomBlockPropertiesSet3 noCollission() {
        properties = properties.noCollission();

        return this;
    }

    public CustomBlockPropertiesSet3 noLootTable() {
        properties = properties.noLootTable();

        return this;
    }

    public CustomBlockPropertiesSet3 noOcclusion() {
        properties = properties.noOcclusion();

        return this;
    }

    public CustomBlockPropertiesSet3 noParticlesOnBreak() {
        properties = properties.noTerrainParticles();

        return this;
    }

    public CustomBlockPropertiesSet3 randomTicks() {
        properties = properties.randomTicks();

        return this;
    }

    public CustomBlockPropertiesSet3 replaceable() {
        properties = properties.replaceable();

        return this;
    }

    public CustomBlockPropertiesSet3 speedFactor(float speedFactor) {
        properties = properties.speedFactor(speedFactor);

        return this;
    }

    public BlockBehaviour.Properties build() {
        return properties;
    }
}