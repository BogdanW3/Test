package com.bogdanw3.test.client;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bogdanw3.test.client.obj.AdvancedModelLoader;
import com.bogdanw3.test.client.obj.IModelCustom;

import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

public enum ModelsCache implements ISelectiveResourceReloadListener
{
	INSTANCE;

	//private static final Logger logger = LogManager.getLogger();

	private final Map<ResourceLocation, IModelCustom> cache = new HashMap
			<ResourceLocation, IModelCustom>();

	public IModelCustom getModel( ResourceLocation location )
	{
		IModelCustom model = cache.get( location );
		if( model == null )
		{
			//logger.info("Cache miss for: " + location.getResourcePath());
			try
			{
				model = AdvancedModelLoader.loadModel(location);
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
			cache.put(location, model);
		}
		return model;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager, Predicate<IResourceType> resourcePredicate)
	{
		if(resourcePredicate.test(VanillaResourceType.MODELS))
			cache.clear();
	}
}