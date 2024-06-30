package com.opryshok.item;

import com.opryshok.PolymerTest;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RoshenChocolateBarItem extends Item implements PolymerItem {
    private final PolymerModelData polymerModel;
    public RoshenChocolateBarItem(Settings settings) {
        super(settings);
        polymerModel = PolymerResourcePackUtils.requestModel(Items.FLINT, Identifier.of(PolymerTest.MOD_ID, "item/roshen_chocolate_bar"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.item();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
       tooltip.add(Text.of("with milk chocolate"));
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.polymerModel.value();
    }
}
