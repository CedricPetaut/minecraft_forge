package net.filadajac.titaniummod.item;


import net.filadajac.titaniummod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

import static net.filadajac.titaniummod.TitaniumMod.MODID;


public class ModCreativeModeTab {


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
                        })
        );
    }

}
