package me.restonic4.restapi.util.UtilVersions.CustomBlockProperties;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.RestApiVariables;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomBlockPropertiesSet2 {
    private BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.STONE);

    public CustomBlockPropertiesSet2 copy(Block base) {
        properties = BlockBehaviour.Properties.copy(base);

        return this;
    }

    public CustomBlockPropertiesSet2 strength(float hardness, float blastResistance) {
        properties = properties.strength(hardness, blastResistance);

        return this;
    }

    public CustomBlockPropertiesSet2 strength(float soundsStrength) {
        properties = properties.strength(soundsStrength);

        return this;
    }

    public CustomBlockPropertiesSet2 sound(Object soundType) {
        properties = properties.sound((SoundType) soundType);

        return this;
    }

    public CustomBlockPropertiesSet2 requiresCorrectToolForDrops() {
        properties = properties.requiresCorrectToolForDrops();

        return this;
    }

    public CustomBlockPropertiesSet2 ignitedByLava() {
        API_LOGGER.log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet2 destroyTime(float destroyTime) {
        properties = properties.destroyTime(destroyTime);

        return this;
    }

    public CustomBlockPropertiesSet2 dropsLike(Block block) {
        properties = properties.dropsLike(block);

        return this;
    }

    public CustomBlockPropertiesSet2 dynamicShape() {
        properties = properties.dynamicShape();

        return this;
    }

    public CustomBlockPropertiesSet2 explosionResistance(float explosionResistance) {
        properties = properties.explosionResistance(explosionResistance);

        return this;
    }

    public CustomBlockPropertiesSet2 instabreak() {
        properties = properties.instabreak();

        return this;
    }

    public CustomBlockPropertiesSet2 forceSolidOn() {
        API_LOGGER.log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet2 friction(float friction) {
        properties = properties.friction(friction);

        return this;
    }

    public CustomBlockPropertiesSet2 jumpFactor(float jumpFactor) {
        properties = properties.jumpFactor(jumpFactor);

        return this;
    }

    public CustomBlockPropertiesSet2 liquid() {
        API_LOGGER.log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet2 noCollission() {
        properties = properties.noCollission();

        return this;
    }

    public CustomBlockPropertiesSet2 noLootTable() {
        properties = properties.noLootTable();

        return this;
    }

    public CustomBlockPropertiesSet2 noOcclusion() {
        properties = properties.noOcclusion();

        return this;
    }

    public CustomBlockPropertiesSet2 noParticlesOnBreak() {
        properties = properties.noParticlesOnBreak();

        return this;
    }

    public CustomBlockPropertiesSet2 randomTicks() {
        properties = properties.randomTicks();

        return this;
    }

    public CustomBlockPropertiesSet2 replaceable() {
        API_LOGGER.log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet2 speedFactor(float speedFactor) {
        properties = properties.speedFactor(speedFactor);

        return this;
    }

    public CustomBlockPropertiesSet2 pushReaction(Object pushReaction) {
        API_LOGGER.log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public BlockBehaviour.Properties build() {
        return properties;
    }
}