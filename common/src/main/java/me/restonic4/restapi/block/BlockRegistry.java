package me.restonic4.restapi.block;

import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.RegistryVersions.BlockRegistrySet4;
import me.restonic4.restapi.holder.RestBlock;
import me.restonic4.restapi.holder.RestCreativeTab;
import net.minecraft.world.level.block.state.BlockBehaviour;

@SuppressWarnings("unchecked")
public class BlockRegistry {
    /**
     * This creates a registry for your mod
     * @param ModId Your mod id.
     */
    public static Object CreateRegistry(String ModId) {
        RestApi.Log("Creating block registry", ModId);
        return BlockRegistrySet4.createRegistry(ModId);
    }

    /**
     * Get the registry of block.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        return BlockRegistrySet4.getModRegistry(ModId);
    }

    /**
     * This creates block with an item.
     * @param ModId The mod id.
     * @param BlockId The item and block id.
     * @param Properties The block properties. You can create it manually or using BlockRegistry.CreateBasicProperties().
     * @param CreativeTab The creative tab or null.
     * @return Returns the block.
     */
    public static RestBlock CreateBlock(String ModId, String BlockId, Object Properties, RestCreativeTab CreativeTab) {
        RestBlock blockHolder = new RestBlock();
        blockHolder.setItemHolder(BlockRegistrySet4.createBlock(ModId, BlockId, (BlockBehaviour.Properties) Properties, CreativeTab));

        return blockHolder;
    }

    public static RestBlock CreateExperienceBlock(String ModId, String BlockId, Object Properties, RestCreativeTab CreativeTab, int MinXP, int MaxXP) {
        RestBlock blockHolder = new RestBlock();
        blockHolder.setItemHolder(BlockRegistrySet4.createExperienceBlock(ModId, BlockId, (BlockBehaviour.Properties) Properties, CreativeTab, MinXP, MaxXP));

        return blockHolder;
    }

    /**
     * This registers all of your blocks.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register blocks", ModId);

        BlockRegistrySet4.register(ModId);

        RestApi.Log("Blocks registered", ModId);
    }
}
