package net.mcreator.lefameuxmod.procedures;

<<<<<<< HEAD
import net.minecraft.entity.Entity;
=======
import net.minecraft.world.World;
>>>>>>> branch 'master' of https://github.com/Delsus78/TheFamous.git

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
<<<<<<< HEAD
		Entity entity = (Entity) dependencies.get("entity");
=======
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FamousCraftingTableUpdateTick!");
			return;
		}
>>>>>>> branch 'master' of https://github.com/Delsus78/TheFamous.git
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
<<<<<<< HEAD
=======
		World world = (World) dependencies.get("world");
>>>>>>> branch 'master' of https://github.com/Delsus78/TheFamous.git
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
