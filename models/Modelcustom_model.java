// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer bone;
	private final ModelRenderer rightleg;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 22.5F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(-4.544F, -10.368F, 0.454F);
		main.addChild(body);
		setRotationAngle(body, -3.1416F, 0.0F, 3.1416F);
		body.setTextureOffset(16, 16).addBox(-7.912F, -12.52F, -0.476F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.77F, -2.29F, 0.196F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-8.6248F, -18.368F, -2.708F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(4, 33).addBox(-10.18F, -16.37F, -4.23F, 11.0F, 1.0F, 11.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(3.694F, 8.328F, 0.796F);
		body.addChild(rightarm);
		setRotationAngle(rightarm, 0.0F, 3.1416F, 0.0F);
		rightarm.setTextureOffset(40, 16).addBox(0.686F, -20.566F, -2.772F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-9.706F, -6.132F, 1.796F);
		body.addChild(leftarm);
		setRotationAngle(leftarm, 0.0F, 3.1416F, 0.0F);
		leftarm.setTextureOffset(32, 48).addBox(-1.758F, -6.106F, -1.772F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-3.456F, 10.368F, 1.546F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(0, 16).addBox(-4.456F, -11.0F, -2.022F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg.addChild(bone);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-3.456F, 10.368F, 1.546F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(16, 48).addBox(-0.52F, -11.0F, -2.022F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}