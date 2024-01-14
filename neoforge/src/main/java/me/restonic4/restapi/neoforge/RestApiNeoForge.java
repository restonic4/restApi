import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RestApi.MOD_ID)
public class RestApiNeoForge {

	public RestApiNeoForge(IEventBus modEventBus) {
 		modEventBus.addListener(this::setupClient);

		RestApi.init();
	}

	private void setup(final FMLCommonSetupEvent event) {
	}
}
