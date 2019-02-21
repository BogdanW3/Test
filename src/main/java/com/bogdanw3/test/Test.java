package com.bogdanw3.test;

import com.bogdanw3.test.init.*;
import com.bogdanw3.test.reference.Reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value=Reference.MOD_ID)
public class Test 
{
	/*@Mod.Instance(Reference.MOD_ID)
	public static Test instance;*/
	
	/*@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;*/
	
	//public static SimpleNetworkWrapper TestChannel;
	
	private static final Logger logger = LogManager.getLogger();
	
	public Test()
	{
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clInit);
        
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postLoad);

        // Register ourselves for server, registry and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }
	
	//public void preInit(FMLPreRegistrationEvent event)
	//{
		//ConfigHandler.init(event.getSuggestedConfigurationFile());
		//MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		//proxy.preInit();
		/*TestChannel = NetworkRegistry.INSTANCE.newSimpleChannel("TestChannel");
		TestChannel.registerMessage(TeaMessageS.Handler.class, TeaMessageS.class, 0, Side.SERVER);
		TestChannel.registerMessage(TeaMessageC.Handler.class, TeaMessageC.class, 1, Side.CLIENT);*/
	//}
	
	public void clInit(FMLClientSetupEvent event)
	{
		//Seems .obj extension handling isn't yet implemented
		//OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
		ModEntities.bindRenderer();
	}
	
	public void postLoad(FMLLoadCompleteEvent event)
	{

		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		//proxy.init();
		logger.info("Salutations, humanoids!");
	}
	
	/*public void postInit(FMLPostResourceLoadEvent event)
	{
		ModDimensions.registerDimensions();
	}*/
}