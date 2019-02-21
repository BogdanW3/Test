package com.bogdanw3.test.block;

import java.util.Random;

import com.bogdanw3.test.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToughStone extends DefaultBlock
{
	
	public ToughStone()
	{
		super("ToughStone");
		/*this.setHardness(10F);
		this.setHarvestLevel("pickaxe", 5);*/
	}
	
	@Override
	public int quantityDropped(IBlockState state, Random random)
    {
		short val=0;
		for(short i=0;i<5;++i)
			val+=random.nextInt(2)*4;
        return val;
    }
	
	@Override
	public IItemProvider getItemDropped(IBlockState p_199769_1_, World p_199769_2_, BlockPos p_199769_3_, int p_199769_4_)
	{
        return ModItems.GroundStone;
    }
	
	/*@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		short val=0;
		for(int i=0;i<fortune;++i)
			val+=random.nextInt(2)*4;
		return this.quantityDropped(random) + val;
	}*/
}