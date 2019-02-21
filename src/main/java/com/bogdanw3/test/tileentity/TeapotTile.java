package com.bogdanw3.test.tileentity;

//import com.bogdanw3.test.Test;
import com.bogdanw3.test.init.ModEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public class TeapotTile extends DefaultTile
{

	public String modelname = "Teapot";
	public String texturename = "Red";
	

	public TeapotTile()
	{
		super(ModEntities.TEAPOTTILE);
	}
	
	@Override
    public void read(NBTTagCompound compound)
    {
        super.read(compound);
        NBTTagCompound names = compound.getCompound("names");
        this.modelname = names.getString("modelname");
        this.texturename = names.getString("texturename");
        //Test.logger.info("Read TeapotTile data from NBT:" + this.modelname + " + " + this.texturename);
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound)
    {
        super.write(compound);
    	NBTTagCompound names = compound.getCompound("names");
        if (names == null)
        	names = new NBTTagCompound();
        names.setString("modelname", this.modelname);
        names.setString("texturename", this.texturename);
		compound.setTag("names", names);
		//Test.logger.info("Wrote TeapotTile data to NBT:" + names.getString("modelname") + " + " + names.getString("texturename"));
		return compound;
    }
    
    @Override
    public NBTTagCompound getUpdateTag()
    {
        return write(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.write(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.read(packet.getNbtCompound());
    }
}