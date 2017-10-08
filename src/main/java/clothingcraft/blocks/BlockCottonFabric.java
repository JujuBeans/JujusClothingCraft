/**
 *
 */
package clothingcraft.blocks;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * block of material resulting in combining rock salt
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/11/2017 01:55 PM (-07:00 GMT)
 */
public class BlockCottonFabric extends Block {

    protected BlockCottonFabric(Material mat) {
        super(mat);
        this.setHardness(1.0F);
        this.setResistance(3.0F);
        this.setLightLevel(15.0F);
        this.setBlockName("cotton_fabric_bundle");
        this.setBlockTextureName(ClothingCraftInfo.MODID + ":cotton_fabric_bundle");
        this.setLightOpacity(225);
        this.setStepSound(Block.soundTypeGravel);
        this.setCreativeTab(ClientProxy.tabCore);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.setHarvestLevel("pickaxe", 0);
    }

}
