package com.mcjty.mytutorial.datagen;

import com.mcjty.mytutorial.GrowingStorm;
import com.mcjty.mytutorial.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, GrowingStorm.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    private void registerFirstBlock() {

    }


    private void registerComplexMultipart() {

    }

    private void floatingCube(BlockModelBuilder builder, float fx, float fy, float fz, float tx, float ty, float tz) {
        builder.element().from(fx, fy, fz).to(tx, ty, tz).allFaces((direction, faceBuilder) -> faceBuilder.texture("#window")).end();
    }

    private void createDimensionalCellModel(Block block, BlockModelBuilder dimCellFrame) {

    }

    private void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {


    }
}
