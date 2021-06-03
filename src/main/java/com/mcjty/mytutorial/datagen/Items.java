package com.mcjty.mytutorial.datagen;

import com.mcjty.mytutorial.GrowingStorm;
import com.mcjty.mytutorial.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GrowingStorm.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(Registration.DEADSWORD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
                "layer0", new ResourceLocation(GrowingStorm.MODID, "item/deadsword"));
    }
}
