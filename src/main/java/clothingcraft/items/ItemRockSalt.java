/**
 *
 */
package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.item.Item;

/**
 * List of blocks and their registrations into the world
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 06:05 AM (-7:00 GMT)
 */
public class ItemRockSalt extends Item {

    /**
     * Creates a new instance of Rock Salt
     */
    public ItemRockSalt() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("rock_salt");
        this.setCreativeTab(ClientProxy.tabCore);
        this.setTextureName(ClothingCraftInfo.MODID + ":rock_salt");
    }

}
