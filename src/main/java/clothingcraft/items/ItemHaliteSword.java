/**
 * 
 */
package clothingcraft.items;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.ItemSword;

/**
 * Item sword made of Halite Blocks
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 08:05 PM (-7:00 GMT)
 */
public class ItemHaliteSword extends ItemSword {

	/**
	 * Creates a new instance of Rock Salt
	 */
	public ItemHaliteSword() {
		super(ToolMaterial.STONE);
		setMaxDamage(2);
		setMaxStackSize(1);
		setUnlocalizedName("halite_sword");
		setTextureName(ClothingCraftInfo.MODID + ":halite_sword");
		setCreativeTab(ClothingCraft.tabCore);
	}

}
