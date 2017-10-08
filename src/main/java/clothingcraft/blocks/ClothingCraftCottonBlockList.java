/**
 *
 */
package clothingcraft.blocks;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
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
                .setCreativeTab(ClothingCraft.tabCore);
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
                //.setCreativeTab(ClothingCraft.tabCore)
                .setBlockTextureName(ClothingCraftInfo.MODID + ":cottonplant");
        GameRegistry.registerBlock(cottonPlant, "cottonplant");

        // wild cotton plant
        cottonWildPlant = (BlockCottonWildPlant) new BlockCottonWildPlant()
                .setHardness(0.0F)
                .setStepSound(Block.soundTypeGrass)
                .setResistance(0.0F)
                .setBlockName("cottonwildplant")
                //.setCreativeTab(ClothingCraft.tabCore)
                .setBlockTextureName(ClothingCraftInfo.MODID + ":cottonwildplant");
        GameRegistry.registerBlock(cottonWildPlant, "cottonwildplant");
    }

    public static void init() {
        GameRegistry.addRecipe(new ItemStack(cottonBale, 1),
                new Object[]{"012", "345", "678",
                        Character.valueOf('0'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('1'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('4'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('6'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('7'), new ItemStack(ClothingCraft.cotton, 1),
                        Character.valueOf('8'), new ItemStack(ClothingCraft.cotton, 1),
                });
    }
}
