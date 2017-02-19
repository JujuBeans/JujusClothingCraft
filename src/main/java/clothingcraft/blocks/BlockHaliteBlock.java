/**
 * 
 */
package clothingcraft.blocks;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * block of material resulting in combining rock salt
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 7:33 PM (-07:00 GMT)
 */
public class BlockHaliteBlock extends Block {

	protected BlockHaliteBlock(Material mat) {
		super(mat);
		this.setHardness(1.0F);
		this.setResistance(3.0F);
		this.setLightLevel(15.0F);
		this.setBlockName("halite_block");
		this.setBlockTextureName(ClothingCraftInfo.MODID + ":halite_block");
		this.setLightOpacity(225);
		this.setStepSound(Block.soundTypeGravel);
		this.setCreativeTab(ClothingCraft.tabCore);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setHarvestLevel("pickaxe", 0);
	}

}
