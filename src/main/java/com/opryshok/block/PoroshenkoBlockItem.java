package com.opryshok.block;

import com.opryshok.PolymerTest;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class PoroshenkoBlockItem extends BlockItem implements PolymerItem {
    public final PolymerModelData polymerModel;
    public PoroshenkoBlockItem(Block block, Settings settings, String modelID) {
        super(block, settings);
        this.polymerModel = PolymerResourcePackUtils.requestModel(Items.GOLD_BLOCK, Identifier.of(PolymerTest.MOD_ID, "block/" + modelID));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.value();
    }
}
