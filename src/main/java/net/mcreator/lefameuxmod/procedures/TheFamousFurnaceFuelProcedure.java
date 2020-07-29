package net.mcreator.lefameuxmod.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lefameuxmod.block.GasoilBlock;
import net.mcreator.lefameuxmod.LefameuxmodModElements;

import java.util.function.Supplier;
import java.util.Map;

@LefameuxmodModElements.ModElement.Tag
public class TheFamousFurnaceFuelProcedure extends LefameuxmodModElements.ModElement {
	public TheFamousFurnaceFuelProcedure(LefameuxmodModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheFamousFurnaceFuel!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Fuel = 0;
		if (((new ItemStack(GasoilBlock.block, (int) (1)).getItem() == (new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (1))).getItem()) && ((Fuel) < 3))) {
			Fuel = (double) ((Fuel) + 2);
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
