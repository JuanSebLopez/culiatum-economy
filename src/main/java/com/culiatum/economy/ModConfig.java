package com.culiatum.economy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class ModConfig {
	private static final Path CONFIG_PATH = Path.of("config", "culiatum-economy.properties");

	private static boolean craftableCopper = true;
	private static boolean craftableSilver = true;
	private static boolean craftableGold = true;
	private static boolean craftableCuliatum = false;

	private ModConfig() {
	}

	public static void load() {
		Properties properties = new Properties();

		try {
			Files.createDirectories(CONFIG_PATH.getParent());

			if (Files.exists(CONFIG_PATH)) {
				try (InputStream inputStream = Files.newInputStream(CONFIG_PATH)) {
					properties.load(inputStream);
				}
			}

			craftableCopper = readBoolean(properties, "craftable_copper", true);
			craftableSilver = readBoolean(properties, "craftable_silver", true);
			craftableGold = readBoolean(properties, "craftable_gold", true);
			craftableCuliatum = readBoolean(properties, "craftable_culiatum", false);

			properties.setProperty("craftable_copper", Boolean.toString(craftableCopper));
			properties.setProperty("craftable_silver", Boolean.toString(craftableSilver));
			properties.setProperty("craftable_gold", Boolean.toString(craftableGold));
			properties.setProperty("craftable_culiatum", Boolean.toString(craftableCuliatum));

			try (OutputStream outputStream = Files.newOutputStream(CONFIG_PATH)) {
				properties.store(outputStream, "Culiatum Economy config");
			}
		} catch (IOException exception) {
			CuliatumEconomyMod.LOGGER.error("No se pudo cargar la configuracion de Culiatum Economy.", exception);
		}
	}

	private static boolean readBoolean(Properties properties, String key, boolean defaultValue) {
		String value = properties.getProperty(key);

		if (value == null) {
			return defaultValue;
		}

		return Boolean.parseBoolean(value);
	}

	public static boolean isRecipeEnabled(String recipeKey) {
		return switch (recipeKey) {
			case "copper" -> craftableCopper;
			case "silver" -> craftableSilver;
			case "gold" -> craftableGold;
			case "culiatum" -> craftableCuliatum;
			default -> false;
		};
	}
}
