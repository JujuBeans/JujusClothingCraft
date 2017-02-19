/**
 * 
 */
package clothingcraft.items;


import java.util.LinkedHashMap;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import clothingcraft.items.ClothingCraftFabricItemList.COLORS;
import clothingcraft.items.ClothingCraftPatternItemList.CATEGORY;
import clothingcraft.items.ClothingCraftPatternItemList.PURPOSE;
import clothingcraft.util.RecipeUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/**
 * List of wardrobe items and their registrations into the world.
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/12/2017 07:39 PM (-7:00 GMT)
 */
public class ClothingCraftAccessoriesItemList {
	
	// accessoryItemMap, key to Item map
	public static LinkedHashMap<String, Item> accessoryItemMap = 
			new LinkedHashMap<String, Item>();
	
	public static Item purse;
	
	public static void preInit() {
		registerItemByKey("bouquetroses");
		registerItemByKey("purse");
		purse = getAccessoryItem("purse");
		registerItemByKey("satchelplaid");
		registerItemByKey("briefcase");
		registerItemByKey("smartphone");
		registerItemByKey("laptopcomputer");
		registerItemByKey("clipboard");
		registerItemByKey("pencil");
		registerItemByKey("paintbrush");
		registerItemByKey("paintpalette");
		registerItemByKey("hammer");
		registerItemByKey("wrench");
		registerItemByKey("meatcleaver");
		registerItemByKey("rollingpin");
		registerItemByKey("sushichopsticks");
		registerItemByKey("policebadge");
		registerItemByKey("giftblue");
		registerItemByKey("giftred");
		registerItemByKey("plushbunny");
		registerItemByKey("plushkitty");
		registerItemByKey("plushteddy");
		registerItemByKey("beachball");
		registerItemByKey("sandbucket");
		registerItemByKey("sandshovel");
		registerItemByKey("ukelele");
		registerItemByKey("ringengagement");
		registerItemByKey("ringsetwedding");
		registerItemByKey("fairywand");
		registerItemByKey("violin");
		registerItemByKey("violinbow");
		registerItemByKey("clarinet");
		registerItemByKey("harp");
	}
	
	public static void init() {
		// bouquetroses
		// purse
		// satchelplaid
		// briefcase
		// smartphone
		// laptopcomputer
		// clipboard
		// pencil
		// paintbrush
		// paintpalette
		// hammer
		// wrench
		// meatcleaver
		// rollingpin
		// sushichopsticks
		// policebadge
		// giftblue
		// giftred
		// plushbunny
		// plushkitty
		// plushteddy
		
		// beachball
		GameRegistry.addRecipe(new ItemStack(
				getAccessoryItem("beachball"), 1), 
				RecipeUtil.createRecipeObject(new Item[]{
						null, getFabric(COLORS.white), null,
						getFabric(COLORS.bluedark), Items.slime_ball, getFabric(COLORS.red),
						null, getFabric(COLORS.yellow), null
				})
			);
		
		// sandbucket
		// sandshovel
		// ukelele
		// ringengagement
		// ringsetwedding
		// fairywand
		// violin
		// violinbow
		// clarinet
		// harp
	}
	
	private static void registerItemByKey(String itemKey) {
		Item result = (Item) new Item()
				.setMaxStackSize(64)
				.setUnlocalizedName(ensurePrefix("accessory_",itemKey))
				.setCreativeTab(ClothingCraft.tabAccessories)
				.setTextureName(ClothingCraftInfo.MODID + ":" + ensurePrefix("accessory_",itemKey));
		accessoryItemMap.put("accessory_" + itemKey, result);
		GameRegistry.registerItem(result, ensurePrefix("accessory_",itemKey));
	}
	
	/**
	 * Resolves the stored wardrobe accessory item reference from the map container in this class
	 * @param accessoryKey String representation of map key: 
	 * 		REQUIRED, null value will throw an IlleagalArgumentException
	 * @return associated wardrobe accessory item, null if none exists
	 */
	public static Item getAccessoryItem(String accessoryKey) {
		Item result = null;
		if (accessoryKey!=null) {
			accessoryKey = ensurePrefix("accessory_", accessoryKey);
			result = accessoryItemMap.get(accessoryKey);
		} else {
			throw new IllegalArgumentException("null argument: accessoryKey");
		}
		return result;
	}
	
	/**
	 * Ensures the <CODE>inStr</CODE> starts with the <CODE>prefix</CODE>, if not prepends the prefix
	 * @param prefix value to prepend
	 * @param inStr value to ensure prefix starts with
	 * @return String value that starts with prefix
	 */
	private static String ensurePrefix(String prefix, String inStr) {
		String result = inStr;
		if (!inStr.startsWith(prefix)) {
			result = prefix + inStr;
		}
		return result;
	}
	
	/**
	 * Resolves the stored sewing pattern item reference from the map container in this class
	 * 
	 * @param enumCategory ClothingCraftPatternItemList.CATEGORY enumeration element
	 * @param enumPurpose ClothingCraftPatternItemList.PURPOSE enumeration element
	 * @return associated sewing pattern item, null if none exists
	 */
	public static Item getPattern(CATEGORY enumCategory, PURPOSE enumPurpose) {
		return ClothingCraftPatternItemList.patternsItemMap.get(enumCategory).get(enumPurpose);
	}
	
	/**
	 * Resolves the stored sewing fabric item reference from the map container in this class
	 * @param enumColor ClothingCraftFabricItemList.COLORS enumeration element
	 * @return associated sewing fabric item, null if none exists. 
	 */
	public static Item getFabric(COLORS enumColor) {
		return ClothingCraftFabricItemList.fabricItemsMap.get(enumColor);
	}
}
