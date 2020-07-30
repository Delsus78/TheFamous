
package net.mcreator.lefameuxmod.item;

@LefameuxmodModElements.ModElement.Tag
public class BaseCircuitPlateItem extends LefameuxmodModElements.ModElement {

	@ObjectHolder("lefameuxmod:base_circuit_plate")
	public static final Item block = null;

	public BaseCircuitPlateItem(LefameuxmodModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LeFameuxModItemGroup.tab).maxStackSize(64));
			setRegistryName("base_circuit_plate");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Base Card for Meteorite Tech"));
		}

	}

}
