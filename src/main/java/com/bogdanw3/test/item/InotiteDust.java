package com.bogdanw3.test.item;

import net.minecraft.item.ItemStack;

public class InotiteDust extends DefaultItem
{
	public InotiteDust()
	{
		super("InotiteDust");
	}
	@Override
	public boolean isBeaconPayment(ItemStack stack)
    {
        return true;
    }
}
