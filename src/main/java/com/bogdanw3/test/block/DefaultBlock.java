package com.bogdanw3.test.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DefaultBlock extends Block
{
	public DefaultBlock(Material material)
	{
		super(Block.Properties.create(material));
		//this.setItemGroup(Tab.TEST_TAB);
	}
	public DefaultBlock()
	{
		this(Material.ROCK);
	}
	public DefaultBlock(String name)
	{
		this();
		//this.setUnlocalizedName(name);
		this.setRegistryName(name.toLowerCase());
	}
	public DefaultBlock(Material material, String name)
	{
		this(material);
		//this.setUnlocalizedName(name);
		this.setRegistryName(name.toLowerCase());
	}
}