package com.bogdanw3.test.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class HollowCobble extends DefaultBlock
{
	public HollowCobble()
	{
		super("HollowCobble", Properties.create(Material.ROCK).hardnessAndResistance(1.15F));
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