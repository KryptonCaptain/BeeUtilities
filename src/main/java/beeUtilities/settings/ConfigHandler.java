package beeUtilities.settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
    public static Configuration config;
    public static final String CATEGORY_TWEAKS = "general.tweaks";

    
    public static boolean tweakVisAmuletTooltip;


    
    public static void init(final File configFile) {
        if (config == null) {
            config = new Configuration(configFile, true);
            loadConfig();
        }
    }
    
    public static void loadConfig() {
        
        tweakVisAmuletTooltip = config.getBoolean("visAmuletTooltipTweak", "general.tweaks", true, "Tweak the amulet tooltip to be like the wand");
        
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase("thutilities")) {
            loadConfig();
        }

    }
    

}
