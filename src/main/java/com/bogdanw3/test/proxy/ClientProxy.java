package com.bogdanw3.test.proxy;

import com.bogdanw3.test.client.ModelsCache;
import com.bogdanw3.test.init.ModEntities;
import com.bogdanw3.test.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.obj.OBJLoader;


@OnlyIn(Dist.CLIENT)
public class ClientProxy implements IProxy
{
	@Override
	public void preInit()
	{	
		OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
		//ClientRegistry.registerKeyBinding(KeyBindings.use_tool);
		ModEntities.bindRenderer();
		((IReloadableResourceManager)Minecraft.getInstance().getResourceManager()).addReloadListener(ModelsCache.INSTANCE);
	}
	public void init()
	{
		//MinecraftForge.EVENT_BUS.register(new KeyInputEventHandler());
	}
}
