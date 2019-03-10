package com.bogdanw3.test.block;

import net.minecraft.block.material.Material;

public class InotiteBlock extends DefaultBlock
{
	public InotiteBlock()
	{
		super("InotiteBlock", Properties.create(Material.ROCK).hardnessAndResistance(3.3F)
				.slipperiness(1.5F));
	}

	/*@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		player.dimension=69;
		player.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		return true;
	}*/
}