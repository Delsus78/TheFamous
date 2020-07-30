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
		this.rightarm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftarm.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
	}
}