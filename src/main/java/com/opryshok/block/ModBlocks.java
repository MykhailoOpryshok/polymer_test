package com.opryshok.block;

import com.opryshok.PolymerTest;
import eu.pb4.polymer.blocks.api.BlockModelType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block POROSHENKO_BLOCK;

    public static void registerBlocks() {
        register(BlockModelType.FULL_BLOCK, "poroshenko_block");
    }

    public static void register(BlockModelType type, String modelId) {
        var NORMAL = Identifier.of(PolymerTest.MOD_ID, modelId);

        POROSHENKO_BLOCK = Registry.register(Registries.BLOCK, NORMAL,
                new PoroshenkoBlock(Block.Settings.copy(Blocks.GOLD_BLOCK), type, modelId));
        Registry.register(Registries.ITEM, Identifier.of(PolymerTest.MOD_ID, modelId), new PoroshenkoBlockItem(POROSHENKO_BLOCK, new Item.Settings(), modelId));
    }
}
