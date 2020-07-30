
package net.mcreator.lefameuxmod.world.biome;

import net.minecraft.block.material.Material;

@LefameuxmodModElements.ModElement.Tag
public class MeteoriteBiomeBiome extends LefameuxmodModElements.ModElement {

	@ObjectHolder("lefameuxmod:meteorite_biome")
	public static final CustomBiome biome = null;

	public MeteoriteBiomeBiome(LefameuxmodModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.END);
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(1.5f).temperature(0.6f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NETHER).waterColor(-16724839).waterFogColor(-16724839)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(MeteoriteBlockBlock.block.getDefaultState(),
							MeteoriteBlockBlock.block.getDefaultState(), MeteoriteBlockBlock.block.getDefaultState())));

			setRegistryName("meteorite_biome");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(FamousEntityEntity.entity, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(SpaceCadetEntity.entity, 15, 1, 5));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -6710785;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -6710785;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -1;
		}

	}

}
