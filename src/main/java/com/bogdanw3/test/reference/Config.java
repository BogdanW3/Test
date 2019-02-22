package com.bogdanw3.test.reference;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class Config {
	public static class Client {
	    public final IntValue test1;
	
	    Client(ForgeConfigSpec.Builder builder) {
	        builder.comment("Client settings")
	               .push("client");
	
	        test1 = builder.comment("Do these even need to do anything?")
	        		.translation("test.config.test1")
	        		.defineInRange("test1", 5, 0, 65535);
	        
	        builder.pop();
	    }
	}
	public static class Server {
        public final BooleanValue serv1;
        Server(ForgeConfigSpec.Builder builder) {
	        builder.comment("Server configuration settings")
	        .push("server");
	
	        serv1 = builder
	         .comment("This one does nothing, but still requires a server restart.")
	         .translation("test.config.serv1")
	         .worldRestart()
	         .define("serv1", false);
		}
	}
	public static final ForgeConfigSpec clientSpec;
    public static final Client CLIENT;
    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }


    public static final ForgeConfigSpec serverSpec;
    public static final Server SERVER;
    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        serverSpec = specPair.getRight();
        SERVER = specPair.getLeft();
    }
}
