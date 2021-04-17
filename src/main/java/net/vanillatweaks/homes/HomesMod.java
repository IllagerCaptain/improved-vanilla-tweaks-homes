package net.vanillatweaks.homes;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.vanillatweaks.homes.server.SethomeCommand;
import net.vanillatweaks.homes.server.NamehomeCommand;
import net.vanillatweaks.homes.server.HomesCommand;
import net.vanillatweaks.homes.server.HomeCommand;
import net.vanillatweaks.homes.server.DelhomeCommand;
import net.vanillatweaks.homes.server.ConfigCommand;
import net.vanillatweaks.homes.procedures.SethomeCommandExecutedProcedure;
import net.vanillatweaks.homes.procedures.NamehomeCommandExecutedProcedure;
import net.vanillatweaks.homes.procedures.HomesCommandExecutedProcedure;
import net.vanillatweaks.homes.procedures.HomeCommandExecutedProcedure;
import net.vanillatweaks.homes.procedures.DelhomeCommandExecutedProcedure;
import net.vanillatweaks.homes.procedures.ConfigCommandExecutedProcedure;

import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.api.ModInitializer;

public class HomesMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing HomesMod");
		new SethomeCommandExecutedProcedure();
		new HomeCommandExecutedProcedure();
		new HomesCommandExecutedProcedure();
		new DelhomeCommandExecutedProcedure();
		new NamehomeCommandExecutedProcedure();
		new ConfigCommandExecutedProcedure();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			SethomeCommand.register(dispatcher);
			HomeCommand.register(dispatcher);
			HomesCommand.register(dispatcher);
			DelhomeCommand.register(dispatcher);
			NamehomeCommand.register(dispatcher);
			ConfigCommand.register(dispatcher);
		});
	}

	public static final Identifier id(String s) {
		return new Identifier("homes", s);
	}
}
