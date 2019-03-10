package com.bogdanw3.test;

import com.bogdanw3.test.client.ModelsCache;
import com.bogdanw3.test.init.*;
import com.bogdanw3.test.proxy.ClientProxy;
import com.bogdanw3.test.proxy.IProxy;
import com.bogdanw3.test.proxy.ServerProxy;
import com.bogdanw3.test.reference.Config;
import com.bogdanw3.test.reference.Reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class Test
{
	//public static Test instance;
	
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(),
														() -> () -> new ServerProxy());
	
	private static final Logger logger = LogManager.getLogger();
	
	public Test()
	{
		//instance = this;
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
        //modEventBus.addListener(this::preInit)
       
		modEventBus.addListener(this::clInit);
        
        //modEventBus.addListener(this::init);
		
        modEventBus.addListener(this::postLoad);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.serverSpec);
        modEventBus.register(ForgeConfig.class);
    }
	
	//public void preInit(FMLPreRegistrationEvent event)
	//{
		//MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	//}
	
	public void clInit(FMLClientSetupEvent event)
	{	
		//Seems .obj extension handling isn't yet implemented
		//OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
		ModEntities.bindRenderer();
		((IReloadableResourceManager)Minecraft.getInstance().getResourceManager())
											.addReloadListener(ModelsCache.INSTANCE);
	}
	
	public void postLoad(FMLLoadCompleteEvent event)
	{
		logger.info("Salutations, humanoids!");
	}
	
	/*public void postInit(FMLPostResourceLoadEvent event)
	{
		ModDimensions.registerDimensions();
	}*/
}