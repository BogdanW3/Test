package com.bogdanw3.test.init;

import com.bogdanw3.test.client.render.RenderTeapot;
import com.bogdanw3.test.client.render.RenderWingsFactory;
import com.bogdanw3.test.entity.Wings;
import com.bogdanw3.test.reference.Reference;
import com.bogdanw3.test.tileentity.TeapotTile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntities
{
	public static final EntityType<Wings> WINGS = registerE("wings",
			EntityType.Builder.<Wings>create(Wings.class, Wings::new).disableSerialization());
	public static final TileEntityType<TeapotTile> TEAPOTTILE = registerTE("teapottile",
			TileEntityType.Builder.<TeapotTile>create(TeapotTile::new));
	public static void init()
	{
		/*GameRegistry.registerTileEntity(TeapotTile.class, 
				new ResourceLocation(Reference.MOD_ID, "TeapotTile"));*/
		/*EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Wings"),
			Wings.class, "Wings", 690, Test.instance, 60, 3, false);*/
		/*EntityRegistry.addSpawn(Wings.class, 1, 1, 2, EnumCreatureType.CREATURE,
				Biomes.FOREST, Biomes.HELL);*/

	}
	@OnlyIn(Dist.CLIENT)
	public static void bindRenderer()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TeapotTile.class, new RenderTeapot());
		RenderingRegistry.registerEntityRenderingHandler(Wings.class,
				new RenderWingsFactory());
	}
	@SuppressWarnings("unchecked")
	private static <T extends Entity> EntityType<T> registerE(String name, EntityType.Builder<T> entityBuilder)
	{
		EntityType<T> entitytype = (EntityType<T>) entityBuilder.build(name).setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
	    return entitytype;
	}
	@SuppressWarnings("unchecked")
	private static <T extends TileEntity> TileEntityType<T> registerTE(String name, TileEntityType.Builder<T> teBuilder)
	{
		TileEntityType<T> tetype = (TileEntityType<T>) teBuilder.build(null).setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
	    return tetype;
	}
}
