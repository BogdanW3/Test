package com.bogdanw3.test.entity;

import com.bogdanw3.test.init.ModEntities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

public class Wings extends EntityCreature
{
	public Wings(World world)
	{
		super( ModEntities.WINGS, world);
		this.setSize(1.6F, 1.7F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAITempt(this, 0.8D, false, Ingredient.fromStacks(new ItemStack(Items.DIAMOND))));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 1.4F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
	public boolean canDespawn()
	{
		return false;
	}

	@Override
	protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.7D);
    }

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer)
    {
		if (entityPlayer.getName().getString()=="BogdanW3")
			return 500000;
        return 2000;
    }
}