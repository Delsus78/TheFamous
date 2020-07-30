
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
					return new ResourceLocation("lefameuxmod:textures/famous_entity_texture-v3.png");
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
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, NaiMloclamEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, SpaceCadetEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
			this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 1));
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
		private final ModelRenderer main;
		private final ModelRenderer rightleg;
		private final ModelRenderer lleg1;
		private final ModelRenderer leftleg;
		private final ModelRenderer rleg1;
		private final ModelRenderer neck;
		private final ModelRenderer body;
		private final ModelRenderer leftarm;
		private final ModelRenderer lefthand;
		private final ModelRenderer rarm2;
		private final ModelRenderer rightarm;
		private final ModelRenderer righthand;
		private final ModelRenderer larm3;
		private final ModelRenderer head;
		public ModelFamous_entity() {
			textureWidth = 128;
			textureHeight = 128;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.1067F, -8.4783F, -1.15F);
			main.addChild(rightleg);
			setRotationAngle(rightleg, 1.0036F, 0.0F, 0.0F);
			rightleg.setTextureOffset(2, 85).addBox(-1.7228F, -0.9869F, -2.2646F, 2.0F, 3.0F, 5.0F, 0.0F, true);
			rightleg.setTextureOffset(2, 56).addBox(-1.7228F, 4.6058F, -5.1253F, 2.0F, 1.0F, 4.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(-2.4728F, 2.9268F, -7.0439F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(0.0272F, 2.9268F, -7.0439F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(-2.2228F, 3.5625F, -5.7397F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(-1.2228F, 5.4997F, -4.5683F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(-1.2228F, 2.16F, -2.257F, 1.0F, 4.0F, 2.0F, 0.0F, true);
			rightleg.setTextureOffset(26, 90).addBox(-0.2228F, 3.5625F, -5.7397F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			lleg1 = new ModelRenderer(this);
			lleg1.setRotationPoint(2.9937F, 9.2971F, 0.9F);
			rightleg.addChild(lleg1);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -9.5F, -0.75F);
			main.addChild(leftleg);
			setRotationAngle(leftleg, 1.0036F, 0.0F, 0.0F);
			leftleg.setTextureOffset(2, 56).addBox(-0.3295F, -0.2898F, -2.9778F, 2.0F, 3.0F, 5.0F, 0.0F, true);
			leftleg.setTextureOffset(2, 56).addBox(-0.3295F, 5.3029F, -5.8385F, 2.0F, 1.0F, 4.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(-1.0795F, 3.6239F, -7.7571F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(1.4205F, 3.6239F, -7.7571F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(0.1705F, 2.5119F, -2.8937F, 1.0F, 4.0F, 2.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(0.1705F, 5.9859F, -5.4158F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(-0.8295F, 4.0487F, -6.5872F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			leftleg.setTextureOffset(26, 90).addBox(1.1705F, 4.0487F, -6.5872F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			rleg1 = new ModelRenderer(this);
			rleg1.setRotationPoint(-0.1264F, 9.6491F, 6.75F);
			leftleg.addChild(rleg1);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.894F, -19.5744F, -0.125F);
			main.addChild(neck);
			setRotationAngle(neck, 0.5672F, 0.0F, 0.0F);
			neck.setTextureOffset(17, 9).addBox(-1.9734F, -0.8197F, -1.5366F, 2.0F, 4.0F, 2.0F, 0.0F, true);
			neck.setTextureOffset(17, 9).addBox(-1.9734F, -2.6768F, -1.4761F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			neck.setTextureOffset(17, 9).addBox(-1.4734F, -0.7615F, -0.1347F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			neck.setTextureOffset(17, 9).addBox(-1.4734F, -0.3772F, 1.399F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			neck.setTextureOffset(17, 9).addBox(-1.7234F, -3.6654F, -4.2738F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(-1.4583F, -28.1708F, 1.75F);
			main.addChild(body);
			body.setTextureOffset(93, 46).addBox(-0.6211F, 10.4416F, -4.0F, 4.0F, 3.0F, 3.0F, 0.0F, true);
			body.setTextureOffset(66, 26).addBox(-1.6211F, 10.4416F, -2.75F, 6.0F, 1.0F, 1.0F, 0.0F, true);
			body.setTextureOffset(68, 15).addBox(1.8789F, 10.9416F, -1.75F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(68, 15).addBox(-0.1211F, 10.9416F, -1.75F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(68, 15).addBox(1.8789F, 11.4416F, 0.25F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(68, 15).addBox(-0.1211F, 11.4416F, 0.25F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(77, 54).addBox(-0.1211F, 12.1916F, -2.75F, 3.0F, 3.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(66, 26).addBox(0.3789F, 15.1916F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			body.setTextureOffset(66, 26).addBox(-0.6211F, 16.1916F, -2.75F, 4.0F, 2.0F, 3.0F, 0.0F, true);
			body.setTextureOffset(101, 54).addBox(0.8789F, 17.9416F, -3.25F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			body.setTextureOffset(66, 26).addBox(-1.3711F, 16.6916F, -1.75F, 3.0F, 1.0F, 1.0F, 0.0F, true);
			body.setTextureOffset(66, 26).addBox(1.1289F, 16.6916F, -1.75F, 3.0F, 1.0F, 1.0F, 0.0F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(2.912F, -15.6155F, -1.2F);
			main.addChild(leftarm);
			setRotationAngle(leftarm, 2.3562F, 0.0F, 0.0F);
			leftarm.setTextureOffset(19, 45).addBox(0.7586F, 0.1375F, -2.8061F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			leftarm.setTextureOffset(49, 84).addBox(-0.2414F, -0.3133F, -1.2905F, 2.0F, 3.0F, 3.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(0.7586F, 1.2609F, -5.6318F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(-0.4914F, -4.5651F, -5.5631F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(0.7586F, -5.5651F, -5.5631F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(2.0086F, -4.5651F, -5.5631F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(0.2586F, -4.0735F, -5.8293F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(0.7586F, -3.3157F, -5.6039F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(33, 67).addBox(0.7586F, -0.8524F, -5.6019F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			leftarm.setTextureOffset(11, 69).addBox(0.2586F, -2.3679F, -6.0527F, 2.0F, 3.0F, 2.0F, 0.0F, true);
			lefthand = new ModelRenderer(this);
			lefthand.setRotationPoint(4.0983F, 14.2071F, 10.2F);
			leftarm.addChild(lefthand);
			rarm2 = new ModelRenderer(this);
			rarm2.setRotationPoint(3.8941F, 0.2172F, 7.2F);
			leftarm.addChild(rarm2);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-1.7323F, -16.9695F, -0.9167F);
			main.addChild(rightarm);
			setRotationAngle(rightarm, 2.4435F, 0.0F, 0.0F);
			rightarm.setTextureOffset(19, 45).addBox(-3.0102F, -1.3335F, -3.0171F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-3.0102F, -0.2101F, -5.8429F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-3.0102F, -2.3233F, -5.8129F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			rightarm.setTextureOffset(49, 84).addBox(-3.0102F, -1.7842F, -1.5016F, 2.0F, 3.0F, 3.0F, 0.0F, true);
			rightarm.setTextureOffset(1, 30).addBox(-3.5102F, -3.8388F, -6.2637F, 2.0F, 3.0F, 2.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-4.2602F, -6.0361F, -5.7741F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-3.0102F, -7.0361F, -5.7741F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-1.7602F, -6.0361F, -5.7741F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-3.5102F, -5.5445F, -6.0403F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			rightarm.setTextureOffset(33, 67).addBox(-3.0102F, -4.7867F, -5.8149F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			righthand = new ModelRenderer(this);
			righthand.setRotationPoint(9.1102F, 12.7217F, 2.0067F);
			rightarm.addChild(righthand);
			larm3 = new ModelRenderer(this);
			larm3.setRotationPoint(8.906F, -1.2681F, -0.9933F);
			rightarm.addChild(larm3);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -19.5F, -2.0F);
			main.addChild(head);
			head.setTextureOffset(58, 59).addBox(-1.5794F, -2.9F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, true);
			head.setTextureOffset(94, 80).addBox(-0.5794F, -2.65F, -3.5F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			head.setTextureOffset(76, 71).addBox(-1.0794F, -2.15F, -4.25F, 2.0F, 2.0F, 4.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightarm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
