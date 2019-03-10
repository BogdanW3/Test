/*package com.bogdanw3.test.client.handler;

import com.bogdanw3.test.init.ModBlocks;
import com.bogdanw3.test.init.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
@EventBusSubscriber(Dist.CLIENT)
public class ModelRegistryHandler
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        registerModel(ModItems.GroundStone);
        registerModel(ModItems.InotiteDust);
        registerModel(ModItems.InotitePickaxe);
        registerModel(Item.getItemFromBlock(ModBlocks.ClearestGlass));
        registerModel(Item.getItemFromBlock(ModBlocks.HollowCobble));
        registerModel(Item.getItemFromBlock(ModBlocks.InotiteBlock));
        registerModel(Item.getItemFromBlock(ModBlocks.InotiteOre));
        registerModel(Item.getItemFromBlock(ModBlocks.UVSphere));
        registerModel(Item.getItemFromBlock(ModBlocks.Teapot));
        registerModel(Item.getItemFromBlock(ModBlocks.ToughStone));
	}
 
    static void registerModel(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}*/