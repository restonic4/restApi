package me.restonic4.restapi.block;

import dev.architectury.registry.registries.DeferredSupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.RegistryVersions.BlockRegistrySet1;
import me.restonic4.restapi.item.RegistryVersions.ItemRegistrySet1;
import net.minecraft.sounds.SoundEvent;
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
        //1.20 - 1.20.2
        return BlockRegistrySet1.createRegistry(ModId);
    }

    /**
     * Get the registry of block.
     * @param ModId The mod id.
     * @return Returns the registry as Object type.
     */
    public static Object GetRegistry(String ModId) {
        //1.20 -> 1.20.2
        return BlockRegistrySet1.getModRegistry(ModId);
    }

    /**
     * This creates block with an item.
     * @param ModId The mod id.
     * @param ItemId The item and block id.
     * @param CreativeTab The creative tab or null.
     * @param Properties The block properties. You can create it manually or using BlockRegistry.CreateBasicProperties().
     * @return Returns the block.
     */
    public static Object CreateBlock(String ModId, String ItemId, Object CreativeTab, Object Properties) {
        //1.20 -> 1.20.2
        return BlockRegistrySet1.createBlock(ModId, ItemId, (DeferredSupplier<CreativeModeTab>)CreativeTab, (BlockBehaviour.Properties) Properties);
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
    public static Object CreateBasicProperties(Object BlockBase, float Hardness, float BlastResistance, Object SoundBase, boolean RequireToolForDrop, boolean IsIgnitedByLava) {
        //1.20 -> 1.20.2
        return BlockRegistrySet1.createBlockProperties((Block) BlockBase, Hardness, BlastResistance, (SoundType) SoundBase, RequireToolForDrop, IsIgnitedByLava);
    }

    /**
     * This creates a sound type.
     * @param Volume The volume. 0 : 1
     * @param Pitch The pitch. -1 : 1
     * @param BreakSound The sound when it breaks.
     * @param StepSound The sound when you walk on it.
     * @param PlaceSound The sound when you place it.
     * @param HitSound The sound when you start breaking it.
     * @param FallSound The sound when you fall on it.
     * @return Returns the sound type as Object.
     */
    public static Object CreateCustomSoundType(float Volume, float Pitch, Object BreakSound, Object StepSound, Object PlaceSound, Object HitSound, Object FallSound) {
        //1.20 -> 1.20.2
        return BlockRegistrySet1.createCustomSoundType(Volume, Pitch, (SoundEvent)BreakSound, (SoundEvent)StepSound, (SoundEvent)PlaceSound, (SoundEvent)HitSound, (SoundEvent)FallSound);
    }

    /**
     * This registers all of your blocks.
     * @param ModId Your mod id.
     */
    public static void Register(String ModId) {
        RestApi.Log("Trying to register blocks", ModId);

        //1.20 - 1.20.2
        BlockRegistrySet1.register(ModId);

        RestApi.Log("Blocks registered", ModId);
    }
}
