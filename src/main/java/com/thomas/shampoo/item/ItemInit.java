package com.thomas.shampoo.item;

import com.thomas.shampoo.ShampooMod;
import com.thomas.shampoo.block.BlockInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShampooMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ShampooMod.MODID);

    // Block item for the Thomas ore
    public static final RegistryObject<Item> THOMAS_ORE_ITEM = ITEMS.register("thomas_ore",
            () -> new BlockItem(BlockInit.THOMAS_ORE.get(), new Item.Properties()));

    // Smelted Thomas
    public static final RegistryObject<Item> SMELTED_THOMAS = ITEMS.register("smelted_thomas",
            () -> new Item(new Item.Properties()));

    // Thomas & Friends 3 in 1 Hair and Body Wash
    public static final RegistryObject<Item> THOMAS_AND_FRIENDS_3_IN_1_SHAMPOO_HAIR_AND_BODY_WASH = ITEMS.register("thomas_and_friends_3_in_1_shampoo_hair_and_body_wash",
            () -> new DrinkableItem(new Item.Properties()
                    .stacksTo(16)
                    .rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder()
                            .alwaysEat() // Can be eaten even when not hungry
                            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 1), 0.7f) // Levitation effect
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1.0f) // Speed effect
                            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0), 1.0f) // Night Vision effect
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f) // Fire Resistance effect
                            .build())
            ));

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Put my stuff in their proper creative tabs.
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(THOMAS_ORE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(SMELTED_THOMAS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(THOMAS_AND_FRIENDS_3_IN_1_SHAMPOO_HAIR_AND_BODY_WASH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
