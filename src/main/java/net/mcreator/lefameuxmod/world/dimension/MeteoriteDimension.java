
package net.mcreator.lefameuxmod.world.dimension;

import net.minecraft.block.material.Material;

@LefameuxmodModElements.ModElement.Tag
public class MeteoriteDimension extends LefameuxmodModElements.ModElement {

	@ObjectHolder("lefameuxmod:meteorite")
	public static final ModDimension dimension = null;

	@ObjectHolder("lefameuxmod:meteorite_portal")
	public static final CustomPortalBlock portal = null;

	public static DimensionType type = null;

	private static Biome[] dimensionBiomes;

	public MeteoriteDimension(LefameuxmodModElements instance) {
		super(instance, 30);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("meteorite"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("lefameuxmod:meteorite")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("lefameuxmod:meteorite"), dimension, null, false);
		}

		type = DimensionType.byName(new ResourceLocation("lefameuxmod:meteorite"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_void")),};
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomPortalBlock());
		elements.items.add(() -> new MeteoriteItem().setRegistryName("meteorite"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(portal, RenderType.getTranslucent());
	}

	public static class CustomPortalBlock extends NetherPortalBlock {

		public CustomPortalBlock() {
			super(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS)
					.lightValue(15).noDrops());
			setRegistryName("meteorite_portal");
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		}

		public void portalSpawn(World world, BlockPos pos) {
			CustomPortalBlock.Size portalsize = this.isValid(world, pos);
			if (portalsize != null)
				portalsize.placePortalBlocks();
		}

		/* failed to load code for net.minecraft.block.NetherPortalBlock */

		/* failed to load code for net.minecraft.block.NetherPortalBlock */

		@Override /* failed to load code for net.minecraft.block.NetherPortalBlock */

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			for (int i = 0; i < 4; i++) {
				double px = pos.getX() + random.nextFloat();
				double py = pos.getY() + random.nextFloat();
				double pz = pos.getZ() + random.nextFloat();
				double vx = (random.nextFloat() - 0.5) / 2f;
				double vy = (random.nextFloat() - 0.5) / 2f;
				double vz = (random.nextFloat() - 0.5) / 2f;
				int j = random.nextInt(4) - 1;
				if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
					px = pos.getX() + 0.5 + 0.25 * j;
					vx = random.nextFloat() * 2 * j;
				} else {
					pz = pos.getZ() + 0.5 + 0.25 * j;
					vz = random.nextFloat() * 2 * j;
				}
				world.addParticle(ParticleTypes.SMOKE, px, py, pz, vx, vy, vz);
			}

		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			if (!world.isRemote && !entity.isPassenger() && !entity.isBeingRidden() && entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity player = (ServerPlayerEntity) entity;
				if (player.timeUntilPortal > 0) {
					player.timeUntilPortal = 10;
				} else if (player.dimension != type) {
					player.timeUntilPortal = 10;
					teleportToDimension(player, type);
				} else {
					player.timeUntilPortal = 10;
					teleportToDimension(player, DimensionType.OVERWORLD);
				}

			}
		}

		private void teleportToDimension(ServerPlayerEntity player, DimensionType destinationType) {
			ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, player, true, "field_184851_cj");

			ServerWorld nextWorld = player.getServer().getWorld(destinationType);

			TeleporterDimensionMod teleporter = getTeleporterForDimension(player, player.getPosition(), nextWorld);

			player.connection.sendPacket(new SChangeGameStatePacket(4, 0));

			if (!teleporter.placeInPortal(player, player.rotationYaw)) {
				teleporter.makePortal(player);
				teleporter.placeInPortal(player, player.rotationYaw);
			}

			player.teleport(nextWorld, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), player.rotationYaw,
					player.rotationPitch);

			player.connection.sendPacket(new SPlayerAbilitiesPacket(player.abilities));
			for (EffectInstance effectinstance : player.getActivePotionEffects()) {
				player.connection.sendPacket(new SPlayEntityEffectPacket(player.getEntityId(), effectinstance));
			}

			player.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}

		private TeleporterDimensionMod getTeleporterForDimension(Entity entity, BlockPos pos, ServerWorld nextWorld) {
			BlockPattern.PatternHelper bph = MeteoriteDimension.CustomPortalBlock.createPatternHelper(entity.world, new BlockPos(pos));
			double d0 = bph.getForwards().getAxis() == Direction.Axis.X
					? (double) bph.getFrontTopLeft().getZ()
					: (double) bph.getFrontTopLeft().getX();
			double d1 = bph.getForwards().getAxis() == Direction.Axis.X ? entity.getPosZ() : entity.getPosX();
			d1 = Math.abs(MathHelper.pct(d1 - (double) (bph.getForwards().rotateY().getAxisDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0),
					d0, d0 - (double) bph.getWidth()));
			double d2 = MathHelper.pct(entity.getPosY() - 1, (double) bph.getFrontTopLeft().getY(),
					(double) (bph.getFrontTopLeft().getY() - bph.getHeight()));
			return new TeleporterDimensionMod(nextWorld, new Vec3d(d1, d2, 0), bph.getForwards());
		}

	public static class Size /* failed to load code for net.minecraft.block.NetherPortalBlock */

}
		private static PointOfInterestType poi = null;

		@SubscribeEvent
		public void registerPointOfInterest(RegistryEvent.Register<PointOfInterestType> event) {
			try {
				Method method = ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "register", String.class, Set.class, int.class,
						int.class);
				method.setAccessible(true);
				poi = (PointOfInterestType) method.invoke(null, "meteorite_portal",
						Sets.newHashSet(ImmutableSet.copyOf(portal.getStateContainer().getValidStates())), 0, 1);
				event.getRegistry().register(poi);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

public static class TeleporterDimensionMod extends Teleporter {

	private Vec3d lastPortalVec;
	private Direction teleportDirection;

	protected final ServerWorld world;
	protected final Random random;

	public TeleporterDimensionMod(ServerWorld worldServer, Vec3d lastPortalVec, Direction teleportDirection) {
		super(worldServer);

		this.world = worldServer;
		this.random = new Random(worldServer.getSeed());

		this.lastPortalVec = lastPortalVec;
		this.teleportDirection = teleportDirection;
	}

	@Override /* failed to load code for net.minecraft.world.Teleporter */

	@Override /* failed to load code for net.minecraft.world.Teleporter */

	@Override /* failed to load code for net.minecraft.world.Teleporter */

}

		public static class CustomModDimension extends ModDimension {

			@Override
			public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
				return CustomDimension::new;
			}

		}

	public static class CustomDimension extends Dimension {

		private BiomeProviderCustom biomeProviderCustom = null;

		public CustomDimension(World world, DimensionType type) {
			super(world, type, 0.5f);
			this.nether = false;
		}

		@Override public void calculateInitialWeather() {
		}

    	@Override public void updateWeather(Runnable defaultWeather) {
		}

		@Override public boolean canDoLightning(Chunk chunk) {
			return false;
		}

		@Override public boolean canDoRainSnowIce(Chunk chunk) {
			return false;
		}

		@Override @OnlyIn(Dist.CLIENT) public Vec3d getFogColor(float cangle, float ticks) {
			return new Vec3d(0.2,0.2,0.2);
		}

		@Override public ChunkGenerator<?> createChunkGenerator() {
			if(this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override public boolean isSurfaceWorld() {
			return false;
		}

		@Override public boolean canRespawnHere() {
			return true;
		}

		@OnlyIn(Dist.CLIENT) @Override public boolean doesXZShowFog(int x, int z) {
			return false;
		}

		@Override public SleepResult canSleepAt(PlayerEntity player, BlockPos pos){
        	return SleepResult.ALLOW;
		}

		@Nullable public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
   		   return null;
   		}

   		@Nullable public BlockPos findSpawn(int x, int z, boolean checkValid) {
   		   return null;
   		}

		@Override public boolean doesWaterVaporize() {
      		return false;
   		}

		@Override /* failed to load code for net.minecraft.world.dimension.OverworldDimension */

	}

		public static class ChunkProviderModded extends EndChunkGenerator {

			private static final int SEALEVEL = 63;

			public ChunkProviderModded(IWorld world, BiomeProvider provider) {
				super(world, provider, new EndGenerationSettings() {
					public BlockState getDefaultBlock() {
						return MeteoriteBlockBlock.block.getDefaultState();
					}

					public BlockState getDefaultFluid() {
						return GasoilBlock.block.getDefaultState();
					}
				});
				this.randomSeed.skip(3946);
			}

		}

		public static class BiomeLayerCustom implements IC0Transformer {

			@Override
			public int apply(INoiseRandom context, int value) {
				return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
			}

		}

		public static class BiomeProviderCustom extends BiomeProvider {

			private Layer genBiomes;

			public BiomeProviderCustom(World world) {
				super(new HashSet<Biome>(Arrays.asList(dimensionBiomes)));

				this.genBiomes = getBiomeLayer(world.getSeed());

			}

			public Biome getNoiseBiome(int x, int y, int z) {
				return this.genBiomes.func_215738_a(x, z);
			}

			private Layer getBiomeLayer(long seed) {
				LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);

				IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
				IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);

				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
				biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);

				return new Layer(biomeLayer);
			}

		}

}
