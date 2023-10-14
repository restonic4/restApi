package me.restonic4.restapi.util.UtilVersions.CustomBlockProperties;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomBlockPropertiesSet1 {
    private BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.STONE);

    public CustomBlockPropertiesSet1 copy(Block base) {
        properties = BlockBehaviour.Properties.copy(base);

        return this;
    }

    public CustomBlockPropertiesSet1 strength(float hardness, float blastResistance) {
        properties = properties.strength(hardness, blastResistance);

        return this;
    }

    public CustomBlockPropertiesSet1 strength(float soundsStrength) {
        properties = properties.strength(soundsStrength);

        return this;
    }

    public CustomBlockPropertiesSet1 sound(Object soundType) {
        properties = properties.sound((SoundType) soundType);

        return this;
    }

    public CustomBlockPropertiesSet1 requiresCorrectToolForDrops() {
        properties = properties.requiresCorrectToolForDrops();

        return this;
    }

    public CustomBlockPropertiesSet1 ignitedByLava() {
        properties = properties.ignitedByLava();

        return this;
    }

    public CustomBlockPropertiesSet1 destroyTime(float destroyTime) {
        properties = properties.destroyTime(destroyTime);

        return this;
    }

    public CustomBlockPropertiesSet1 dropsLike(Block block) {
        properties = properties.dropsLike(block);

        return this;
    }

    public CustomBlockPropertiesSet1 dynamicShape() {
        properties = properties.dynamicShape();

        return this;
    }

    public CustomBlockPropertiesSet1 explosionResistance(float explosionResistance) {
        properties = properties.explosionResistance(explosionResistance);

        return this;
    }

    public CustomBlockPropertiesSet1 instabreak() {
        properties = properties.instabreak();

        return this;
    }

    public CustomBlockPropertiesSet1 forceSolidOn() {
        properties = properties.forceSolidOn();

        return this;
    }

    public CustomBlockPropertiesSet1 friction(float friction) {
        properties = properties.friction(friction);

        return this;
    }

    public CustomBlockPropertiesSet1 jumpFactor(float jumpFactor) {
        properties = properties.jumpFactor(jumpFactor);

        return this;
    }

    public CustomBlockPropertiesSet1 liquid() {
        properties = properties.liquid();

        return this;
    }

    public CustomBlockPropertiesSet1 noCollission() {
        properties = properties.noCollission();

        return this;
    }

    public CustomBlockPropertiesSet1 noLootTable() {
        properties = properties.noLootTable();

        return this;
    }

    public CustomBlockPropertiesSet1 noOcclusion() {
        properties = properties.noOcclusion();

        return this;
    }

    public CustomBlockPropertiesSet1 noParticlesOnBreak() {
        properties = properties.noParticlesOnBreak();

        return this;
    }

    public CustomBlockPropertiesSet1 randomTicks() {
        properties = properties.randomTicks();

        return this;
    }

    public CustomBlockPropertiesSet1 replaceable() {
        properties = properties.replaceable();

        return this;
    }

    public CustomBlockPropertiesSet1 speedFactor(float speedFactor) {
        properties = properties.speedFactor(speedFactor);

        return this;
    }

    public BlockBehaviour.Properties build() {
        return properties;
    }
}