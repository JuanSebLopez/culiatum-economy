package com.culiatum.economy;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuliatumEconomyMod implements ModInitializer {
	public static final String MOD_ID = "culiatum_economy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfig.load();
		ModResourceConditions.register();
		ModItems.register();
		LOGGER.info("Culiatum Economy listo. Monedas y configuracion registradas.");
	}
}
