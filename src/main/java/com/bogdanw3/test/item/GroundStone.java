package com.bogdanw3.test.item;

import net.minecraft.item.Item;

public class GroundStone extends DefaultItem
{
	public GroundStone()
	{
		super((new Item.Properties()).maxStackSize(128), "GroundStone");
	}
}