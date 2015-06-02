package mods.defeatedcrow.plugin.craftguide;

import java.lang.reflect.Method;

import mods.defeatedcrow.common.AMTLogger;
import uristqwerty.CraftGuide.api.CraftGuideAPIObject;

public class LoadCraftGuidePlugin extends CraftGuideAPIObject {

	public static TeaRecipeHandlerCG teaRecipeCG;
	public static IceRecipeHandlerCG iceRecipeCG;
	public static PanRecipeHandlerCG panRecipeCG;
	public static ProsessorRecipeHandlerCG prosessorRecipeCG;
	public static AdvProcessorRecipeHandlerCG advProcessorRecipeCG;
	public static EvaporatorRecipeHandlerCG evaporatorRecipeCG;
	public static TeppanRecipeHandlerCG plateRecipeCG;
	public static ChocoRecipeHandlerCG chocoRecipeCG;

	public void load() {
		try {
			teaRecipeCG = new TeaRecipeHandlerCG();
			iceRecipeCG = new IceRecipeHandlerCG();
			panRecipeCG = new PanRecipeHandlerCG();
			prosessorRecipeCG = new ProsessorRecipeHandlerCG();
			evaporatorRecipeCG = new EvaporatorRecipeHandlerCG();
			advProcessorRecipeCG = new AdvProcessorRecipeHandlerCG();
			plateRecipeCG = new TeppanRecipeHandlerCG();
			chocoRecipeCG = new ChocoRecipeHandlerCG();

			Class api = Class.forName("uristqwerty.CraftGuide.ReflectionAPI");
			Method register = api.getMethod("registerAPIObject", new Class[] { Object.class });
			register.invoke(null, new Object[] { teaRecipeCG });
			register.invoke(null, new Object[] { iceRecipeCG });
			register.invoke(null, new Object[] { panRecipeCG });
			register.invoke(null, new Object[] { prosessorRecipeCG });
			register.invoke(null, new Object[] { evaporatorRecipeCG });
			register.invoke(null, new Object[] { advProcessorRecipeCG });
			register.invoke(null, new Object[] { plateRecipeCG });
			register.invoke(null, new Object[] { chocoRecipeCG });

			AMTLogger.loadedModInfo("CraftGuide");
		} catch (Exception e) {
			AMTLogger.logger.warn("Failed to registering CraftGuide Plugin.", new Object[] { e.getMessage() });
		}

	}

}
