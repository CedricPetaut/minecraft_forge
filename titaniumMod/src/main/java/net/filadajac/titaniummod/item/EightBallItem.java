package net.filadajac.titaniummod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;


public class EightBallItem extends Item {

    private static final int entityCount = ForgeRegistries.ENTITY_TYPES.getValues().size() -1;

    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        int randomNumber = getRandomNumber();

        if(!level.isClientSide) {
            //EntityType.COW.spawn((ServerLevel) level, null, player, player.blockPosition(), MobSpawnType.COMMAND, true, false);
            EntityType entityType = ((EntityType)ForgeRegistries.ENTITY_TYPES.getValues().toArray()[randomNumber]);
            while(entityType.getCategory() != MobCategory.CREATURE && entityType.getCategory() != MobCategory.MONSTER) {
                randomNumber = getRandomNumber();
                entityType = ((EntityType)ForgeRegistries.ENTITY_TYPES.getValues().toArray()[randomNumber]);
            }

            entityType.spawn((ServerLevel) level, null, player, player.blockPosition(), MobSpawnType.COMMAND, true, false);

        } else {
            player.sendSystemMessage(Component.literal("Your number is " + randomNumber));
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, interactionHand);
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(entityCount);
    }

}
