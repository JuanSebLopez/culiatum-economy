package com.culiatum.economy;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public final class ModItems {
	public static final Item COPPER_COIN = register("copper_coin", Rarity.COMMON);
	public static final Item SILVER_COIN = register("silver_coin", Rarity.UNCOMMON);
	public static final Item GOLD_COIN = register("gold_coin", Rarity.UNCOMMON);
	public static final Item CULIATUM_COIN = register("culiatum_coin");

	private ModItems() {
	}

	private static Item register(String path) {
		return register(path, Rarity.UNCOMMON);
	}

	private static Item register(String path, Rarity rarity) {
		Identifier id = Identifier.fromNamespaceAndPath(CuliatumEconomyMod.MOD_ID, path);
		ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, id);
		Item item = new Item(new Item.Properties()
			.stacksTo(64)
			.rarity(rarity)
			.setId(resourceKey));
		return Registry.register(BuiltInRegistries.ITEM, id, item);
	}

	public static void register() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
			entries.accept(COPPER_COIN);
			entries.accept(SILVER_COIN);
			entries.accept(GOLD_COIN);
			entries.accept(CULIATUM_COIN);
		});
	}
}
