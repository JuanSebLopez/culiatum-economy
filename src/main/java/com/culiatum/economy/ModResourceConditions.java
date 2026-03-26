package com.culiatum.economy;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;

public final class ModResourceConditions {
	private static final ResourceConditionType<RecipeEnabledCondition> RECIPE_ENABLED_TYPE = ResourceConditionType.create(
		Identifier.fromNamespaceAndPath(CuliatumEconomyMod.MOD_ID, "recipe_enabled"),
		RecipeEnabledCondition.CODEC
	);

	private ModResourceConditions() {
	}

	public static void register() {
		ResourceConditions.register(RECIPE_ENABLED_TYPE);
	}

	public record RecipeEnabledCondition(String recipeKey) implements ResourceCondition {
		private static final MapCodec<RecipeEnabledCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			com.mojang.serialization.Codec.STRING.fieldOf("recipe_key").forGetter(RecipeEnabledCondition::recipeKey)
		).apply(instance, RecipeEnabledCondition::new));

		@Override
		public ResourceConditionType<?> getType() {
			return RECIPE_ENABLED_TYPE;
		}

		public boolean test(RegistryOps.RegistryInfoLookup registryInfoLookup) {
			return ModConfig.isRecipeEnabled(recipeKey);
		}
	}
}
