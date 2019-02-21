package com.bogdanw3.test.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DefaultItem extends Item
{
	public DefaultItem()
	{
		this((new Item.Properties()).group(ItemGroup.MISC));
	}
	public DefaultItem(Item.Properties builder)
	{
		super(builder.group(ItemGroup.MISC));
		//this.setCreativeTab(Tab.TEST_TAB);
	}
	public DefaultItem(String name)
	{
		this();
		//this.setUnlocalizedName(name);
		this.setRegistryName(name.toLowerCase());
	}
	public DefaultItem(Item.Properties builder, String name)
	{
		this(builder);
		//this.setUnlocalizedName(name);
		this.setRegistryName(name.toLowerCase());
	}
}
