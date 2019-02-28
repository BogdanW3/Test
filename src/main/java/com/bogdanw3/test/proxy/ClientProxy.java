package com.bogdanw3.test.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class ClientProxy implements IProxy
{
	@Override
	public void init()
	{
		//MinecraftForge.EVENT_BUS.register(new KeyInputEventHandler());
	}
}
