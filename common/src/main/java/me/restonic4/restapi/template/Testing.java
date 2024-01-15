package me.restonic4.restapi.template;

import dev.architectury.event.EventHandler;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.registry.registries.RegistrySupplier;
import me.restonic4.restapi.RestApi;
import me.restonic4.restapi.sound.SoundRegistry;
import me.restonic4.restapi.util.CustomArmorMaterial;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import static me.restonic4.restapi.RestApiVariables.API_LOGGER;

public class Testing {
    public static void init() {
        API_LOGGER.log("Testing class started");

        TestItems.register();
        TestBlocks.register();
        TestTabs.register();
        TestSounds.register();
        TestUtil.register();

        API_LOGGER.log("Testing things created");

        InteractionEvent.CLIENT_RIGHT_CLICK_AIR.register((Player player, InteractionHand hand) -> {
            SoundRegistry.PlaySound(player, TestSounds.sound, SoundSource.PLAYERS, 1, 1);
        });
    }
}
