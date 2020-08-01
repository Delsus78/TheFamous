
package net.mcreator.lefameuxmod.block;

import net.minecraft.block.material.Material;

@LefameuxmodModElements.ModElement.Tag
public class MeteoriaRoseBlock extends LefameuxmodModElements.ModElement {

	@ObjectHolder("lefameuxmod:meteoria_rose")
	public static final Block block = null;

	public MeteoriaRoseBlock(LefameuxmodModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(LeFameuxModItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		FlowersFeature feature = new DefaultFlowersFeature(BlockClusterFeatureConfig::deserialize) {
			@Override
			public BlockState getFlowerToPlace(Random random, BlockPos bp, BlockClusterFeatureConfig fc) {
				return block.getDefaultState();
			}

			@Override
			public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
				DimensionType dimensionType = world.getDimension().getType();
				boolean dimensionCriteria = false;

				if (dimensionType == DimensionType.OVERWORLD)
					dimensionCriteria = true;
				if (dimensionType == MeteoriteDimension.type)
					dimensionCriteria = true;

				if (!dimensionCriteria)
					return false;

				return super.place(world, generator, random, pos, config);
			}
		};

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("plains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("lefameuxmod:meteorite_biome")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("swamp")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					feature.withConfiguration(
							(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()), new SimpleBlockPlacer()))
									.tries(64).build())
							.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(25))));
		}
	}

	public static class BlockCustomFlower extends FlowerBlock {

		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(0.5f, 0f).lightValue(1));
			setRegistryName("meteoria_rose");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 4;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Strange rose huh ?"));
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 2;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.Plains;
		}

	}
}
