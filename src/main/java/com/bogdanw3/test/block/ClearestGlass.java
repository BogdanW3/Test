package com.bogdanw3.test.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ClearestGlass extends DefaultBlock
{
	public ClearestGlass()
	{
		super("ClearestGlass", Properties.create(Material.GLASS)
				.hardnessAndResistance(0.3F).sound(SoundType.GLASS));
	}
	 
	/*@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }*/
	
	/*@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
	{
		BlockPos pos2 = pos.offset(facing);
		world.setBlockState(pos2, state);
		return true;
	}*/
	@Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
