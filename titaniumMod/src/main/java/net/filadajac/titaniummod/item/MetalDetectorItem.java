package net.filadajac.titaniummod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;



public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        if(level.isClientSide()) {
            boolean isOre = level.getBlockStates(player.getBoundingBox().inflate(5)).filter(state -> state.is(Blocks.DIAMOND_ORE) ||  state.is(Blocks.DEEPSLATE_DIAMOND_ORE)).toArray().length > 0;
            if (isOre) {
                player.sendSystemMessage(Component.literal("Find diamond ore!"));
            }
            isOre = level.getBlockStates(player.getBoundingBox().inflate(5)).filter(state -> state.is(Blocks.IRON_ORE) ||  state.is(Blocks.DEEPSLATE_IRON_ORE)).toArray().length > 0;
            if (isOre) {
                player.sendSystemMessage(Component.literal("Find iron ore!"));
            }
            isOre = level.getBlockStates(player.getBoundingBox().inflate(5)).filter(state -> state.is(Blocks.GOLD_ORE) ||  state.is(Blocks.DEEPSLATE_GOLD_ORE)).toArray().length > 0;
            if (isOre) {
                player.sendSystemMessage(Component.literal("Find gold ore!"));
            }
            player.getCooldowns().addCooldown(this, 20);
        }
        return super.use(level, player, interactionHand);
    }

}
