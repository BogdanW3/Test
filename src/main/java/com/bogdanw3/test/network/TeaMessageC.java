package com.bogdanw3.test.network;

import java.nio.charset.Charset;
import java.util.function.Supplier;
import io.netty.buffer.ByteBuf;

import net.minecraftforge.fml.network.NetworkEvent.Context;

public class TeaMessageC
{
	private String text1, text2;
	private int x, y, z;
	private static Charset main = Charset.forName("utf-8");
	public TeaMessageC()
	{
		
	}

	public TeaMessageC(String text1, String text2, int x, int y, int z)
	{
		this.text1 = text1;
		this.text2 = text2;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static TeaMessageC fromBytes(ByteBuf buf)
	{
		int len1 = buf.readInt();
		int len2 = buf.readInt();
		return new TeaMessageC(buf.readCharSequence(len1, main).toString()
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
		public static void onMessage(TeaMessageC message, Supplier<Context> ctx)
		{
			/*Test.logger.debug(String.format("Received %s %s %s %s %s from Server", message.text1, message.text2, message.x, message.y, message.z));
			TeapotTile te = (TeapotTile) DimensionManager.getWorld(0).getTileEntity(new BlockPos(message.x, message.y, message.z));
			te.modelname = message.text1;
			te.texturename = message.text2;
			te.markDirty();*/
		}
	}
}