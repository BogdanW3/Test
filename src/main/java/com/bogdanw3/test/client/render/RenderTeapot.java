package com.bogdanw3.test.client.render;

import com.bogdanw3.test.tileentity.TeapotTile;
import com.bogdanw3.test.client.ModelsCache;
import com.bogdanw3.test.client.obj.IModelCustom;
import com.bogdanw3.test.reference.Reference;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class RenderTeapot extends TileEntityRenderer<TeapotTile>
{
	public String modelname="Teapot";
	public String texturename="Red";
	private IModelCustom model;
	private ResourceLocation texture;
	@Override
	public void render(TeapotTile te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		if (modelname != te.modelname)
		{
			modelname = te.modelname;
			model = ModelsCache.INSTANCE.getModel(new ResourceLocation(Reference.MOD_ID,
					("models/" + modelname + ".obj").toLowerCase()));
		}
		if (model == null)
		{
			//Test.logger.warn("Model: " + modelname + " wasn't found or couldn't be loaded! Loading default");
			model = ModelsCache.INSTANCE.getModel(new ResourceLocation(Reference.MOD_ID, "models/teapot.obj"));
		}
		if (texturename != te.texturename)
		{
			texturename = te.texturename;
			texture = new ResourceLocation(Reference.MOD_ID, ("textures/" + texturename
					+ ".png").toLowerCase());
		}
		if (texture == null)
		{
			texture = new ResourceLocation(Reference.MOD_ID, "textures/red.png");
		}
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		model.renderAll();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}