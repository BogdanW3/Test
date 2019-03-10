package com.bogdanw3.test.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bogdanw3.test.init.ModBlocks;
import com.bogdanw3.test.init.ModEntities;
import com.bogdanw3.test.init.ModItems;
import com.bogdanw3.test.tab.Tab;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
	private static final Logger logger = LogManager.getLogger();

	public final static Block[] blocks =
	{
		ModBlocks.ClearestGlass,
		ModBlocks.HollowCobble,
		ModBlocks.InotiteBlock,
		ModBlocks.InotiteOre,
		ModBlocks.UVSphere,
		ModBlocks.Teapot,
		ModBlocks.ToughStone
	};

	public final static Item[] items = 
	{
		ModItems.GroundStone,
		ModItems.InotiteDust,
		ModItems.InotitePickaxe,
	};

	public final static Item[] itemBlocks =
	{
		fromBlock(ModBlocks.ClearestGlass),
		fromBlock(ModBlocks.HollowCobble),
		fromBlock(ModBlocks.InotiteBlock),
		fromBlock(ModBlocks.InotiteOre),
		fromBlock(ModBlocks.UVSphere),
		fromBlock(ModBlocks.Teapot),
		fromBlock(ModBlocks.ToughStone)
	};

	@SubscribeEvent
	public static void registerBlocks(final Register<Block> event)
	{
		logger.info("Registering blocks for Test");
		event.getRegistry().registerAll(blocks);
	}

	@SubscribeEvent
	public static void registerItems(final Register<Item> event)
	{
		logger.info("Registering items for Test");
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}

	@SubscribeEvent
	public static void registerTiles(Register<TileEntityType<?>> event)
	{
		logger.info("Registering tiles for Test");
		event.getRegistry().register(ModEntities.TEAPOTTILE);
	}

	@SubscribeEvent
	public static void registerEntities(Register<EntityType<?>> event)
	{
		logger.info("Registering entities for Test");
		event.getRegistry().register(ModEntities.WINGS);
	}

	/*@SubscribeEvent
	public static void registerEntities(Register<EntityEntry> event)
	{
		event.getRegistry().register(EntityEntryBuilder.create().entity(Wings.class)
				.id(new ResourceLocation(Reference.MOD_ID, "wings"), 1).name("wings")
				.tracker(10, 1, false)
				.spawn(EnumCreatureType.CREATURE, 5, 1, 3, BiomeDictionary
				.getBiomes(BiomeDictionary.Type.HOT))
				.egg(4, 7)
				.build());
	}*/

	private static Item fromBlock(Block block)
	{
		return new ItemBlock(block, (new Item.Properties()).group(Tab.TEST_TAB)).setRegistryName(block.getRegistryName());
	}
}