/*package com.bogdanw3.test.client.handler;

import com.bogdanw3.test.client.settings.KeyBindings;
import com.bogdanw3.test.reference.Key;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@OnlyIn(Dist.CLIENT)
public class KeyInputEventHandler
{
	private static Key getPressedKeyBinding()
	{
		if (KeyBindings.use_tool.isPressed())
		{
			return Key.USE_TOOL;
		}
		else
		{
			return Key.UNKNOWN;
		}
	}
	//@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		if (getPressedKeyBinding()==Key.USE_TOOL)
		{
			
		}
	}
}*/