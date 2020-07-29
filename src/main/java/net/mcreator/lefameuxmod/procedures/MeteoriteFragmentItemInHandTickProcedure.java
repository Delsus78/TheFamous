package net.mcreator.lefameuxmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.lefameuxmod.LefameuxmodModElements;

@LefameuxmodModElements.ModElement.Tag
public class MeteoriteFragmentItemInHandTickProcedure extends LefameuxmodModElements.ModElement {
	public MeteoriteFragmentItemInHandTickProcedure(LefameuxmodModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MeteoriteFragmentItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 0.5);
	}
}
