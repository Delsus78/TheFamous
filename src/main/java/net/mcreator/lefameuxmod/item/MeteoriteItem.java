
package net.mcreator.lefameuxmod.item;

public class MeteoriteItem extends Item {

	@ObjectHolder("lefameuxmod:meteorite")
	public static final Item block = null;

	public MeteoriteItem() {
		super(new Item.Properties().group(LeFameuxModItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			if (world.isAirBlock(pos))
				MeteoriteDimension.portal.portalSpawn(world, pos);

			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
}
