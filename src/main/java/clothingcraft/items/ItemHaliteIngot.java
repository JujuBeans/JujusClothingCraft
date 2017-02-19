/**
 * 
 */
package clothingcraft.items;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.Item;

/**
 * List of blocks and their registrations into the world
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/17/2017 02:47 AM (-7:00 GMT)
 */
public class ItemHaliteIngot extends Item {

	/**
	 * Creates a new instance of Rock Salt
	 */
	public ItemHaliteIngot() {
		super();
		this.setMaxStackSize(64);
		this.setUnlocalizedName("halite_ingot");
		this.setCreativeTab(ClothingCraft.tabCore);
		this.setTextureName(ClothingCraftInfo.MODID + ":halite_ingot");
	}

}
