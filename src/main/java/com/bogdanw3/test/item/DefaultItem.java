package com.bogdanw3.test.item;

import com.bogdanw3.test.tab.Tab;

import net.minecraft.item.Item;

public class DefaultItem extends Item
{
	public DefaultItem()
	{
		this((new Item.Properties()).group(Tab.TEST_TAB));
	}
	public DefaultItem(Item.Properties builder)
	{
		super(builder.group(Tab.TEST_TAB));
	}
	public DefaultItem(String name)
	{
		this();
		this.setRegistryName(name.toLowerCase());
	}
	public DefaultItem(Item.Properties builder, String name)
	{
		this(builder);
		this.setRegistryName(name.toLowerCase());
	}
}