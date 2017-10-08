/**
 *
 */
package clothingcraft.blocks;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import clothingcraft.core.CommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

/**
 * List of blocks and their registrations into the world
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 05:35 AM (-7:00 GMT)
 */
public class ClothingCraftCottonBlockList {

    public static BlockCottonBale cottonBale; // bale of cotton produce
    public static BlockCottonPlant cottonPlant; // the IGrowable plant
    public static BlockCottonWildPlant cottonWildPlant; // the IGrowable plant that is wild (placed on dirt or grass)

    public static void preInit() {
        // bale of cotton (bound)
        cottonBale = (BlockCottonBale) new BlockCottonBale(Material.ground)
                .setHardness(0.2F)
                .setResistance(0.5F)
                .setLightLevel(0.0F)
                .setBlockName("cotton_bale")
                .setBlockTextureName(ClothingCraftInfo.MODID + ":cotton_bale")
                .setLightOpacity(126)
                .setStepSound(Block.soundTypeGrass)
                .setCreativeTab(ClientProxy.tabCore);
        cottonBale.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        //Block.blockRegistry.addObject(192, "cotton_bale", cottonBale);
        cottonBale.setHarvestLevel("pickaxe", 0);
        GameRegistry.registerBlock(cottonBale, "cotton_bale");

        // cotton plant
        cottonPlant = (BlockCottonPlant) new BlockCottonPlant()
                .setHardness(0.0F)
                .setStepSound(Block.soundTypeGrass)
                .setResistance(0.0F)
                .setBlockName("cottonplant")
//                .setCreativeTab(ClientProxy.tabCore)
                .setBlockTextureName(ClothingCraftInfo.MODID + ":cottonplant");
        GameRegistry.registerBlock(cottonPlant, "cottonplant");

        // wild cotton plant
        cottonWildPlant = (BlockCottonWildPlant) new BlockCottonWildPlant()
                .setHardness(0.0F)
                .setStepSound(Block.soundTypeGrass)
                .setResistance(0.0F)
                .setBlockName("cottonwildplant")
//                .setCreativeTab(ClientProxy.tabCore)
                .setBlockTextureName(ClothingCraftInfo.MODID + ":cottonwildplant");
        GameRegistry.registerBlock(cottonWildPlant, "cottonwildplant");
    }

    public static void init() {
        GameRegistry.addRecipe(new ItemStack(cottonBale, 1),
                "012", "345", "678",
                '0', new ItemStack(CommonProxy.cotton, 1),
                '1', new ItemStack(CommonProxy.cotton, 1),
                '2', new ItemStack(CommonProxy.cotton, 1),
                '3', new ItemStack(CommonProxy.cotton, 1),
                '4', new ItemStack(CommonProxy.cotton, 1),
                '5', new ItemStack(CommonProxy.cotton, 1),
                '6', new ItemStack(CommonProxy.cotton, 1),
                '7', new ItemStack(CommonProxy.cotton, 1),
                '8', new ItemStack(CommonProxy.cotton, 1));
    }
}
