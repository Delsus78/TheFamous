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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}