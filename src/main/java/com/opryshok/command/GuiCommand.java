package com.opryshok.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

public class GuiCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("guitest").executes(GuiCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) {
        ServerPlayerEntity player = serverCommandSourceCommandContext.getSource().getPlayer();
        SimpleGui gui = new SimpleGui(ScreenHandlerType.GENERIC_3X3, player, false){
            int timer = 0;
            @Override
            public void onTick() {
                super.onTick();
                if(Objects.requireNonNull(getSlotRedirect(4)).hasStack()){
                    timer++;
                }
                if(timer == 60){
                    Objects.requireNonNull(getSlotRedirect(4)).setStack(ItemStack.EMPTY);
                    timer = 0;
                }
            }
        };
        SimpleInventory inventory = new SimpleInventory(64);
        gui.setSlotRedirect(4, createSlot(inventory, 1, true));
        gui.setTitle(Text.literal("Title"));
        gui.open();
        return 0;
    }
    private static Slot createSlot(SimpleInventory inventory, int i, boolean canPutItems) {
        return new Slot(inventory, i, i, 0) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return super.canInsert(stack) && canPutItems;
            }
        };
    }
}
