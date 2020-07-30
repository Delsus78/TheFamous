
package net.mcreator.lefameuxmod.item;

@LefameuxmodModElements.ModElement.Tag
public class RedstoneCircuitCardItem extends LefameuxmodModElements.ModElement {

	@ObjectHolder("lefameuxmod:redstone_circuit_card")
	public static final Item block = null;

	public RedstoneCircuitCardItem(LefameuxmodModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LeFameuxModItemGroup.tab).maxStackSize(64));
			setRegistryName("redstone_circuit_card");
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
