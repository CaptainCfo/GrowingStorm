package com.mcjty.mytutorial.setup;

import com.mcjty.mytutorial.GrowingStorm;
import com.mcjty.mytutorial.commands.ModCommands;
import com.mcjty.mytutorial.data.CapabilityEntityCharge;
import com.mcjty.mytutorial.data.ChargeEventHandler;
import com.mcjty.mytutorial.dimension.TutorialBiomeProvider;
import com.mcjty.mytutorial.dimension.TutorialChunkGenerator;
import com.mcjty.mytutorial.entities.WeirdMobEntity;
import com.mcjty.mytutorial.network.Networking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = GrowingStorm.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("mytutorial") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.DEADSWORD.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        Networking.registerMessages();
        CapabilityEntityCharge.register();

        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, ChargeEventHandler::onAttachCapabilitiesEvent);
        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onAttackEvent);
        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onDeathEvent);


    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }
}
