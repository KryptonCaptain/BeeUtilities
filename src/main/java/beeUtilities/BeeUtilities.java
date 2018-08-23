package beeUtilities;

import beeUtilities.core.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = "beeUtilities", 
		name = "Bee Utilities", 
		version = "${version}",
		dependencies = "required-after:Forestry"
	)

public class BeeUtilities
{
    @Mod.Instance("beeUtilities")
    public static BeeUtilities instance;
    @SidedProxy(serverSide = "beeUtilities.core.ServerProxy", clientSide = "beeUtilities.core.ClientProxy")
    public static IProxy proxy;
    
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        
        BeeUtilities.proxy.preInit(event);
        
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
               
        BeeUtilities.proxy.init(event);
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
    	
    	/*
    	if (ConfigHandler.noStepOnGuardian)
    		MinecraftForge.EVENT_BUS.register(new DontNoticeMeGuardianSenpai());
    	if (ConfigHandler.fireproofRunic)
    		MinecraftForge.EVENT_BUS.register(new FireproofRunic());
    	*/
    	
    	BeeUtilities.proxy.postInit(event);
    	
    }
    
}
