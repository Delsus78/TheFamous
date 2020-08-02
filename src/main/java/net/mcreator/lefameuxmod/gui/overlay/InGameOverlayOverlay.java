
package net.mcreator.lefameuxmod.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.lefameuxmod.LefameuxmodModVariables;
import net.mcreator.lefameuxmod.LefameuxmodModElements;

@LefameuxmodModElements.ModElement.Tag
public class InGameOverlayOverlay extends LefameuxmodModElements.ModElement {
	public InGameOverlayOverlay(LefameuxmodModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			if ((true)) {
				Minecraft.getInstance().fontRenderer.drawString("" + (LefameuxmodModVariables.FamousPoint) + "", posX + 120, posY + -46, -1);
				Minecraft.getInstance().fontRenderer.drawString("Famous Points", posX + 145, posY + -45, -1);
			}
		}
	}
}
