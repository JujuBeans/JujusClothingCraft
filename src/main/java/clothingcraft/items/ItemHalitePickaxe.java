/**
 *
 */
package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.ItemPickaxe;

/**
 * Item sword made of Halite Blocks
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 08:05 PM (-7:00 GMT)
 */
public class ItemHalitePickaxe extends ItemPickaxe {

    /**
     * Creates a new instance of Rock Salt
     */
    public ItemHalitePickaxe() {
        super(ToolMaterial.STONE);
        setMaxDamage(2);
        setMaxStackSize(1);
        setUnlocalizedName("halite_pickaxe");
        setTextureName(ClothingCraftInfo.MODID + ":halite_pickaxe");
        setCreativeTab(ClientProxy.tabCore);
    }

}
