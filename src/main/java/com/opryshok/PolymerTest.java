package com.opryshok;

import com.opryshok.block.ModBlocks;
import com.opryshok.command.GuiCommand;
import com.opryshok.item.ModItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolymerTest implements ModInitializer {

	public static final String MOD_ID = "polymer-test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		CommandRegistrationCallback.EVENT.register(GuiCommand::register);
		if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
			LOGGER.info("Successfully added mod assets for " + MOD_ID);
		} else {
			LOGGER.error("Failed to add mod assets for " + MOD_ID);
		}

		PolymerResourcePackUtils.markAsRequired();
	}
}