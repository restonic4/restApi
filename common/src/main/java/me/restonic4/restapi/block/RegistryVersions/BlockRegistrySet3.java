package me.restonic4.restapi.block.RegistryVersions;

import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static me.restonic4.restapi.RestApiVariables.*;

public class BlockRegistrySet3 {
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

            if (DEFAULT == null && Objects.equals(REGISTRIES.get(i).getRegistrarManager().getModId(), MOD_ID)) {
                DEFAULT = REGISTRIES.get(i);
            }
        }

        //If there is no registry, then use the default one
        if (BLOCKS == null) {
            //If there is no default registry, then create it and get it.
            if (DEFAULT == null) {
                RestApi.Log("Registry not found, try creating one with BlockRegistry.CreateRegistry(ModID).");

                createRegistry(MOD_ID);
            }

            BLOCKS = getModRegistry(MOD_ID);
        }

        return BLOCKS;
    }

    public static RegistrySupplier<Block> createBlock(String ModId, String blockId, BlockBehaviour.Properties properties, Object creativeTab) {
        return registerBlock(
                ModId,
                blockId,
                () -> new Block(properties),
                creativeTab
        );
    }

    public static RegistrySupplier<Block> createExperienceBlock(String ModId, String blockId, BlockBehaviour.Properties properties, Object creativeTab, int minXP, int maxXP) {
        return registerBlock(
                ModId,
                blockId,
                () -> new DropExperienceBlock(properties, UniformInt.of(minXP, maxXP)),
                creativeTab
        );
    }

    public static <T extends Block> RegistrySupplier<T> registerBlock(String ModId, String blockId, Supplier<T> block, Object creativeTab) {
        RegistrySupplier<T> toReturn = registerInDesiredPlatform(ModId, new ResourceLocation(ModId, blockId), block);
        ItemRegistry.CreateBlockItem(ModId, toReturn, blockId, creativeTab);

        return toReturn;
    }

    public static <T extends Block> RegistrySupplier<T> registerInDesiredPlatform(String ModId, ResourceLocation path, Supplier<T> block) {
        if (Platform.isForge()) {
            return getModRegistry(ModId).register(path.getPath(), block);
        }
        return getModRegistry(ModId).getRegistrar().register(path, block);
    }

    public static void register(String ModId) {
        getModRegistry(ModId).register();
    }
}
