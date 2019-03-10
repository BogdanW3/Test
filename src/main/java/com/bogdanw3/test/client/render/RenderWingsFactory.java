package com.bogdanw3.test.client.render;

import com.bogdanw3.test.entity.Wings;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWingsFactory implements IRenderFactory<Wings>
{
	@Override
	public Render<? super Wings> createRenderFor(RenderManager manager)
	{
		return new RenderWings(manager);
	}
}