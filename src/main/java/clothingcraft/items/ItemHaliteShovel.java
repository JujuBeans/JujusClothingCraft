/**
 *
 */
package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.ItemSpade;

/**
 * Item shovel made of Halite Blocks
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 10:02 PM (-7:00 GMT)
 */
public class ItemHaliteShovel extends ItemSpade {

    /**
     * Creates a new instance of Rock Salt
     */
    public ItemHaliteShovel() {
        super(ToolMaterial.STONE);
        setMaxDamage(2);
        setMaxStackSize(1);
        setUnlocalizedName("halite_shovel");
        setTextureName(ClothingCraftInfo.MODID + ":halite_shovel");
        setCreativeTab(ClientProxy.tabCore);
    }

}
