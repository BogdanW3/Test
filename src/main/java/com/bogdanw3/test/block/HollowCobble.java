package com.bogdanw3.test.block;

import net.minecraft.util.BlockRenderLayer;

public class HollowCobble extends DefaultBlock
{
	public HollowCobble()
	{
		super("HollowCobble");
		//this.setHardness(1.15F);
		//this.setLightOpacity(8);
	}
	
	/*@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }*/
	
	@Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}
