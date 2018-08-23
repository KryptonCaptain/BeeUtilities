package beeUtilities.tweaks;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import beeUtilities.settings.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.IHiveFrame;

@SideOnly(Side.CLIENT)
public class TooltipTweaker
{
    
    
    private static boolean display() {
        return ConfigHandler.tweakVisAmuletTooltip;
    }
        
    
    
    
    
    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event) {
    	
    	ItemStack stack = event.itemStack;
    	
    	if (stack != null && stack.getItem() instanceof IHiveFrame) {
    		
    		IHiveFrame item = (IHiveFrame)stack.getItem();
        	
    		
    		event.toolTip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("util.shift") );
    		if (GuiScreen.isShiftKeyDown()) {
    			
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.durability") + EnumChatFormatting.GRAY + this.getDurability(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.territory") + EnumChatFormatting.GRAY + "x" + this.getTerritory(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.mutation") + EnumChatFormatting.GRAY + "x" + this.getMutation(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.lifespan") + EnumChatFormatting.GRAY + "x" + this.getLifespan(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.production") + EnumChatFormatting.GRAY + "x" + this.getProduction(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.flowering") + EnumChatFormatting.GRAY + "x" + this.getFlowering(stack) );
    			event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.decay") + EnumChatFormatting.GRAY + "x" + this.getGeneticDecay(stack) );
    			
    			
    			//event.toolTip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("util.durability") + (getDurability(stack)<1 ? EnumChatFormatting.DARK_RED : EnumChatFormatting.GREEN) + this.getDurability(stack) );
    		}
    		
    		
    	}
    	/*
    	int charge = getFinalCharge(event.itemStack);
    	if (charge > 0) {
    		event.toolTip.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.runic.charge") + " +" + charge);
		}
    	int warp = getFinalWarp(event.itemStack, event.entityPlayer);
    	if (warp > 0) {
    		event.toolTip.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("item.warping") + " " + warp);
    	}
    	*/
    }
    
    public static int getDurability(ItemStack stack) {
    	
    	return stack.getMaxDamage();
    }
    public static float getTerritory(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getTerritoryModifier(null, 1.0f);
    	return val;
    }
    
    public static float getMutation(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getMutationModifier(null, null, 1.0f);
    	return val;
    }
    
    public static float getLifespan(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getLifespanModifier(null, null, 1.0f);
    	return val;
    }
    
    public static float getProduction(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getProductionModifier(null, 1.0f);
    	return val;
    }
    
    public static float getFlowering(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getFloweringModifier(null, 1.0f);
    	return val;
    }
    
    public static float getGeneticDecay(ItemStack stack) {
    	if (!(stack.getItem() instanceof IHiveFrame)) {
            return 0;
    	}
    	IHiveFrame item = (IHiveFrame)stack.getItem();
    	float val = item.getBeeModifier().getGeneticDecay(null, 1.0f);
    	return val;
    }
    
    
    /*
    public static int getFinalCharge(ItemStack stack)
    {
      if (!(stack.getItem() instanceof IRunicArmor)) {
        return 0;
      }
      IRunicArmor armor = (IRunicArmor)stack.getItem();
      int base = armor.getRunicCharge(stack);
      if ((stack.hasTagCompound()) && (stack.stackTagCompound.hasKey("RS.HARDEN"))) {
        base += stack.stackTagCompound.getByte("RS.HARDEN");
      }
      return base;
    }
    
    public static int getFinalWarp(ItemStack stack, EntityPlayer player)
    {
      if ((stack == null) || (!(stack.getItem() instanceof IWarpingGear))) {
        return 0;
      }
      IWarpingGear armor = (IWarpingGear)stack.getItem();
      return armor.getWarp(stack, player);
    }
    */
    
    
    
}
