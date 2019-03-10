package com.bogdanw3.test.network;

import java.nio.charset.Charset;
import java.util.function.Supplier;

import com.bogdanw3.test.tileentity.TeapotTile;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class TeaMessageS
{
    private String text1, text2;
    private int x, y, z;
    private static Charset main = Charset.forName("utf-8");

    public TeaMessageS()
    {
    	
    }

    public TeaMessageS(String text1, String text2, int x, int y, int z)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static TeaMessageS fromBytes(ByteBuf buf)
    {
    	int len1 = buf.readInt();
    	int len2 = buf.readInt();
    	return new TeaMessageS(buf.readCharSequence(len1, main).toString()
    		,buf.readCharSequence(len2, main).toString(), buf.readInt(), buf.readInt(), buf.readInt());
    }

    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(text1.length());
    	buf.writeInt(text2.length());
    	buf.writeCharSequence(text1, main);
    	buf.writeCharSequence(text2, main);
    	buf.writeInt(x);
    	buf.writeInt(y);
    	buf.writeInt(z);
    }

    public static class Handler
    {
        public static void onMessage(TeaMessageS message, Supplier<Context> ctx)
        {
            //Test.logger.debug(String.format("Received %s %s %s %s %s from %s", message.text1, message.text2, message.x, message.y, message.z, ctx.get().getSender().getName()));
            String temp1 = message.text1;
            String temp2 = message.text2;
            TeapotTile te = (TeapotTile) ctx.get().getSender().getEntityWorld().getTileEntity(new BlockPos(message.x, message.y, message.z));
            te.modelname = temp1;
            te.texturename = temp2;
            te.markDirty();
        }
    }
}