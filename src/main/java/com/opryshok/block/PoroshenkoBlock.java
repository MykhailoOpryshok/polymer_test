package com.opryshok.block;

import com.opryshok.PolymerTest;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;

public class PoroshenkoBlock extends Block implements PolymerTexturedBlock {
    private final BlockState polymerBlockState;
    public PoroshenkoBlock(Settings settings, BlockModelType type, String modelId) {
        super(settings);
        this.polymerBlockState = PolymerBlockResourceUtils.requestBlock(
                type,
                PolymerBlockModel.of(Identifier.of(PolymerTest.MOD_ID, "block/" + modelId)));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return this.polymerBlockState;
    }
}
