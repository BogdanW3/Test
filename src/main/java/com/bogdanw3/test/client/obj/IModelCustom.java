package com.bogdanw3.test.client.obj;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IModelCustom
{
    String getType();
    void renderAll();
    void renderOnly(String... groupNames);
    void renderPart(String partName);
    void renderAllExcept(String... excludedGroupNames);
}