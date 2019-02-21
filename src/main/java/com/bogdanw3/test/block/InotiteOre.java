package com.bogdanw3.test.block;


import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.bogdanw3.test.init.ModItems;

public class InotiteOre extends DefaultBlock
{
	public InotiteOre()
	{
		super("InotiteOre");
		//this.setHardness(3.3F);
	}
	
	@Override
	public IItemProvider getItemDropped(IBlockState p_199769_1_, World p_199769_2_, BlockPos p_199769_3_, int p_199769_4_)
	{
	      return ModItems.InotiteDust;
	}
}
