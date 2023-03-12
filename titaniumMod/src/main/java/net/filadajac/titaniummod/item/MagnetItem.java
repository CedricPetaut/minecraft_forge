package net.filadajac.titaniummod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraftforge.registries.ForgeRegistries;


public class MagnetItem extends Item {

    private static final int entityCount = ForgeRegistries.ENTITY_TYPES.getValues().size() -1;

    public MagnetItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {


        return super.use(level, player, interactionHand);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int p_42873_, boolean p_42874_) {
  /*      if (!level.isClientSide) {
            level.get
            MapItemSavedData mapitemsaveddata = getSavedData(itemStack, level);
            if (mapitemsaveddata != null) {
                if (entity instanceof Player) {
                    Player player = (Player)entity;
                    mapitemsaveddata.tickCarriedBy(player, itemStack);
                }

                if (!mapitemsaveddata.locked && (p_42874_ || entity instanceof Player && ((Player)entity).getOffhandItem() == itemStack)) {
                    this.update(level, entity, mapitemsaveddata);
                }

            }
        } */
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(entityCount);
    }

}
