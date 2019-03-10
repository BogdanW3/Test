package com.bogdanw3.test.client.obj;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TextureCoordinate
{
	public float u, v, w;

	public TextureCoordinate(float u, float v)
	{
		this(u, v, 0F);
	}

	public TextureCoordinate(float u, float v, float w)
	{
		this.u = u;
		this.v = v;
		this.w = w;
	}
}