package me.restonic4.restapi.holder.Versions.RestAdvancement;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class RestAdvancementSet4 {
    private RegistrySupplier<CriterionTrigger<?>> criterionHolder;
    private ResourceLocation resourceLocation;

    public RestAdvancementSet4() {}

    public void setCriterionHolder(Object criterionHolder) {
        this.criterionHolder = null;
    }

    public void setResourceLocation(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public Advancement getAdvancement(ServerPlayer serverPlayer) {
        return serverPlayer.server.getAdvancements().getAdvancement(resourceLocation);
    }

    public void award(ServerPlayer serverPlayer) {
        Advancement avdHolder = this.getAdvancement(serverPlayer);

        serverPlayer.getAdvancements().award(avdHolder, resourceLocation.getPath());
    }

    public boolean hasAdvancement(ServerPlayer serverPlayer) {
        Advancement avdHolder = this.getAdvancement(serverPlayer);

        return serverPlayer.getAdvancements().getOrStartProgress(avdHolder).isDone();
    }

    public RegistrySupplier<CriterionTrigger<?>> get() {
        return criterionHolder;
    }
}
