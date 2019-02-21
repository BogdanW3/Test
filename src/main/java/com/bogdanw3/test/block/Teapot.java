package com.bogdanw3.test.block;

import com.bogdanw3.test.tileentity.TeapotTile;
import com.bogdanw3.test.client.gui.TeapotGUI;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Teapot extends DefaultBlock
{
	public Teapot()
	{
		super(Material.CLOTH, "Teapot");
	}

    /*@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }*/

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	Minecraft.getInstance().displayGuiScreen(new TeapotGUI((TeapotTile)world.getTileEntity(pos)));
        return true;
	}
    
    @Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
	 	return new TeapotTile();
    }
    
    @Override
	public boolean hasTileEntity(IBlockState state)
    {
	 	return true;
    }
    
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}