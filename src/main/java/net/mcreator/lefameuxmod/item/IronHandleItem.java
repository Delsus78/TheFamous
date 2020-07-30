
package net.mcreator.lefameuxmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.lefameuxmod.itemgroup.LeFameuxModItemGroup;
import net.mcreator.lefameuxmod.LefameuxmodModElements;

@LefameuxmodModElements.ModElement.Tag
public class IronHandleItem extends LefameuxmodModElements.ModElement {
	@ObjectHolder("lefameuxmod:iron_handle")
	public static final Item block = null;
	public IronHandleItem(LefameuxmodModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LeFameuxModItemGroup.tab).maxStackSize(64));
			setRegistryName("iron_handle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
