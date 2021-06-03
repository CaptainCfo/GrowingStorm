package com.mcjty.mytutorial.setup;

import com.mcjty.mytutorial.GrowingStorm;
import com.mcjty.mytutorial.client.AfterLivingRenderer;
import com.mcjty.mytutorial.client.InWorldRenderer;
import com.mcjty.mytutorial.entities.WeirdMobRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = GrowingStorm.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);

    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {

    }

    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            return;
        }

       // event.addSprite(MAGICBLOCK_TEXTURE);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(GrowingStorm.MODID)) {
            event.setMaxWidth(200);
        }
    }
}
