package com.opryshok.item;

import com.opryshok.PolymerTest;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ROSHEN_CHOCOLATE_BAR = registerItem("roshen_chocolate_bar", new RoshenChocolateBarItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PolymerTest.MOD_ID, name), item);
    }
    public static void registerItems(){
        PolymerTest.LOGGER.info("Registering items for " + PolymerTest.MOD_ID);
        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();

        builder.icon(() -> new ItemStack(ModItems.ROSHEN_CHOCOLATE_BAR, 1));
        builder.displayName(Text.of("Polymer Items"));
        builder.entries((displayContext, entries) -> entries.add(ModItems.ROSHEN_CHOCOLATE_BAR));
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(PolymerTest.MOD_ID), polymerGroup);
    }
}
