package me.restonic4.restapi.util.UtilVersions.AdvancementTrigger;

import me.restonic4.restapi.util.InternalAdvancementTrigger;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class AdvancementTriggerSet3 {
    public final String advancement_id;
    public final ResourceLocation advancement_location;
    public final InternalAdvancementTrigger advancement;

    public AdvancementTriggerSet3(String mod_id, String id) {
        this.advancement_id = id;
        this.advancement_location = new ResourceLocation(mod_id, id);
        this.advancement = new InternalAdvancementTrigger(this.advancement_location);
    }

    protected void registerCriteriaTriggers() {
        CriteriaTriggers.register(advancement_location.toString(), advancement);
    }

    public void register() {
        registerCriteriaTriggers();
    }

    public void grant(ServerPlayer serverPlayer) {
        AdvancementHolder advancementInstance = getAdvancement(serverPlayer);

        serverPlayer.getAdvancements().award(advancementInstance, this.advancement_id);
    }

    public AdvancementHolder getAdvancement(ServerPlayer serverPlayer) {
        return serverPlayer.server.getAdvancements().get(this.advancement_location);
    }

    public boolean hasAdvancement(ServerPlayer serverPlayer) {
        return serverPlayer.getAdvancements().getOrStartProgress(this.getAdvancement(serverPlayer)).isDone();
    }
}
