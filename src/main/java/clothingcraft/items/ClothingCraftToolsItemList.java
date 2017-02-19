/**
 * 
 */
package clothingcraft.items;

import clothingcraft.core.ClothingCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * List of blocks and their registrations into the world
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/12/2017 01:34 AM (-7:00 GMT)
 */
public class ClothingCraftToolsItemList {
	public static Item sewingScissors;
	public static Item needleAndThread;
	public static Item measuringTape;
	public static Item pinCushion;
	public static Item knittingNeedles;
	
	public static void preInit() {
		sewingScissors = (Item) new ItemToolScissors();
		GameRegistry.registerItem(sewingScissors, "tools_scissors");
		
		needleAndThread = (Item) new ItemToolNeedleAndThread();
		GameRegistry.registerItem(needleAndThread, "tools_needle_thread");
		
		measuringTape = (Item) new ItemToolMeasuringTape();
		GameRegistry.registerItem(measuringTape, "tools_measuring_tape");
		
		pinCushion = (Item) new ItemToolPincushion();
		GameRegistry.registerItem(pinCushion, "tools_pincushion");
		
		knittingNeedles = (Item) new ItemToolKnittingNeedles();
		GameRegistry.registerItem(knittingNeedles, "tools_knitting_needles");
	}
	
	public static void init() {
		ItemStack stack = new ItemStack(sewingScissors, 1);
		GameRegistry.addRecipe(stack,
				new Object[] { "012", "345", "678", 
						Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('1'), new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('3'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('4'), new ItemStack(Items.shears, 1),
						Character.valueOf('5'), new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('6'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('7'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('8'),	new ItemStack(ClothingCraft.cotton, 1), 
					});
		
		stack = new ItemStack(needleAndThread, 1);
		GameRegistry.addRecipe(stack,
				new Object[] { "012", "345", "678", 
						Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('1'), new ItemStack(Items.string, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('3'), new ItemStack(Items.string, 1),
						Character.valueOf('4'), new ItemStack(Items.stick, 1), 
						Character.valueOf('5'),	new ItemStack(Items.string, 1), 
						Character.valueOf('6'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('7'), new ItemStack(Items.string, 1), 
						Character.valueOf('8'),	new ItemStack(ClothingCraft.cotton, 1), 
					});
		
		stack = new ItemStack(measuringTape, 1);
		GameRegistry.addRecipe(stack,
				new Object[] { "012", "345", "678", 
						Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('1'), new ItemStack(Items.string, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('3'), new ItemStack(Items.string, 1),
						Character.valueOf('4'), new ItemStack(Items.dye, 1, 11), // yellow
						Character.valueOf('5'),	new ItemStack(Items.string, 1), 
						Character.valueOf('6'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('7'), new ItemStack(Items.string, 1), 
						Character.valueOf('8'),	new ItemStack(ClothingCraft.cotton, 1), 
					});
		
		stack = new ItemStack(pinCushion, 1);
		GameRegistry.addRecipe(stack,
				new Object[] { "012", "345", "678", 
						Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('1'), new ItemStack(Items.stick, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('3'), new ItemStack(Items.stick, 1),
						Character.valueOf('4'), new ItemStack(Items.apple, 1), 
						Character.valueOf('5'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('6'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('7'), new ItemStack(Items.stick, 1), 
						Character.valueOf('8'),	new ItemStack(ClothingCraft.cotton, 1), 
					});
		
		stack = new ItemStack(knittingNeedles, 1);
		GameRegistry.addRecipe(stack,
				new Object[] { "012", "345", "678", 
						Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('1'), new ItemStack(Items.stick, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraft.cotton, 1), 
						Character.valueOf('3'), new ItemStack(Items.stick, 1),
						Character.valueOf('4'), new ItemStack(Blocks.wool, 1, 2), 
						Character.valueOf('5'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('6'), new ItemStack(ClothingCraft.cotton, 1),
						Character.valueOf('7'), new ItemStack(Items.stick, 1), 
						Character.valueOf('8'),	new ItemStack(ClothingCraft.cotton, 1), 
					});
	}
}
