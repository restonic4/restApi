package me.restonic4.restapi.util;

import me.restonic4.restapi.util.UtilVersions.CustomBlockProperties.CustomBlockPropertiesSet1;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CustomBlockProperties extends CustomBlockPropertiesSet1 {
    public CustomBlockProperties copy(Block base) {
        super.copy(base);
        return this;
    }

    public CustomBlockProperties strength(float hardness, float blastResistance) {
        super.strength(hardness, blastResistance);
        return this;
    }

    public CustomBlockProperties strength(float hardness) {
        super.strength(hardness);
        return this;
    }

    public CustomBlockProperties sound(Object soundType) {
        super.sound(soundType);
        return this;
    }

    public CustomBlockProperties requiresCorrectToolForDrops() {
        super.requiresCorrectToolForDrops();
        return this;
    }

    public CustomBlockProperties ignitedByLava() {
        super.ignitedByLava();
        return this;
    }

    public CustomBlockProperties destroyTime(float destroyTime) {
        super.destroyTime(destroyTime);
        return this;
    }

    public CustomBlockProperties dropsLike(Block block) {
        super.dropsLike(block);
        return this;
    }

    public CustomBlockProperties dynamicShape() {
        super.dynamicShape();
        return this;
    }

    public CustomBlockProperties explosionResistance(float explosionResistance) {
        super.explosionResistance(explosionResistance);
        return this;
    }

    public CustomBlockProperties instabreak() {
        super.instabreak();
        return this;
    }

    public CustomBlockProperties forceSolidOn() {
        super.forceSolidOn();
        return this;
    }

    public CustomBlockProperties friction(float friction) {
        super.friction(friction);
        return this;
    }

    public CustomBlockProperties jumpFactor(float jumpFactor) {
        super.jumpFactor(jumpFactor);
        return this;
    }

    public CustomBlockProperties liquid() {
        super.liquid();
        return this;
    }

    public CustomBlockProperties noCollission() {
        super.noCollission();
        return this;
    }

    public CustomBlockProperties noLootTable() {
        super.noLootTable();
        return this;
    }

    public CustomBlockProperties noOcclusion() {
        super.noOcclusion();
        return this;
    }

    public CustomBlockProperties noParticlesOnBreak() {
        super.noParticlesOnBreak();
        return this;
    }

    public CustomBlockProperties randomTicks() {
        super.randomTicks();
        return this;
    }

    public CustomBlockProperties replaceable() {
        super.replaceable();
        return this;
    }

    public CustomBlockProperties speedFactor(float speedFactor) {
        super.speedFactor(speedFactor);
        return this;
    }

    public CustomBlockProperties pushReaction(Object pushReaction) {
        super.pushReaction(pushReaction);
        return this;
    }

    public BlockBehaviour.Properties build() {
        return super.build();
    }
}
