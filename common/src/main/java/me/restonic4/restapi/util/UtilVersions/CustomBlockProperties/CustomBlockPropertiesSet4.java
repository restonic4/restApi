package me.restonic4.restapi.util.UtilVersions.CustomBlockProperties;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.RestApiVariables;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

@SuppressWarnings({"UnstableApiUsage","unchecked"})
public class CustomBlockPropertiesSet4 {
    private BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.STONE);

    public CustomBlockPropertiesSet4 copy(Block base) {
        properties = BlockBehaviour.Properties.copy(base);

        return this;
    }

    public CustomBlockPropertiesSet4 strength(float hardness, float blastResistance) {
        properties = properties.strength(hardness, blastResistance);

        return this;
    }

    public CustomBlockPropertiesSet4 strength(float soundsStrength) {
        properties = properties.strength(soundsStrength);

        return this;
    }

    public CustomBlockPropertiesSet4 sound(Object soundType) {
        properties = properties.sound((SoundType) soundType);

        return this;
    }

    public CustomBlockPropertiesSet4 requiresCorrectToolForDrops() {
        properties = properties.requiresCorrectToolForDrops();

        return this;
    }

    public CustomBlockPropertiesSet4 ignitedByLava() {
        RestApi.Log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet4 destroyTime(float destroyTime) {
        properties = properties.destroyTime(destroyTime);

        return this;
    }

    public CustomBlockPropertiesSet4 dropsLike(Block block) {
        properties = properties.dropsLike(block);

        return this;
    }

    public CustomBlockPropertiesSet4 dynamicShape() {
        properties = properties.dynamicShape();

        return this;
    }

    public CustomBlockPropertiesSet4 explosionResistance(float explosionResistance) {
        properties = properties.explosionResistance(explosionResistance);

        return this;
    }

    public CustomBlockPropertiesSet4 instabreak() {
        properties = properties.instabreak();

        return this;
    }

    public CustomBlockPropertiesSet4 forceSolidOn() {
        RestApi.Log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet4 friction(float friction) {
        properties = properties.friction(friction);

        return this;
    }

    public CustomBlockPropertiesSet4 jumpFactor(float jumpFactor) {
        properties = properties.jumpFactor(jumpFactor);

        return this;
    }

    public CustomBlockPropertiesSet4 liquid() {
        RestApi.Log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet4 noCollission() {
        properties = properties.noCollission();

        return this;
    }

    public CustomBlockPropertiesSet4 noLootTable() {
        properties = properties.noLootTable();

        return this;
    }

    public CustomBlockPropertiesSet4 noOcclusion() {
        properties = properties.noOcclusion();

        return this;
    }

    public CustomBlockPropertiesSet4 noParticlesOnBreak() {
        properties = properties.noParticlesOnBreak();

        return this;
    }

    public CustomBlockPropertiesSet4 randomTicks() {
        properties = properties.randomTicks();

        return this;
    }

    public CustomBlockPropertiesSet4 replaceable() {
        RestApi.Log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public CustomBlockPropertiesSet4 speedFactor(float speedFactor) {
        properties = properties.speedFactor(speedFactor);

        return this;
    }

    public CustomBlockPropertiesSet4 pushReaction(Object pushReaction) {
        RestApi.Log(RestApiVariables.NOT_IMPLEMENTED_MC);

        return this;
    }

    public BlockBehaviour.Properties build() {
        return properties;
    }
}