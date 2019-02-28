package com.bogdanw3.test.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DefaultBlock extends Block
{
	public DefaultBlock(Properties properties)
	{
		super(properties);
	}
	public DefaultBlock(String name)
	{
		this(Properties.create(Material.ROCK));
		this.setRegistryName(name.toLowerCase());
	}
	public DefaultBlock(String name, Properties properties)
	{
		this(properties);
		this.setRegistryName(name.toLowerCase());
	}
}