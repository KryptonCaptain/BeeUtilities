package beeUtilities;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = "beeUtilities", 
		name = "Bee Utilities", 
		version = "${version}"
	)

public class BeeUtilities
{
    @Mod.Instance("beeUtilities")
    public static BeeUtilities instance;

    
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new TooltipTweaker());
    }
    
    
}
