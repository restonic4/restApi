package me.restonic4.restapi.block;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.RegistryVersions.BlockRegistrySet1;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

@SuppressWarnings("unchecked")
public class BlockRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        RestApi.Log("Creating block registry", ModId);
        return BlockRegistrySet1.createRegistry(ModId);
    }

    /**
     * Get the registry of block.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return BlockRegistrySet1.getModRegistry(ModId);
    }

    /**
     * This creates block with an item.
     * @param ModId The mod id.
     * @param BlockId The item and block id.
     * @param Properties The block properties. You can create it manually or using BlockRegistry.CreateBasicProperties().
     * @param CreativeTab The creative tab or null.
     * @return Returns the block.
     */
    public static Object CreateBlock(String ModId, String BlockId, Object Properties, Object CreativeTab) {
        return BlockRegistrySet1.createBlock(ModId, BlockId, (BlockBehaviour.Properties) Properties, CreativeTab);
    }

    /**
     * This creates properties for blocks.
     * @param BlockBase This is the base of your block.
     * @param Hardness How long does it take to break with your hand/tool.
     * @param BlastResistance How much it resists to explosions.
     * @param SoundBase The sounds it makes. This makes a copy.
     * @param RequireToolForDrop If the block requires a tool to drop items from the loot-table.
     * @param IsIgnitedByLava If the catch on fire if it is near lava.
     * @return Returns the properties.
     */
    public static Object CreateBasicProperties(Object BlockBase, float Hardness, float BlastResistance, Object SoundBase, float SoundsStrength, boolean RequireToolForDrop, boolean IsIgnitedByLava) {
        return BlockRegistrySet1.createBlockProperties((Block) BlockBase, Hardness, BlastResistance, (SoundType) SoundBase, SoundsStrength, RequireToolForDrop, IsIgnitedByLava);
    }

    /**
     * This registers all of your blocks.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register blocks", ModId);

        BlockRegistrySet1.register(ModId);

        RestApi.Log("Blocks registered", ModId);
    }
}
