/**
 * 
 */
package clothingcraft.items;

import clothingcraft.blocks.ClothingCraftHaliteBlockList;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * List of blocks and their registrations into the world
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 05:58 AM (-7:00 GMT)
 */
public class ClothingCraftHaliteItemList {
	public static Item rockSalt;
	public static Item haliteIngot;
	public static Item haliteSword;
	public static Item haliteAxe;
	public static Item haliteHoe;
	public static Item halitePickaxe;
	public static Item haliteShovel;
	
	public static void preInit() {
		rockSalt = (Item) new ItemRockSalt();
		GameRegistry.registerItem(rockSalt, "rock_salt");
		
		haliteIngot = (Item) new ItemHaliteIngot();
		GameRegistry.registerItem(haliteIngot, "halite_ingot");
		
		haliteSword = (Item) new ItemHaliteSword();
		GameRegistry.registerItem(haliteSword, "halite_sword");
		
		haliteAxe = (Item) new ItemHaliteAxe();
		GameRegistry.registerItem(haliteAxe, "halite_axe");
		
		haliteHoe = (Item) new ItemHaliteHoe();
		GameRegistry.registerItem(haliteHoe, "halite_hoe");
		
		halitePickaxe = (Item) new ItemHalitePickaxe();
		GameRegistry.registerItem(halitePickaxe, "halite_pickaxe");
		
		haliteShovel = (Item) new ItemHaliteShovel();
		GameRegistry.registerItem(haliteShovel, "halite_shovel");
	}
	
	public static void init() {
		GameRegistry.addSmelting(rockSalt, new ItemStack(haliteIngot), 1.0f);
		
		GameRegistry.addRecipe(new ItemStack(haliteSword, 1),
				new Object[] { "X1X", "X4X", "X7X", 
						Character.valueOf('1'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('4'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('7'),	new ItemStack(Items.stick, 1), 
					});
		
		GameRegistry.addRecipe(new ItemStack(haliteAxe, 1),
				new Object[] { "01X", "34X", "X7X", 
						Character.valueOf('0'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('1'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('3'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('4'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('7'), new ItemStack(Items.stick, 1), 
					});
		
		GameRegistry.addRecipe(new ItemStack(halitePickaxe, 1),
				new Object[] { "012", "X4X", "X7X", 
						Character.valueOf('0'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('1'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('2'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('4'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('7'), new ItemStack(Items.stick, 1), 
					});
		
		GameRegistry.addRecipe(new ItemStack(haliteShovel, 1),
				new Object[] { "X1X", "X4X", "X7X", 
						Character.valueOf('1'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('4'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('7'), new ItemStack(Items.stick, 1), 
					});
		
		GameRegistry.addRecipe(new ItemStack(haliteHoe, 1),
				new Object[] { "01X", "X4X", "X7X", 
						Character.valueOf('0'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1), 
						Character.valueOf('1'),	new ItemStack(ClothingCraftHaliteBlockList.haliteBlock, 1),
						Character.valueOf('4'),	new ItemStack(Items.stick, 1), 
						Character.valueOf('7'), new ItemStack(Items.stick, 1), });
	}
}
