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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.neck.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.neck.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}