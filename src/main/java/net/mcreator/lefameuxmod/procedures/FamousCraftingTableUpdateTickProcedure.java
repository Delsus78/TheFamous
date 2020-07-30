package net.mcreator.lefameuxmod.procedures;

import net.minecraft.world.World;

import net.mcreator.lefameuxmod.LefameuxmodModElements;

@LefameuxmodModElements.ModElement.Tag
public class FamousCraftingTableUpdateTickProcedure extends LefameuxmodModElements.ModElement {
	public FamousCraftingTableUpdateTickProcedure(LefameuxmodModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FamousCraftingTableUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FamousCraftingTableUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FamousCraftingTableUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FamousCraftingTableUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("world", world);
			$_dependencies.put("x", (int) (x));
			$_dependencies.put("y", (int) (y));
			$_dependencies.put("z", (int) (z));
			FamousCraftingCraftProcedure.executeProcedure($_dependencies);
		}
	}
}
