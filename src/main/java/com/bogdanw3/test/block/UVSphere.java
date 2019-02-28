package com.bogdanw3.test.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class UVSphere extends DefaultBlock
{
	public UVSphere()
	{
		super("UVSphere", Properties.create(Material.CLAY));
	}
	/*@OnlyIn(Dist.CLIENT)
    public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }*/

    /*@Override
    @OnlyIn(Dist.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return false;
    }*/

    @Override
    public boolean isBlockNormalCube(IBlockState state)
    {
        return false;
    }

    /*@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }*/
}