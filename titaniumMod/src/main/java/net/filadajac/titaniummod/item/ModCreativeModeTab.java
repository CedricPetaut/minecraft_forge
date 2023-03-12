package net.filadajac.titaniummod.item;

import net.filadajac.titaniummod.TitaniumMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

    @Mod.EventBusSubscriber(modid = TitaniumMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModCreativeModeTab {
        public static CreativeModeTab TITANIUM_TAB;

        @SubscribeEvent
        public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
            TITANIUM_TAB = event.registerCreativeModeTab(new ResourceLocation(TitaniumMod.MODID, "titanium_tab"),
                    builder -> builder.icon(() -> new ItemStack(ModItems.TITANIUM.get())).title(Component.literal("Titanium Tab")).build());
        }

}
