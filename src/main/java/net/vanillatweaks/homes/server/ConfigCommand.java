
package net.vanillatweaks.homes.server;

import net.vanillatweaks.homes.procedures.ConfigCommandExecutedProcedure;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.entity.Entity;

import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.CommandDispatcher;

public class ConfigCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("config").requires(s -> s.hasPermissionLevel(2))
				.then(CommandManager.argument("arguments", StringArgumentType.greedyString()).executes(ConfigCommand::execute))
				.executes(ConfigCommand::execute));
	}

	private static int execute(CommandContext<ServerCommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();
		double x = ctx.getSource().getPosition().getX();
		double y = ctx.getSource().getPosition().getY();
		double z = ctx.getSource().getPosition().getZ();
		Entity entity = ctx.getSource().getEntity();
		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});
		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("cmdparams", cmdparams);
			ConfigCommandExecutedProcedure.executeProcedure($_dependencies);
		}
		return 0;
	}
}
