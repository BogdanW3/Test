package com.bogdanw3.test.client.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.bogdanw3.test.client.obj.AdvancedModelLoader;
import com.bogdanw3.test.client.obj.IModelCustom;
import com.bogdanw3.test.entity.Wings;
import com.bogdanw3.test.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderWings extends Render<Wings>
{
	public RenderWings(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.7F;
	}
	IModelCustom wingsModel = AdvancedModelLoader.loadModel(new ResourceLocation(Reference.MOD_ID, "models/wings.obj"));
    public ResourceLocation wingsTexture = new ResourceLocation(Reference.MOD_ID, "textures/illidan.png");

	@Override
	public void doRender(Wings entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		this.bindEntityTexture(entity);
		float f1 = interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x, y, z);
		//GL11.glRotatef(90F + rot1, 0.0F, -1.0F, 0.0F); //For body rendering if the head is separated
		GL11.glRotatef(90F + f1, 0.0F, -1.0F, 0.0F);
		if (!entity.isInvisible())
        {
			GL11.glPushMatrix();
			wingsModel.renderAll();
			GL11.glPopMatrix();
        }
        else if (!entity.isInvisibleToPlayer(Minecraft.getInstance().player))
        {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
            this.wingsModel.renderAll();
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
        }
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}
	@Override
	protected ResourceLocation getEntityTexture(Wings entity)
	{
		return wingsTexture;
	}
	
	protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks)
    {
        float f;

        for (f = yawOffset - prevYawOffset; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return prevYawOffset + partialTicks * f;
    }
}

