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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
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