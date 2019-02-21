package com.bogdanw3.test.tab;

import com.bogdanw3.test.init.ModItems;
import com.bogdanw3.test.reference.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tab
{
	public static final ItemGroup TEST_TAB = new ItemGroup(Reference.MOD_ID)
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.InotiteDust);
		}
	};
}
