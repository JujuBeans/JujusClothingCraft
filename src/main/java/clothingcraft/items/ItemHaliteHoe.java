/**
 *
 */
package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.ItemHoe;

/**
 * Item sword made of Halite Blocks
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 10:15 PM (-7:00 GMT)
 */
public class ItemHaliteHoe extends ItemHoe {

    /**
     * Creates a new instance of Rock Salt
     */
    public ItemHaliteHoe() {
        super(ToolMaterial.STONE);
        setMaxDamage(2);
        setMaxStackSize(1);
        setUnlocalizedName("halite_hoe");
        setTextureName(ClothingCraftInfo.MODID + ":halite_hoe");
        setCreativeTab(ClientProxy.tabCore);
    }

}
