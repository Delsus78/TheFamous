
package net.mcreator.lefameuxmod.entity;

@LefameuxmodModElements.ModElement.Tag
public class UltiSamaEntity extends LefameuxmodModElements.ModElement {

	public static EntityType entity = null;

	public UltiSamaEntity(LefameuxmodModElements instance) {
		super(instance, 28);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("ulti_sama")
						.setRegistryName("ulti_sama");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -6749953, new Item.Properties().group(LeFameuxModItemGroup.tab))
				.setRegistryName("ulti_sama"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("plains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 1, 1, 1));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);

		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelalex(), 0.5f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("lefameuxmod:textures/ulti.png");
				}
			};
		});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);

		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, true, false));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, MobEntity.class, false, true));
			this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(8, new SwimGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.ILLAGER;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);

		}

	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modelalex extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer horns;
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer cape;

		public Modelalex() {
			textureWidth = 128;
			textureHeight = 128;

			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

			horns = new ModelRenderer(this);
			horns.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.addChild(horns);
			horns.setTextureOffset(36, 56).addBox(4.0F, -30.0F, -1.25F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-5.0F, -30.0F, -1.25F, 1.0F, 2.0F, 2.0F, 0.0F, true);
			horns.setTextureOffset(36, 56).addBox(5.0F, -30.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-7.0F, -30.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			horns.setTextureOffset(36, 56).addBox(6.5F, -32.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-7.5F, -32.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			horns.setTextureOffset(36, 56).addBox(6.0F, -33.75F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-7.0F, -33.75F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			horns.setTextureOffset(36, 56).addBox(5.75F, -34.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-6.75F, -34.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			horns.setTextureOffset(36, 56).addBox(5.25F, -36.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			horns.setTextureOffset(36, 56).addBox(-6.25F, -36.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);

			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
			RightArm.setTextureOffset(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);
			RightArm.setTextureOffset(40, 32).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.25F, false);

			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
			LeftArm.setTextureOffset(32, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);
			LeftArm.setTextureOffset(48, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.25F, false);

			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			LeftLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

			cape = new ModelRenderer(this);
			cape.setRotationPoint(0.0F, 10.4244F, 5.7424F);
			setRotationAngle(cape, 0.2618F, 0.0F, 0.0F);
			cape.setTextureOffset(55, 94).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 22.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			cape.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
