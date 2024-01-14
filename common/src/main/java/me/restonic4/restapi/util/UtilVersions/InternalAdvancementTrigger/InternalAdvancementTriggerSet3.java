package me.restonic4.restapi.util.UtilVersions.InternalAdvancementTrigger;

import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class InternalAdvancementTriggerSet3 extends SimpleCriterionTrigger<InternalAdvancementTriggerSet3.Instance> {
    public final ResourceLocation resourceLocation;

    public InternalAdvancementTriggerSet3(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    protected Instance createInstance(JsonObject jsonObject, Optional<ContextAwarePredicate> optional, DeserializationContext deserializationContext) {
        return null;
    }

    public void trigger(ServerPlayer serverPlayer) {
        this.trigger(serverPlayer, (thingy) -> {
            return true;
        });
    }

    public ResourceLocation getId() {
        return resourceLocation;
    }

    public interface SimpleInstance extends CriterionTriggerInstance {
        Optional<ContextAwarePredicate> playerPredicate();
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        public Instance(ContextAwarePredicate cap) {
            super(Optional.ofNullable(cap));
        }

        /*public static ConstructBeaconTrigger.TriggerInstance forLevel(MinMaxBounds.Ints mmbi) {
            return new ConstructBeaconTrigger.TriggerInstance(Optional.ofNullable(ContextAwarePredicate.create()));
        }*/


        public JsonObject serializeToJson() {
            JsonObject jo = super.serializeToJson();
            return jo;
        }
    }
}
