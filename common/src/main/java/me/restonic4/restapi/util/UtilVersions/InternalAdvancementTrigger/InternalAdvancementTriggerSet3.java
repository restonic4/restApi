package me.restonic4.restapi.util.UtilVersions.InternalAdvancementTrigger;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class InternalAdvancementTriggerSet3 extends SimpleCriterionTrigger<InternalAdvancementTriggerSet3.Instance> {
    public final ResourceLocation resourceLocation;

    public InternalAdvancementTriggerSet3(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public InternalAdvancementTriggerSet3.Instance createInstance(JsonObject jo, ContextAwarePredicate cap, DeserializationContext dc) {
        return new InternalAdvancementTriggerSet3.Instance(cap, resourceLocation);
    }

    public void trigger(ServerPlayer serverPlayer) {
        this.trigger(serverPlayer, (thingy) -> {
            return true;
        });
    }

    @Override
    public ResourceLocation getId() {
        return resourceLocation;
    }


    public static class Instance extends AbstractCriterionTriggerInstance {

        public Instance(ContextAwarePredicate cap, ResourceLocation res) {
            super(res, cap);
        }

        public static ConstructBeaconTrigger.TriggerInstance forLevel(MinMaxBounds.Ints mmbi) {
            return new ConstructBeaconTrigger.TriggerInstance(ContextAwarePredicate.ANY, mmbi);
        }



        public JsonObject serializeToJson(SerializationContext sc) {
            JsonObject jo = super.serializeToJson(sc);
            return jo;
        }
    }
}
