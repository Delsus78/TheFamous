package net.mcreator.lefameuxmod.procedures;

@LefameuxmodModElements.ModElement.Tag
public class FamousCraftingTableUpdateTickProcedure extends LefameuxmodModElements.ModElement {

	public FamousCraftingTableUpdateTickProcedure(LefameuxmodModElements instance) {
		super(instance, 28);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FamousCraftingTableUpdateTick!");
			return;
		}
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

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");

		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("x", (int) (x));
			$_dependencies.put("y", (int) (y));
			$_dependencies.put("z", (int) (z));

			FamousCraftingCraftProcedure.executeProcedure($_dependencies);
		}

	}

}
