package com.bogdanw3.test.network;

import java.util.Objects;

import com.bogdanw3.test.reference.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public final class Network
{
	private static ResourceLocation test = new ResourceLocation(Reference.MOD_ID,"net");
    public static SimpleChannel channel;
    static {
        channel = NetworkRegistry.ChannelBuilder.named(test).
                clientAcceptedVersions(s -> Objects.equals(s, "1")).
                serverAcceptedVersions(s -> Objects.equals(s, "1")).
                networkProtocolVersion(() -> "1").
                simpleChannel();

        channel.messageBuilder(TeaMessageC.class, 1).
                decoder(TeaMessageC::fromBytes).
                encoder(TeaMessageC::toBytes).
                consumer(TeaMessageC.Handler::onMessage).
                add();
        

        channel.messageBuilder(TeaMessageS.class, 2).
                decoder(TeaMessageS::fromBytes).
                encoder(TeaMessageS::toBytes).
                consumer(TeaMessageS.Handler::onMessage).
                add();
    }
}