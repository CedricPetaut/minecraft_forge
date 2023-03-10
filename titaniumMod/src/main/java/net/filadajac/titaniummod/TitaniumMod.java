package net.filadajac.titaniummod;

import net.filadajac.titaniummod.block.ModBlocks;
import net.filadajac.titaniummod.datagen.ModWorldGenProvider;
import net.filadajac.titaniummod.item.ModCreativeModeTab;
import net.filadajac.titaniummod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TitaniumMod.MODID)
public class TitaniumMod {
    public static final String MODID = "titaniummod";
    //private static final Logger LOGGER = LogUtils.getLogger();


    public TitaniumMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

/*
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void buildContents(CreativeModeTabEvent.Register event) {
            event.registerCreativeModeTab(new ResourceLocation(MODID, "example"), builder ->
                    // Set name of tab to display
                    builder.title(Component.translatable("item_group." + MODID + ".example"))
                            // Set icon of creative tab
                            .icon(() -> new ItemStack(ModItems.TITANIUM.get()))
                            // Add default items to tab
                            .displayItems((enabledFlags, populator, hasPermissions) -> {

                                populator.accept(ModItems.RAW_TITANIUM.get());
                                populator.accept(ModItems.TITANIUM.get());
                                populator.accept(ModBlocks.TITANIUM_ORE.get());
                                populator.accept(ModBlocks.TITANIUM_BLOCK.get());
                                populator.accept(ModItems.TITANIUM_LEGGINGS.get());
                                populator.accept(ModItems.TITANIUM_BOOTS.get());
                                populator.accept(ModItems.TITANIUM_CHESTPLATE.get());
                                populator.accept(ModItems.TITANIUM_HELMET.get());
                                populator.accept(ModItems.TITANIUM_PICKAXE.get());
                                populator.accept(ModItems.TITANIUM_AXE.get());
                                populator.accept(ModItems.TITANIUM_HOE.get());
                                populator.accept(ModItems.TITANIUM_SHOVEL.get());
                                populator.accept(ModItems.TITANIUM_SWORD.get());
                                populator.accept(ModItems.TITANIUM_TRIDENT.get());
                                populator.accept(ModItems.EIGHTBALL_ITEM.get());
                                populator.accept(ModItems.METALDETECTOR_ITEM.get());
                                populator.accept(ModItems.MAGNET_ITEM.get());
                            })
            );
        }
    }
*/

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTab.TITANIUM_TAB) {
            event.accept(ModItems.RAW_TITANIUM.get());
            event.accept(ModItems.TITANIUM.get());
            event.accept(ModBlocks.TITANIUM_ORE.get());
            event.accept(ModBlocks.TITANIUM_BLOCK.get());
            event.accept(ModItems.TITANIUM_LEGGINGS.get());
            event.accept(ModItems.TITANIUM_BOOTS.get());
            event.accept(ModItems.TITANIUM_CHESTPLATE.get());
            event.accept(ModItems.TITANIUM_HELMET.get());
            event.accept(ModItems.TITANIUM_PICKAXE.get());
            event.accept(ModItems.TITANIUM_AXE.get());
            event.accept(ModItems.TITANIUM_SHOVEL.get());
            event.accept(ModItems.EIGHTBALL_ITEM.get());
            event.accept(ModItems.METALDETECTOR_ITEM.get());

        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
