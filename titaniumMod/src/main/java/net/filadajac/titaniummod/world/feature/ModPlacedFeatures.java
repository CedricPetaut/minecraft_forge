package net.filadajac.titaniummod.world.feature;

import net.filadajac.titaniummod.TitaniumMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {


    public static final ResourceKey<PlacedFeature> TITANIUM_PLACED_KEY = createKey("titanium_placed");
    //public static final ResourceKey<PlacedFeature> END_ZIRCON_PLACED_KEY = createKey("end_zircon_placed");
    //public static final ResourceKey<PlacedFeature> NETHER_ZIRCON_PLACED_KEY = createKey("nether_zircon_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
       // PlacementUtils.register(p_256238_, ORE_COAL_UPPER, holder12, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top())));
        register(context, TITANIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TITANIUM_ORE_KEY),
                commonOrePlacement(90, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.top())));
        //register(context, NETHER_ZIRCON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ZIRCON_ORE_KEY),
        //        commonOrePlacement(12, // VeinsPerChunk
       //                 HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        //register(context, END_ZIRCON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ZIRCON_ORE_KEY),
        //        commonOrePlacement(12, // VeinsPerChunk
        //                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    }


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TitaniumMod.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}
