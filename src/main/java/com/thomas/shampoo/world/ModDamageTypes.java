package com.thomas.shampoo.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

import static com.thomas.shampoo.ShampooMod.MODID;

public interface ModDamageTypes {
    ResourceKey<DamageType> LASER = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MODID, "laser"));
}
