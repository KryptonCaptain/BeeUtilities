package beeUtilities.core;

import beeUtilities.tweaks.TooltipTweaker;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipTweaker());
    }
    
    @Override
    public void postInit(final FMLPostInitializationEvent event) {
    }
}
