package com.thomas.shampoo.event;

import com.thomas.shampoo.entity.EntityInit;
import com.thomas.shampoo.renderer.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.thomas.shampoo.ShampooMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityInit.BIDEN.get(), BidenRenderer::new);
            event.registerEntityRenderer(EntityInit.OBAMA.get(), ObamaRenderer::new);
            event.registerEntityRenderer(EntityInit.STEVEN_ARMSTRONG.get(), ArmstrongRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ARMSTRONG_LAYER, ArmstrongModel::createBodyLayer);
    }
}
