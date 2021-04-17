package net.vanillatweaks.homes.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class NamehomeCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NamehomeCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure NamehomeCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())) >= 1)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isClient()) {
					_ent.world.getServer().getCommandManager().execute(_ent.getCommandSource().withSilent().withLevel(4),
							(("trigger namehome set ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()))));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals(""))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isClient()) {
					_ent.world.getServer().getCommandManager().execute(_ent.getCommandSource().withSilent().withLevel(4), "trigger namehome");
				}
			}
		}
	}
}
