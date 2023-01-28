package net.filadajac.titaniummod.world.feature;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.filadajac.titaniummod.TitaniumMod;
import net.filadajac.titaniummod.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {


     public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("overworld_titanium_ore");
     //public static final ResourceKey<ConfiguredFeature<?, ?>> END_ZIRCON_ORE_KEY = registerKey("end_zircon_ore");
     //public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE_KEY = registerKey("nether_zircon_ore");

     //public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_GEODE_KEY = registerKey("zircon_geode");

     public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TITANIUM_ORES = Suppliers.memoize(() -> List.of(
             OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TITANIUM_ORE.get().defaultBlockState())
             //OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ZIRCON_ORE.get().defaultBlockState())
             ));
     //public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
     //        OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_ZIRCON_ORE.get().defaultBlockState())));
     //public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
      //       OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHERRACK_ZIRCON_ORE.get().defaultBlockState())));

     public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
          HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);


          register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORES.get(),12));
          //register(context, END_ZIRCON_ORE_KEY, Feature.ORE, new OreConfiguration(END_ZIRCON_ORES.get(),12));
          //register(context, NETHER_ZIRCON_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(),12));

     }

     public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
          return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TitaniumMod.MODID, name));
     }

     private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                           ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
          context.register(key, new ConfiguredFeature<>(feature, configuration));
     }
}
