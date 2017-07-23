package atm.bloodworkxgaming.calccrt;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.ArrayUtils;
import sonar.calculator.mod.common.recipes.*;
import sonar.core.recipes.DefaultSonarRecipe;
import sonar.core.recipes.DefinedRecipeHelper;
import sonar.core.recipes.ISonarRecipeObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jonas on 06.07.2017.
 */
public class CalcRecipes {

    @SuppressWarnings("unchecked")
    public static void removeCalcRecipes(){
        CalcCrT.logger.info("Removing calc recipes");

        if (Loader.isModLoaded("calculator")) {

            removeRecipe(CalculatorRecipes.instance(), Arrays.asList(BlacklistConfig.basicCalculatorRecipes));
            removeRecipe(ScientificRecipes.instance(), Arrays.asList(BlacklistConfig.scientificRecipes));
            removeRecipe(FlawlessCalculatorRecipes.instance(), Arrays.asList(BlacklistConfig.flawlessCalculatorRecipes));
            removeRecipe(AtomicCalculatorRecipes.instance(), Arrays.asList(BlacklistConfig.atomicCalculatorRecipes));
            removeRecipe(StoneSeparatorRecipes.instance(), Arrays.asList(BlacklistConfig.stoneSeparatorRecipes));
            removeRecipe(AlgorithmSeparatorRecipes.instance(), Arrays.asList(BlacklistConfig.algorithmSeparatorRecipes));

        }
    }


    public static void removeRecipe(DefinedRecipeHelper instance, List<String> outputsToRemove){

        List<DefaultSonarRecipe> toRemove = new ArrayList<>();

        for (Object recipeObject : instance.getRecipes()) {
            if (recipeObject instanceof DefaultSonarRecipe){
                DefaultSonarRecipe recipe = (DefaultSonarRecipe) recipeObject;

                System.out.println("recipe = " + ArrayUtils.toString(recipe.outputs().toArray()));
                for (ISonarRecipeObject recipeOutput: recipe.outputs()) {
                    for (ItemStack stack: recipeOutput.getJEIValue()) {
                        String itemName = stack.getItem().getRegistryName().toString() + ":" + stack.getMetadata();

                        System.out.println("item = " + itemName);
                        if (outputsToRemove.contains(itemName)){
                            toRemove.add(recipe);
                        }
                    }
                }
            }
        }

        for (DefaultSonarRecipe recipe: toRemove) {
            instance.removeRecipe(recipe);
        }
    }



}
