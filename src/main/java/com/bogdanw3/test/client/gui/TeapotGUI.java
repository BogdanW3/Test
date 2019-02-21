package com.bogdanw3.test.client.gui;

import com.bogdanw3.test.network.Network;
import com.bogdanw3.test.network.TeaMessageS;
import com.bogdanw3.test.tileentity.TeapotTile;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeapotGUI extends GuiScreen
{
	private GuiTextField mtext;
	private GuiTextField ttext;
	public static final int GUI_ID = 69;
	private TeapotTile tile;
	private BlockPos pos;
	public TeapotGUI(TeapotTile callertile)
	{
		tile = callertile;
		pos = tile.getPos();
	}
	@Override
    public void initGui()
	{
		this.mtext = new GuiTextField(0, this.fontRenderer, this.width / 2 - 68, this.height / 2 - 46, 137, 20);
        mtext.setMaxStringLength(64);
        mtext.setText(tile.modelname);
        this.mtext.setFocused(true);
        this.ttext = new GuiTextField(1, this.fontRenderer, this.width / 2 - 68, this.height / 2 - 19, 137, 20);
        ttext.setMaxStringLength(64);
        ttext.setText(tile.texturename);
        this.ttext.setFocused(false);
        this.setFocused(mtext);
        this.addButton(new GuiButton(2, this.width / 2 - 79, this.height / 2 + 8, "Submit")
        {
        	@Override
        	public void onClick(double mouseX, double mouseY)
        	{
        		Network.channel.sendToServer(new TeaMessageS(mtext.getText(), ttext.getText(), pos.getX(), pos.getY(), pos.getZ()));
        		tile.modelname = mtext.getText();
        		tile.texturename = ttext.getText();
        		tile.markDirty();
        		tile.getWorld().notifyBlockUpdate(pos, tile.getBlockState(), tile.getBlockState(), 2);
            }
        });
	}

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void render(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.mtext.drawTextField(par1, par2, par3);
        this.ttext.drawTextField(par1, par2, par3);
        super.render(par1, par2, par3);
    }
    @Override
    public boolean keyPressed(int i1, int i2, int i3)
    {   
        //super.keyPressed(i1, i2, i3);

        if( this.mtext.isFocused())
        {
        	this.mtext.keyPressed(i1, i2, i3); 
        }
        if(this.ttext.isFocused())
        {
        	this.ttext.keyPressed(i1, i2, i3); 
        }
        return super.keyPressed(i1, i2, i3); 
    }
    @Override
    public void tick()
    {
        super.tick();
        this.mtext.tick();
        this.ttext.tick();
    }
    @Override
    public boolean mouseClicked(double x, double y, int btn)
    {
        super.mouseClicked(x, y, btn);
        this.mtext.mouseClicked(x, y, btn);
        this.ttext.mouseClicked(x, y, btn);
        return true;
    }
    /*@Override
    protected void actionPerformed(GuiButton button)
    {
    	if (button == submit)
    	{
    		Test.TestChannel.sendToServer(new TeaMessageS(mtext.getText(), ttext.getText(), pos.getX(), pos.getY(), pos.getZ()));
    		tile.modelname = mtext.getText();
    		tile.texturename = ttext.getText();
    		tile.markDirty();
    	}
    }*/
}
