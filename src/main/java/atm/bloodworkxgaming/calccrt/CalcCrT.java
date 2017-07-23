package atm.bloodworkxgaming.calccrt;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = CalcCrT.MODID, version = CalcCrT.VERSION, dependencies = "after:calculator")
public class CalcCrT
{
    public static final String MODID = "calccrt";
    public static final String VERSION = "1.0";

    public static final Logger logger = LogManager.getLogger(MODID);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        CalcRecipes.removeCalcRecipes();
    }
}
