
package net.mcreator.lefameuxmod.entity;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.lefameuxmod.itemgroup.LeFameuxModItemGroup;
import net.mcreator.lefameuxmod.item.MeteoriteFragmentItem;
import net.mcreator.lefameuxmod.LefameuxmodModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@LefameuxmodModElements.ModElement.Tag
public class FamousEntityEntity extends LefameuxmodModElements.ModElement {
	public static EntityType entity = null;
	@ObjectHolder("lefameuxmod:entitybulletfamous_entity")
	public static final EntityType arrow = null;
	public FamousEntityEntity(LefameuxmodModElements instance) {
		super(instance, 23);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("famous_entity")
						.setRegistryName("famous_entity");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -13382401, new Item.Properties().group(LeFameuxModItemGroup.tab))
				.setRegistryName("famous_entity"));
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletfamous_entity").setRegistryName("entitybulletfamous_entity"));
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
			return new MobRenderer(renderManager, new ModelFamous_entity(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("lefameuxmod:textures/famous_entity.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(arrow,
				renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 50;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, true));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, MonsterEntity.class, false, true));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(MeteoriteFragmentItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.hit"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.hurt"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, this, this.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - this.getPosX();
			double d3 = target.getPosZ() - this.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			world.addEntity(entityarrow);
		}

		@Override
		public boolean canBeCollidedWith() {
			return false;
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	private static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1));
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelFamous_entity extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer neck;
		private final ModelRenderer body;
		private final ModelRenderer leftarm;
		private final ModelRenderer larm3;
		private final ModelRenderer lefthand;
		private final ModelRenderer rightarm;
		private final ModelRenderer rarm2;
		private final ModelRenderer righthand;
		private final ModelRenderer rightleg;
		private final ModelRenderer rleg1;
		private final ModelRenderer leftleg;
		private final ModelRenderer lleg1;
		public ModelFamous_entity() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(2.5F, 19.0F, -0.25F);
			setRotationAngle(head, 0.0F, -1.5708F, 0.0F);
			head.setTextureOffset(17, 1).addBox(-3.75F, -18.65F, -0.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-5.75F, -18.4F, 0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 10).addBox(-6.0F, -17.9F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(-0.7027F, -16.0292F, 1.125F);
			head.addChild(neck);
			setRotationAngle(neck, 0.0F, 0.0F, -0.48F);
			neck.setTextureOffset(17, 9).addBox(-2.1875F, -2.15F, -1.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			neck.setTextureOffset(17, 9).addBox(-1.4375F, -0.15F, -1.125F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			neck.setTextureOffset(17, 9).addBox(0.8125F, -0.6F, -0.375F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			neck.setTextureOffset(17, 9).addBox(-1.1875F, -1.1F, -0.375F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(1.4583F, 8.0792F, 1.0F);
			setRotationAngle(body, 0.0F, -1.5708F, 0.0F);
			body.setTextureOffset(17, 16).addBox(-2.9583F, -3.7292F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-1.7083F, -3.7292F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-0.7083F, -3.2292F, -1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-0.7083F, -3.2292F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(1.2917F, -2.7292F, -1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(1.2917F, -2.7292F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-1.7083F, -1.9792F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-1.4583F, 1.0208F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(17, 24).addBox(-1.7083F, 2.0208F, -2.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-2.2083F, 3.7708F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-0.7083F, 2.5208F, -0.25F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(0, 21).addBox(-0.7083F, 2.5208F, -2.75F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(-3.2677F, 8.0305F, 6.1667F);
			setRotationAngle(leftarm, 1.5789F, 0.5666F, -1.543F);
			leftarm.setTextureOffset(19, 45).addBox(2.9636F, -4.4724F, -0.9167F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(19, 45).addBox(0.1378F, -3.349F, -0.9167F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 0).addBox(0.1678F, -5.4622F, -0.9167F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(1, 30).addBox(4.4791F, -4.9231F, -1.9167F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			larm3 = new ModelRenderer(this);
			larm3.setRotationPoint(-1.2781F, -4.0203F, -0.9167F);
			leftarm.addChild(larm3);
			larm3.setTextureOffset(1, 30).addBox(0.9951F, -2.9574F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			lefthand = new ModelRenderer(this);
			lefthand.setRotationPoint(-1.4823F, 9.9695F, -3.9167F);
			leftarm.addChild(lefthand);
			lefthand.setTextureOffset(0, 0).addBox(1.6481F, -17.8951F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(19, 34).addBox(1.4227F, -18.6529F, 2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(1.6889F, -19.1445F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(1.6889F, -20.1445F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(1.6889F, -19.1445F, 4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(7.088F, 7.6345F, 6.45F);
			setRotationAngle(rightarm, 1.5708F, 0.5672F, -1.5708F);
			rightarm.setTextureOffset(19, 45).addBox(2.6079F, -5.5764F, 0.8F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(1, 30).addBox(4.1235F, -6.0272F, 0.8F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rightarm.setTextureOffset(19, 45).addBox(-0.2178F, -4.453F, 0.8F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			rarm2 = new ModelRenderer(this);
			rarm2.setRotationPoint(-1.6338F, -5.1244F, 0.8F);
			rightarm.addChild(rarm2);
			rarm2.setTextureOffset(0, 0).addBox(1.4459F, -1.4419F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			rarm2.setTextureOffset(1, 30).addBox(0.9951F, -2.9574F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			righthand = new ModelRenderer(this);
			righthand.setRotationPoint(-1.838F, 8.8655F, -2.2F);
			rightarm.addChild(righthand);
			righthand.setTextureOffset(0, 0).addBox(1.6481F, -17.8951F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(19, 34).addBox(1.4227F, -18.6529F, 2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(1.6889F, -19.1445F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(1.6889F, -20.1445F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(1.6889F, -19.1445F, 4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(3.75F, 17.25F, -0.5F);
			setRotationAngle(rightleg, 1.5708F, -0.5672F, -1.5708F);
			rightleg.setTextureOffset(1, 30).addBox(-0.1993F, -3.2654F, -1.0F, 5.0F, 3.0F, 2.0F, 0.0F, false);
			rightleg.setTextureOffset(19, 34).addBox(-3.06F, 2.3273F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
			rightleg.setTextureOffset(19, 34).addBox(-4.9786F, 0.6483F, 0.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			rightleg.setTextureOffset(0, 0).addBox(-4.9786F, 0.6483F, -1.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			rleg1 = new ModelRenderer(this);
			rleg1.setRotationPoint(-0.25F, 6.75F, -2.75F);
			rightleg.addChild(rleg1);
			rleg1.setTextureOffset(19, 34).addBox(0.1348F, -7.2137F, 2.25F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			rleg1.setTextureOffset(19, 34).addBox(-2.1765F, -3.874F, 2.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			rleg1.setTextureOffset(19, 34).addBox(-3.3479F, -5.8112F, 3.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			rleg1.setTextureOffset(19, 34).addBox(-3.3479F, -5.8112F, 1.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(-0.8933F, 19.5217F, 0.15F);
			setRotationAngle(leftleg, 1.5708F, -0.5672F, -1.5708F);
			leftleg.setTextureOffset(1, 30).addBox(1.194F, -5.2871F, -1.15F, 5.0F, 3.0F, 2.0F, 0.0F, false);
			leftleg.setTextureOffset(19, 34).addBox(-1.6667F, 0.3056F, -1.15F, 4.0F, 1.0F, 2.0F, 0.0F, false);
			leftleg.setTextureOffset(19, 34).addBox(-3.5853F, -1.3734F, 0.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			leftleg.setTextureOffset(19, 34).addBox(-3.5853F, -1.3734F, -1.9F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			lleg1 = new ModelRenderer(this);
			lleg1.setRotationPoint(1.1433F, 4.7283F, -2.9F);
			leftleg.addChild(lleg1);
			lleg1.setTextureOffset(19, 34).addBox(0.1348F, -7.2137F, 2.25F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			lleg1.setTextureOffset(19, 34).addBox(-2.1765F, -3.874F, 2.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			lleg1.setTextureOffset(19, 34).addBox(-3.3479F, -5.8112F, 3.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			lleg1.setTextureOffset(19, 34).addBox(-3.3479F, -5.8112F, 1.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.neck.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.neck.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
