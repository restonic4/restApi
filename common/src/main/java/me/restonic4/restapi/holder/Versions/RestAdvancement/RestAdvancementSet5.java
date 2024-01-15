package me.restonic4.restapi.holder.Versions.RestAdvancement;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class RestAdvancementSet5 {
    private RegistrySupplier<CriterionTrigger<?>> criterionHolder;
    private ResourceLocation resourceLocation;

    public RestAdvancementSet5() {}

    public void setCriterionHolder(RegistrySupplier<CriterionTrigger<?>> criterionHolder) {
        this.criterionHolder = criterionHolder;
    }

    public void setResourceLocation(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public AdvancementHolder getAdvancement(ServerPlayer serverPlayer) {
        return serverPlayer.server.getAdvancements().get(resourceLocation);
    }

    public void award(ServerPlayer serverPlayer) {
        AdvancementHolder avdHolder = this.getAdvancement(serverPlayer);

        serverPlayer.getAdvancements().award(avdHolder, resourceLocation.getPath());
    }

    public boolean hasAdvancement(ServerPlayer serverPlayer) {
        AdvancementHolder avdHolder = this.getAdvancement(serverPlayer);

        return serverPlayer.getAdvancements().getOrStartProgress(avdHolder).isDone();
    }

    public RegistrySupplier<CriterionTrigger<?>> get() {
        return criterionHolder;
    }
}
