package com.bogdanw3.test.item;

import net.minecraft.item.ItemStack;

import com.bogdanw3.test.init.ModItems;

public class InotitePickaxe extends DefaultItem
{
	public InotitePickaxe()
	{
		super("InotitePickaxe");
		/*this.setFull3D();
		this.setHarvestLevel("pickaxe", 5);
		this.setMaxStackSize(1);*/
	}

	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack material)
	{
		return ((material.getItem() == ModItems.InotitePickaxe) ||
				(material.getItem() == ModItems.InotiteDust));
		
	}
}