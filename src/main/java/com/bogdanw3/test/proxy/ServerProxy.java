package com.bogdanw3.test.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.DEDICATED_SERVER)
public class ServerProxy implements IProxy
{
	@Override
	public void preInit()
	{	
	
	}

	@Override
	public void init()
	{
		
	}
}
