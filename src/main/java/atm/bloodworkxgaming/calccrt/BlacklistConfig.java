package atm.bloodworkxgaming.calccrt;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Jonas on 09.05.2017.
 */

@Config(modid = CalcCrT.MODID)
public class BlacklistConfig {

    @Config.Comment("Syntax: 'modname:item:meta' e.g. 'calculator:EnrichedGold:0' | One per line | '0' meta is required")
    public static java.lang.String[] algorithmSeparatorRecipes = new java.lang.String[]{};
    public static java.lang.String[] basicCalculatorRecipes = new java.lang.String[]{};
    public static java.lang.String[] scientificRecipes = new java.lang.String[]{};
    public static java.lang.String[] atomicCalculatorRecipes = new java.lang.String[]{};
    public static java.lang.String[] flawlessCalculatorRecipes = new java.lang.String[]{};
    public static java.lang.String[] stoneSeparatorRecipes = new java.lang.String[]{};



    @Mod.EventBusSubscriber
    static class ConfigurationHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
            if (event.getModID().equals(CalcCrT.MODID)){
                ConfigManager.load(CalcCrT.MODID, Config.Type.INSTANCE);
            }
        }
    }
}

// <https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/b3d71dfddf7f212f0d86ef36e6ae1d06b8493ebc/src/main/java/choonster/testmod3/config/ModConfig.java>