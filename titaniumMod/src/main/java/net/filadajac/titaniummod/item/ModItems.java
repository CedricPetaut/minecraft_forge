package net.filadajac.titaniummod.item;

import net.filadajac.titaniummod.TitaniumMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TitaniumMod.MODID);

    public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.LEGS, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.FEET, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.CHEST, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.HEAD, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () ->  new PickaxeItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () ->  new SwordItem(Tiers.NETHERITE, 4, -2.8F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_TRIDENT = ITEMS.register("titanium_trident",
            () ->  new TridentItem((new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> EIGHTBALL_ITEM = ITEMS.register("eightball_item",
            () ->  new EightBallItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGNET_ITEM = ITEMS.register("magnet_item",
            () ->  new MagnetItem(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () ->  new AxeItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> METALDETECTOR_ITEM = ITEMS.register("metaldetector_item",
            () ->  new MetalDetectorItem(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () ->  new ShovelItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () ->  new ShovelItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties()).fireResistant()));

   public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
