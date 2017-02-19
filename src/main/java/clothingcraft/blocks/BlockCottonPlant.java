/**
 * 
 */
package clothingcraft.blocks;

import java.util.Random;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

/**
 * 
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/05/2017 09:01 PM
 *
 */
public class BlockCottonPlant extends RecipeBlockCrops
{
	public BlockCottonPlant()
    {
    	super(8);
    }
	
	/**
	 * @see clothingcraft.blocks.RecipeBlockCrops#canPlaceBlockOn(net.minecraft.block.Block)
	 */
	@Override
	protected boolean canPlaceBlockOn(Block parBlock) {
		return (parBlock == Blocks.farmland);
	}
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (parMetadata/2);
    }
    
    /**
     * @see clothingcraft.blocks.RecipeBlockCrops#getItemDropSeeds()
     */
    public Item getItemDropSeeds() {
    	return ClothingCraft.cottonSeeds;
    }
    
    /**
     * @see clothingcraft.blocks.RecipeBlockCrops#getItemDropProduce()
     */
    public Item getItemDropProduce() {
    	return ClothingCraft.cotton;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
          iIcon = new IIcon[maxGrowthStage+1];
          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
          // to make generic should loop to maxGrowthStage
          iIcon[0] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_0");
          iIcon[1] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_1");
          iIcon[2] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_2");
          iIcon[3] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_3");
          iIcon[4] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_4");
          iIcon[5] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_5");
          iIcon[6] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_6");
          iIcon[7] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_7");
          iIcon[8] = parIIconRegister.registerIcon(ClothingCraftInfo.MODID + ":cottonplant_stage_8");
    }

}