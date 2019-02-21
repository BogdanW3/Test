package com.bogdanw3.test.client.handler;

import com.bogdanw3.test.client.gui.TeapotGUI;
import com.bogdanw3.test.tileentity.TeapotTile;

import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == TeapotGUI.GUI_ID)
		{
	           return new TeapotGUI((TeapotTile) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
}