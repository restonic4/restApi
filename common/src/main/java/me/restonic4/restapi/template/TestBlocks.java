package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.sound.SoundRegistry;
import me.restonic4.restapi.util.BiomeConditions;
import me.restonic4.restapi.util.CustomBlockProperties;
import me.restonic4.restapi.worldgen.ore.OreGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static me.restonic4.restapi.RestApiVariables.MOD_ID;

public class TestBlocks {
    public static final Object customSounds = SoundRegistry.CreateCustomSoundType(1, 1, TestSounds.sound, TestSounds.sound, TestSounds.sound, TestSounds.sound, TestSounds.sound);
    public static final Object block = BlockRegistry.CreateBlock(
            MOD_ID,
            "new_block",
            new CustomBlockProperties()
                    .copy(Blocks.IRON_BLOCK)
                    .strength(5, 6)
                    .sound(customSounds)
                    .strength(1)
                    .requiresCorrectToolForDrops()
                    .ignitedByLava()
                    .noCollission()
                    .build(),
            TestTabs.tab
    );

    public static void register() {
        BlockRegistry.Register(MOD_ID);

        OreGenerator.RegisterOreGeneration(
                MOD_ID,
                "new_block",
                new BiomeConditions().isOverworld().isNether()
        );

        RestApi.Log("Blocks added");
    }
}
