package me.restonic4.restapi.util.UtilVersions.CustomBlockProperties;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomBlockPropertiesSet5 {
    private BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE);

    public CustomBlockPropertiesSet5 copy(Block base) {
        properties = BlockBehaviour.Properties.ofFullCopy(base);

        return this;
    }

    public CustomBlockPropertiesSet5 strength(float hardness, float blastResistance) {
        properties = properties.strength(hardness, blastResistance);

        return this;
    }

    public CustomBlockPropertiesSet5 strength(float soundsStrength) {
        properties = properties.strength(soundsStrength);

        return this;
    }

    public CustomBlockPropertiesSet5 sound(Object soundType) {
        properties = properties.sound((SoundType) soundType);

        return this;
    }

    public CustomBlockPropertiesSet5 requiresCorrectToolForDrops() {
        properties = properties.requiresCorrectToolForDrops();

        return this;
    }

    public CustomBlockPropertiesSet5 ignitedByLava() {
        properties = properties.ignitedByLava();

        return this;
    }

    public CustomBlockPropertiesSet5 destroyTime(float destroyTime) {
        properties = properties.destroyTime(destroyTime);

        return this;
    }

    public CustomBlockPropertiesSet5 dropsLike(Block block) {
        properties = properties.dropsLike(block);

        return this;
    }

    public CustomBlockPropertiesSet5 dynamicShape() {
        properties = properties.dynamicShape();

        return this;
    }

    public CustomBlockPropertiesSet5 explosionResistance(float explosionResistance) {
        properties = properties.explosionResistance(explosionResistance);

        return this;
    }

    public CustomBlockPropertiesSet5 instabreak() {
        properties = properties.instabreak();

        return this;
    }

    public CustomBlockPropertiesSet5 forceSolidOn() {
        properties = properties.forceSolidOn();

        return this;
    }

    public CustomBlockPropertiesSet5 friction(float friction) {
        properties = properties.friction(friction);

        return this;
    }

    public CustomBlockPropertiesSet5 jumpFactor(float jumpFactor) {
        properties = properties.jumpFactor(jumpFactor);

        return this;
    }

    public CustomBlockPropertiesSet5 liquid() {
        properties = properties.liquid();

        return this;
    }

    public CustomBlockPropertiesSet5 noCollission() {
        properties = properties.noCollission();

        return this;
    }

    public CustomBlockPropertiesSet5 noLootTable() {
        properties = properties.noLootTable();

        return this;
    }

    public CustomBlockPropertiesSet5 noOcclusion() {
        properties = properties.noOcclusion();

        return this;
    }

    public CustomBlockPropertiesSet5 noParticlesOnBreak() {
        properties = properties.noTerrainParticles();

        return this;
    }

    public CustomBlockPropertiesSet5 randomTicks() {
        properties = properties.randomTicks();

        return this;
    }

    public CustomBlockPropertiesSet5 replaceable() {
        properties = properties.replaceable();

        return this;
    }

    public CustomBlockPropertiesSet5 speedFactor(float speedFactor) {
        properties = properties.speedFactor(speedFactor);

        return this;
    }

    public CustomBlockPropertiesSet5 pushReaction(Object pushReaction) {
        properties = properties.pushReaction((PushReaction) pushReaction);

        return this;
    }

    public BlockBehaviour.Properties build() {
        return properties;
    }
}