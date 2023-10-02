package me.restonic4.restapi.template;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TestBlocks {
    public static final Object customSounds = BlockRegistry.CreateCustomSoundType(1, 1, TestSounds.sound, TestSounds.sound, TestSounds.sound, TestSounds.sound, TestSounds.sound);
    public static final Object blockProperties = BlockRegistry.CreateBasicProperties(Blocks.IRON_BLOCK, 5, 6, customSounds, false, true);
    public static final Object block = BlockRegistry.CreateBlock(RestApi.MOD_ID, "new_block", TestTabs.tab, blockProperties);

    public static void register() {
        BlockRegistry.Register(RestApi.MOD_ID);

        RestApi.Log("Blocks added");
    }
}
