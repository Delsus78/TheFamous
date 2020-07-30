
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
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("lefameuxmod:textures/texture_famous.png");
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
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1));
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
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer neck;
		private final ModelRenderer body;
		private final ModelRenderer leftarm;
		private final ModelRenderer larm3;
		private final ModelRenderer lefthand;
		private final ModelRenderer rightarm;
		private final ModelRenderer rarm2;
		private final ModelRenderer righthand;
		public Modelcustom_model() {
			textureWidth = 16;
			textureHeight = 16;
			head = new ModelRenderer(this);
			head.setRotationPoint(1.0F, 19.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-5.25F, -15.75F, -0.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-6.25F, -15.5F, 0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-7.25F, -15.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(-1.0625F, -13.1F, 1.125F);
			head.addChild(neck);
			setRotationAngle(neck, 0.0F, 0.0F, -0.3927F);
			neck.setTextureOffset(0, 0).addBox(-2.1875F, -2.15F, -1.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			neck.setTextureOffset(0, 0).addBox(-1.4375F, -0.15F, -1.125F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			neck.setTextureOffset(0, 0).addBox(0.8125F, -0.6F, -0.375F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			neck.setTextureOffset(0, 0).addBox(-1.1875F, -1.1F, -0.375F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-1.5F, -16.75F, -1.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.75F, -16.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.75F, -16.25F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(2.75F, -15.75F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(2.75F, -15.75F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-0.25F, -15.0F, -0.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.0F, -12.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-0.25F, -11.0F, -1.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.75F, -10.5F, 0.75F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.75F, -10.5F, -1.75F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(1.9696F, 12.7834F, -2.375F);
			setRotationAngle(leftarm, 0.0F, 0.0F, -0.9599F);
			leftarm.setTextureOffset(0, 0).addBox(0.0304F, -4.7834F, 0.375F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 0).addBox(-2.7953F, -3.66F, 0.375F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 0).addBox(-2.7654F, -5.7733F, 0.375F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 0).addBox(1.5459F, -5.2342F, -0.625F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			larm3 = new ModelRenderer(this);
			larm3.setRotationPoint(-1.7654F, -2.7733F, 0.375F);
			leftarm.addChild(larm3);
			larm3.setTextureOffset(0, 0).addBox(-1.4508F, -4.5155F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			lefthand = new ModelRenderer(this);
			lefthand.setRotationPoint(-1.9696F, 11.2166F, -2.625F);
			leftarm.addChild(lefthand);
			lefthand.setTextureOffset(0, 0).addBox(-0.7978F, -19.4532F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(-1.0232F, -20.211F, 2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(-0.757F, -20.7026F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(-0.757F, -21.7026F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			lefthand.setTextureOffset(0, 0).addBox(-0.757F, -20.7026F, 4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(1.9696F, 12.7834F, 2.625F);
			setRotationAngle(rightarm, 0.0F, 0.0F, -0.9599F);
			rightarm.setTextureOffset(0, 0).addBox(0.0304F, -4.7834F, 0.375F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 0).addBox(1.5459F, -5.2342F, 0.375F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 0).addBox(-2.7953F, -3.66F, 0.375F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			rarm2 = new ModelRenderer(this);
			rarm2.setRotationPoint(-1.7654F, -2.7733F, 0.375F);
			rightarm.addChild(rarm2);
			rarm2.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			rarm2.setTextureOffset(0, 0).addBox(-1.4508F, -4.5155F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			righthand = new ModelRenderer(this);
			righthand.setRotationPoint(-1.9696F, 11.2166F, -2.625F);
			rightarm.addChild(righthand);
			righthand.setTextureOffset(0, 0).addBox(-0.7978F, -19.4532F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(-1.0232F, -20.211F, 2.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(-0.757F, -20.7026F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(-0.757F, -21.7026F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			righthand.setTextureOffset(0, 0).addBox(-0.757F, -20.7026F, 4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.neck.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.neck.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
