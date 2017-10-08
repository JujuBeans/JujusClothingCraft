package clothingcraft.items;

import clothingcraft.blocks.BlockCottonPlant;
import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;

/**
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/05/2017 09:01 PM
 */
public class ItemCottonSeeds extends RecipeItemSeeds {

    public ItemCottonSeeds(BlockCottonPlant cottonPlant, Block farmland) {
        super(cottonPlant, farmland);
        setUnlocalizedName("cotton_harvested");
        setTextureName(ClothingCraftInfo.MODID + ":cotton_harvested");
        setCreativeTab(ClothingCraft.tabCore);
    }
}