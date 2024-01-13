package me.restonic4.restapi.util.Generic;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathHelper {
    private static final String min_smaller_than_max = "The min value must smaller than the max value!";

    /**
     * Gives you a list of positions with a circular shape.
     * @param numPositions Total number of positions.
     * @param radius The radius of the circle.
     * @return The list of BlockPos.
     */
    public static List<BlockPos> generatePositionRing(int numPositions, int radius) {
        List<BlockPos> positions = new ArrayList<>();
        double angleIncrement = 2 * Math.PI / numPositions;

        for (int i = 0; i < numPositions; i++) {
            double angle = i * angleIncrement;

            int x = (int) (radius * Math.cos(angle));
            int z = (int) (radius * Math.sin(angle));

            BlockPos pos = new BlockPos(x, 0, z);

            positions.add(pos);
        }

        return positions;
    }

    /**
     * Handles the error and creates the Random object.
     * @param min min value.
     * @param max max value.
     * @return Random object.
     */
    private static Random getRandom(float min, float max) {
        if (min > max) {
            throw new IllegalArgumentException(min_smaller_than_max);
        }

        return new Random();
    }

    /**
     * Gives you a random int between 2 int values.
     * @param min min value.
     * @param max max value.
     * @return Result int.
     */
    public static int getRandomInt(int min, int max) {
        return getRandom(min, max).nextInt((max - min) + 1) + min;
    }

    /**
     * Gives you a random int between 2 float values.
     * @param min min value.
     * @param max max value.
     * @return Result float.
     */
    public static float getRandomFloat(float min, float max) {
        return getRandom(min, max).nextFloat() * (max - min) + min;
    }
}
