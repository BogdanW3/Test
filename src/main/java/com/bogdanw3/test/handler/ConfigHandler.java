/*package com.bogdanw3.test.handler;

import java.io.File;
import com.bogdanw3.test.reference.Reference;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
	public static Configuration config;
	public static boolean configValue=false;
	public static void init(File configFile)
	{
		if (config==null)
		{
			config=new Configuration(configFile);
			configSync();
		}
	}
	public static void configSync()
	{
		
		try
		{
			config.load();
			configValue=config.get(Configuration.CATEGORY_GENERAL, "configValue", true, "Test").getBoolean(true);
		}
		catch(Exception e)
		{
			System.err.println(e.toString()+ ", caused by " + e.getCause());
		}
		finally
		{
			if(config.hasChanged())
				{
					config.save();
				}
		}
	}

	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equalsIgnoreCase(Reference.MOD_ID))
		{
			configSync();
		}
	}
}*/
