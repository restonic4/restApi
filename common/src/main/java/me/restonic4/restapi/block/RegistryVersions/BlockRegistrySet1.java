package me.restonic4.restapi.block.RegistryVersions;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class BlockRegistrySet1 {
    static List<DeferredRegister<Block>> REGISTRIES = new ArrayList<>();
    static DeferredRegister<Block> DEFAULT;

    public static Object createRegistry(String ModId) {
        DeferredRegister<Block> BLOCKS = DeferredRegister.create(ModId, Registries.BLOCK);

        REGISTRIES.add(BLOCKS);

        return BLOCKS;
    }

    //Gets the registry for the client's mod, if you didn't create it, it will create one for you located here, in this mod.
    public static DeferredRegister<Block> getModRegistry(String ModId) {
        DeferredRegister<Block> BLOCKS = null;

        for (int i = 0; i < REGISTRIES.size(); i++) {
            if (Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), ModId)) {
                BLOCKS = REGISTRIES.get(i);
            }

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), RestApi.MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (BLOCKS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with BlockRegistry.CreateRegistry(ModID).");

                createRegistry(RestApi.MOD_ID);
            }

            BLOCKS = getModRegistry(RestApi.MOD_ID);
        }

        return BLOCKS;
    }

    public static BlockBehaviour.Properties createBlockProperties(Block base, float hardness, float blastResistance, SoundType soundType, boolean requireToolForDrop, boolean isIgnitedByLava) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(base).strength(hardness, blastResistance).sound(soundType);

        if (requireToolForDrop) { properties = properties.requiresCorrectToolForDrops(); }
        if (isIgnitedByLava) { properties = properties.ignitedByLava(); }

        return properties;
    }

    public static SoundType createCustomSoundType(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        return new SoundType(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public static RegistrySupplier<Block> createBlock(String ModId, String blockId, DeferredSupplier<CreativeModeTab> CreativeTab, BlockBehaviour.Properties properties) {
        return registerBlock(
                ModId, blockId, CreativeTab,
                () -> new Block(properties)
        );
    }

    public static <T extends Block> RegistrySupplier<T> registerBlock(String ModId, String blockId, DeferredSupplier<CreativeModeTab> CreativeTab, Supplier<T> block) {
        RegistrySupplier<T> toReturn = getModRegistry(ModId).register(blockId, block);
        ItemRegistry.CreateBlockItem(ModId, blockId, CreativeTab, toReturn);

        return toReturn;
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
