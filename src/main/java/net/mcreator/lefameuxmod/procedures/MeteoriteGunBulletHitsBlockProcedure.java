package net.mcreator.lefameuxmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.lefameuxmod.LefameuxmodModElements;

@LefameuxmodModElements.ModElement.Tag
public class MeteoriteGunBulletHitsBlockProcedure extends LefameuxmodModElements.ModElement {
	public MeteoriteGunBulletHitsBlockProcedure(LefameuxmodModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MeteoriteGunBulletHitsBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"playsound lefameuxmod:laser_end master @a ~ ~ ~ 1 0");
			}
		}
	}
}
